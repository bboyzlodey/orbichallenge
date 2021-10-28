package com.skarlat_dev.domain.storage

import com.skarlat_dev.domain.entities.AntropometricInfoEntity
import com.skarlat_dev.domain.entities.ProfileEntity
import com.skarlat_dev.domain.entities.StepRecordEntity
import data.models.AntropometricInfo

class MockEntityStorage : EntityStorage {
    override fun getProfileEntity(token: String): ProfileEntity {
        TODO("Not yet implemented")
    }

    override fun getStepRecords(token: String): List<StepRecordEntity> {
        TODO("Not yet implemented")
    }

    override fun getAntropometricInfo(token: String): AntropometricInfo {
        TODO("Not yet implemented")
    }

    override fun updateProfile(profile: ProfileEntity) {}
    override fun createProfile(profile: ProfileEntity) {}
    override fun setAntropometricInfo(antropometricInfo: AntropometricInfoEntity){}
}