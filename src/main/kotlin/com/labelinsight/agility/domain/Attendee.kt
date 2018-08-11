package com.labelinsight.agility.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.CascadeType.ALL
import javax.persistence.Entity
import javax.persistence.FetchType.EAGER
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Attendee(@Id @GeneratedValue val id: Long = 0,
                    val name: String,
                    @JsonIgnore @ManyToMany(cascade = [ALL], fetch = EAGER) val sessions: MutableSet<Session>)



