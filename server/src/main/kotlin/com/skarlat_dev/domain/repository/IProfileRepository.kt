package com.skarlat_dev.domain.repository

import com.skarlat_dev.domain.entities.ProfileEntity

interface IProfileRepository {
    suspend fun getProfile(uuid: String): ProfileEntity?
    fun putProfile(profile: ProfileEntity)
}