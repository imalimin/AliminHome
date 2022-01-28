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
data class OpenProjectInfo(
        var name: String,
        var label: String,
        var type: String,
        var info: String,
        var url: String,
        @Id
        @GeneratedValue
        var id: Long = 0,
        @CreationTimestamp
        var cTime: Timestamp? = null,
        @ManyToOne(cascade = [CascadeType.REFRESH])
        @JoinColumn(name = "user_id")
        var user: User? = null) {
    constructor() : this("", "", "", "", "")
}