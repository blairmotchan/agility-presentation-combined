package com.labelinsight.agility.registration.config

import com.labelinsight.agility.registration.receiver.Receiver
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class QueueConfiguration {
    private val topicExchangeName = "agility-exchange"
    private val queueName = "registration"

    @Bean
    open fun queue(): Queue {
        return Queue(queueName, true)
    }

    @Bean
    open fun exchange(): TopicExchange {
        return TopicExchange(topicExchangeName)
    }

    @Bean
    open fun binding(queue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with("agility.registration.#")
    }

    @Bean
    open fun listenerAdapter(receiver:Receiver):MessageListenerAdapter {
        return MessageListenerAdapter(receiver, "receiveMessage")
    }

    @Bean
    open fun container(connectionFactory: ConnectionFactory, listenerAdapter: MessageListenerAdapter):SimpleMessageListenerContainer {
        val container = SimpleMessageListenerContainer(connectionFactory)
        container.setQueueNames(queueName)
        container.setMessageListener(listenerAdapter)

        return container
    }
}