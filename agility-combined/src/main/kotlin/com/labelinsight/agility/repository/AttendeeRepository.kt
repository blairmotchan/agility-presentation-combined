package com.labelinsight.agility.repository

import com.labelinsight.agility.domain.Attendee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AttendeeRepository : CrudRepository<Attendee, Long>