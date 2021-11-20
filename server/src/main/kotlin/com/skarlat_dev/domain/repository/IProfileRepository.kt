package com.skarlat_dev.domain.repository

import com.skarlat_dev.domain.entities.ProfileEntity

interface IProfileRepository {
    fun getProfile(token: String): ProfileEntity
}