package com.skarlat_dev.domain.repository

interface IProfileRepository {
    fun getProfile(token: String)
}