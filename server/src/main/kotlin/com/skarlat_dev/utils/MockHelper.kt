package com.skarlat_dev.utils

import com.skarlat_dev.domain.entities.ChallengeEntity
import data.models.AntropometricInfo
import data.models.Profile
import data.models.Sex
import data.models.StepRecord

object MockHelper {
    fun getChallenges() = listOf(
        ChallengeEntity(id = "1", title = "Приветствие", "Добро пожаловать в ОРБИ Челлендж!"),
        ChallengeEntity(id = "2", title = "Бег", "Легкий бег помогает быть здоровым"),
        ChallengeEntity(id = "3", title = "Шаги", "Беговые шаги"),
    )

    fun getProfile() =
        Profile(firstName = "Denis", secondName = "Denisov", birthday = "01.09.1998", email = "bboyzlodey@gmail.com")

    fun getStepRecords() = listOf<StepRecord>(
        StepRecord(id = "1", date = "01.09.1998", stepsCount = 500),
        StepRecord(id = "2", date = "02.09.1998", stepsCount = 500),
        StepRecord(id = "3", date = "03.09.1998", stepsCount = 500),
        StepRecord(id = "4", date = "04.09.1998", stepsCount = 500),
        StepRecord(id = "5", date = "05.09.1998", stepsCount = 500),
        StepRecord(id = "6", date = "06.09.1998", stepsCount = 500),
        StepRecord(id = "7", date = "07.09.1998", stepsCount = 500),
    )

    fun getAntropometricInfo() =
        AntropometricInfo(sex = Sex.MAN, weight = 50f, height = 172)
}