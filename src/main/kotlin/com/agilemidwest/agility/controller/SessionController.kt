package com.agilemidwest.agility.controller

import com.agilemidwest.agility.command.SessionCommand
import com.agilemidwest.agility.domain.Session
import com.agilemidwest.agility.repository.SessionRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST
import java.util.*

@CrossOrigin
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
        val session = Session(0, command.name)
        sessionRepository.save(session)
        return session
    }

    @RequestMapping(method = [GET], params = ["attendee_id"])
    fun getSessionsAvailableByAttendeeId(@RequestParam("attendee_id") attendeeId: Long): Iterable<Session> {
        return sessionRepository.findAvailableSessionsByAttendeeId(attendeeId);
    }
}