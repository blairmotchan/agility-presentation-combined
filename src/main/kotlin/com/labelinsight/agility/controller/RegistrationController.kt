package com.labelinsight.agility.controller

import com.labelinsight.agility.command.RegistrationCommand
import com.labelinsight.agility.service.RegistrationService
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/registration")
class RegistrationController (
        private val registrationService: RegistrationService
) {
    @RequestMapping(method = [POST])
    @ResponseStatus(OK)
    fun register(@RequestBody registrationCommand: RegistrationCommand) {
        registrationService.register(registrationCommand)
    }
}