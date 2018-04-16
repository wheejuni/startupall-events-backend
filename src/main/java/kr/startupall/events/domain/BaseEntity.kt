package kr.startupall.events.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseEntity {

    @field:CreatedDate
    @field:Column(name = "CREATED_TIME")
    private var createdDate: LocalDateTime? = null

    fun getCreatedDate(): LocalDateTime {
        return this.createdDate!!
    }

    fun setCreatedDate(dateTime: LocalDateTime) {
        this.createdDate = dateTime
    }

    fun getStringCreatedDate(): String {
        return generateDateString(this.createdDate!!)
    }

    private fun generateDateString(dateTime: LocalDateTime) : String {
        val format: String = "yyyy.MM.dd"
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern(format)

        return formatter.format(dateTime)
    }
}