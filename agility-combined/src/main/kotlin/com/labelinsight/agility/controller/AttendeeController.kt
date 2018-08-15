package com.labelinsight.agility.controller

import com.labelinsight.agility.command.AttendeeCommand
import com.labelinsight.agility.domain.Attendee
import com.labelinsight.agility.repository.AttendeeRepository
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.GET
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.HashSet

@RestController
@RequestMapping("/attendee")
class AttendeeController(
        private val attendeeRepository: AttendeeRepository
) {
    @RequestMapping(method = [GET])
    fun getAttendees(): MutableIterable<Attendee> {
        return attendeeRepository.findAll()
    }

    @RequestMapping(method = [GET], value = "/{attendeeId}")
    fun getAttendee(@PathVariable attendeeId: Long): Optional<Attendee> {
        return attendeeRepository.findById(attendeeId)
    }

    @RequestMapping(method = [POST])
    fun createAttendee(@RequestBody command: AttendeeCommand): Attendee {
        val attendee = Attendee(0, command.name)
        attendeeRepository.save(attendee)
        return attendee
    }
}