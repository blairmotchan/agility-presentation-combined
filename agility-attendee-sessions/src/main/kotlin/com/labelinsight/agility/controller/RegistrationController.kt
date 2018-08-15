package com.labelinsight.agility.controller

import com.labelinsight.agility.command.RegistrationCommand
import com.labelinsight.agility.domain.AttendeeSession
import com.labelinsight.agility.service.RegistrationService
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMethod.POST
import java.util.*

@RestController
@RequestMapping("/registration")
class RegistrationController(
        private val registrationService: RegistrationService
) {
    @RequestMapping(method = [POST])
    @ResponseStatus(OK)
    fun register(@RequestBody registrationCommand: RegistrationCommand) {
        registrationService.register(registrationCommand)
    }

    @RequestMapping("/attendee/{attendeeId}/sessions")
    fun getSessionsForAttendee(@PathVariable attendeeId: Long): List<AttendeeSession> {
        return Collections.emptyList()
    }

    @RequestMapping("/session/{sessionId}/attendees")
    fun getAttendeesForSession(@PathVariable sessionId: Long): List<AttendeeSession> {
        return Collections.emptyList()
    }
}