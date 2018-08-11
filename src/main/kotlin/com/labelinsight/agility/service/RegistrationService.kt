package com.labelinsight.agility.service

import com.labelinsight.agility.command.RegistrationCommand
import com.labelinsight.agility.repository.AttendeeRepository
import com.labelinsight.agility.repository.SessionRepository
import org.springframework.stereotype.Service

@Service
class RegistrationService(
        private val attendeeRepository: AttendeeRepository,
        private val sessionRepository: SessionRepository
) {
    fun register(registrationCommand: RegistrationCommand) {
        val attendee = attendeeRepository.findById(registrationCommand.attendeeId).get()
        val session = sessionRepository.findById(registrationCommand.sessionId).get()
        attendee.sessions.add(session)
        attendeeRepository.save(attendee)
    }
}