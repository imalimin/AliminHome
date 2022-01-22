package com.alimin.home.model.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.hibernate.annotations.CreationTimestamp
import java.sql.Timestamp
import javax.persistence.*

@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
data class User(
        var name: String,
        var age: Int,
        var ageWork: Float,
        var gender: String,
        var phone: String? = null,
        var email: String? = null,
        @Id
        @GeneratedValue
        var id: Long = 0,
        @CreationTimestamp
        var cTime: Timestamp? = null
) {
    constructor() : this("", 0, 0.0f, "")
}