package com.alimin.home

import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
data class State<T>(var status: Int = 0,
                    var msg: String? = null,
                    var data: T? = null) {
    companion object {
        const val SUCCESS = 200
        const val FAIL = -1
        const val MSG_SUCCESS = "success"
        const val MSG_FAIL = "fail"
        fun <T> success(data: T): State<*> {
            val state = State<T>(SUCCESS, MSG_SUCCESS)
            state.data = data
            return state
        }

        fun fail(): State<*> {
            return fail(MSG_FAIL)
        }

        fun fail(msg: String): State<*> {
            return fail(FAIL, msg)
        }

        fun fail(status: Int, msg: String): State<*> {
            return State<Any>(status, msg)
        }
    }

    override fun toString(): String {
        return "State(status=$status, msg=$msg, data=$data)"
    }
}