package com.labelinsight.agility.registration.receiver

import com.fasterxml.jackson.databind.ObjectMapper
import com.labelinsight.agility.registration.domain.RegistrationConfirmation
import com.labelinsight.agility.registration.domain.RegistrationRequest
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import java.util.concurrent.CountDownLatch

@Component
open class QueueService(
        private val tempalate: RabbitTemplate,
        @Qualifier("confirmationQueue")
        private val confirmationQueue: Queue) {
    private var latch: CountDownLatch = CountDownLatch(1)
    private var objectMapper = ObjectMapper()

    fun receiveMessage(payload: Object) {
        val json = String(payload as ByteArray)
        try {
            val message = objectMapper.readValue(json, RegistrationRequest::class.java)
            println(message)
            sendMessage(RegistrationConfirmation(1, true))
        } catch (ignored: Exception) {
            println(ignored)
        }
        latch.countDown()
    }

    fun sendMessage(confirmation: RegistrationConfirmation) {
        tempalate.convertAndSend(confirmationQueue.name, confirmation)
    }

    fun getLatch(): CountDownLatch {
        return latch
    }
}