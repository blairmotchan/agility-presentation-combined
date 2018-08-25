package com.agilemidwest.agility.repository

import com.agilemidwest.agility.domain.AttendeeSession
import com.agilemidwest.agility.domain.Session
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionRepository: CrudRepository<Session, Long> {

    @Query(value = "SELECT * FROM SESSION s WHERE s.id not in (SELECT session_id from ATTENDEE_SESSION where attendee_id = :id)", nativeQuery = true)
    fun findAvailableSessionsByAttendeeId(id: Long): Iterable<Session>
}