package com.skarlat_dev.domain.storage

import com.skarlat_dev.domain.entities.AntropometricInfoEntity
import com.skarlat_dev.domain.entities.ProfileEntity
import com.skarlat_dev.domain.entities.StepRecordEntity
import data.models.AntropometricInfo

interface EntityStorage {

    fun getProfileEntity(token: String): ProfileEntity
    fun getStepRecords(token: String): List<StepRecordEntity>
    fun getAntropometricInfo(token: String): AntropometricInfo

    fun updateProfile(profile: ProfileEntity)

    fun createProfile(profile: ProfileEntity)
    fun setAntropometricInfo(antropometricInfo: AntropometricInfoEntity)
}