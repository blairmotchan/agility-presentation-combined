package com.agilemidwest.agility.service

import com.agilemidwest.agility.command.RegistrationCommand
import com.agilemidwest.agility.domain.AttendeeSession
import com.agilemidwest.agility.repository.AttendeeRepository
import com.agilemidwest.agility.repository.AttendeeSessionRepository
import com.agilemidwest.agility.repository.SessionRepository
import org.springframework.stereotype.Service

@Service
class RegistrationService(
        private val attendeeSessionRepository: AttendeeSessionRepository,
        private val sessionRepository: SessionRepository,
        private val attendeeRepository: AttendeeRepository
) {
    fun register(registrationCommand: RegistrationCommand) {
        val attendee = attendeeRepository.findById(registrationCommand.attendeeId).get()
        val session = sessionRepository.findById(registrationCommand.sessionId).get()
        attendeeSessionRepository.save(AttendeeSession(null, session, attendee))
    }
}