package com.labelinsight.agility.registration.receiver

import org.springframework.stereotype.Component
import java.util.concurrent.CountDownLatch

@Component
class Receiver {
    private var latch: CountDownLatch

    init {
        latch = CountDownLatch(1)
    }

    fun recieveMessage(message:String) {
        println(message)
        latch.countDown()
    }

    fun getLatch():CountDownLatch {
        return latch
    }
}