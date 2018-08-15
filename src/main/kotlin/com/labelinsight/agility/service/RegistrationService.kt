package com.labelinsight.agility.service

import com.labelinsight.agility.command.RegistrationCommand
import com.labelinsight.agility.domain.AttendeeSession
import com.labelinsight.agility.repository.AttendeeRepository
import com.labelinsight.agility.repository.AttendeeSessionRepository
import com.labelinsight.agility.repository.SessionRepository
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