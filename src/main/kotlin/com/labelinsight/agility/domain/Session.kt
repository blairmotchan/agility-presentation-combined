package com.labelinsight.agility.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.persistence.CascadeType.ALL

@Entity
data class Session(@Id @GeneratedValue val id: Long,
                   val name: String,
                   @JsonIgnore @ManyToMany(cascade = [ALL], fetch = FetchType.EAGER) val attendees: MutableSet<Attendee>)