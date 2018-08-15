package com.labelinsight.agility.registration.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class RegistrationRequest(
        @JsonProperty("requestId")
        val requestId: Long,
        @JsonProperty("attendeeId")
        val attendeeId: Long,
        @JsonProperty("sessionId")
        val sessionId: Long)