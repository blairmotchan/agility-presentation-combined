package com.labelinsight.agility.repository

import com.labelinsight.agility.domain.Session
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SessionRepository: CrudRepository<Session, Long>