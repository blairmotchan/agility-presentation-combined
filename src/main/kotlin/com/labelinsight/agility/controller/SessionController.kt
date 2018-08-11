package com.labelinsight.agility.controller

import com.labelinsight.agility.command.SessionCommand
import com.labelinsight.agility.domain.Session
import com.labelinsight.agility.repository.SessionRepository
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/session")
class SessionController(
        private val sessionRepository: SessionRepository
) {
    @RequestMapping(method = [GET])
    fun getSessions(): MutableIterable<Session> {
        return sessionRepository.findAll()
    }

    @RequestMapping(method = [GET], value = "/{sessionId}")
    fun getSession(@PathVariable sessionId: Long): Optional<Session> {
        return sessionRepository.findById(sessionId)
    }

    @RequestMapping(method = [POST])
    fun createSession(@RequestBody command: SessionCommand): Session {
        val session = Session(0, command.name, HashSet())
        sessionRepository.save(session)
        return session
    }
}