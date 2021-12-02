package com.skarlat_dev.domain.interactor

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import com.skarlat_dev.domain.converters.IProfileConverter
import com.skarlat_dev.domain.entities.ProfileEntity
import com.skarlat_dev.domain.repository.IProfileRepository
import data.models.Profile

class AuthInteractor(
    private val profileRepository: IProfileRepository,
    private val profileConverter: IProfileConverter
) : IAuthInteractor {
    override suspend fun authenticateByGoogleToken(token: String): String {
        val profile = getOrCreateProfileByToken(token)
        return createNewSession(profile)
    }

    private suspend fun getOrCreateProfileByToken(token: String): Profile {
        val uid = FirebaseAuth.getInstance().verifyIdToken(token).uid
        val profile = profileRepository.getProfile(uid) ?: createNewProfile(uid)
        return profileConverter.fromEntityToNetwork.map(profile)
    }

    private suspend fun createNewProfile(userUid: String): ProfileEntity {
        val user = FirebaseAuth.getInstance().getUser(userUid)
        val newProfile = user.convertToProfile()
        profileRepository.putProfile(newProfile)
        return profileRepository.getProfile(userUid)
            ?: throw IllegalStateException("ProfileEntity not wrote to database. Profile: $newProfile")
    }

    private suspend fun createNewSession(profile: Profile): String {
        return "mocked_session"
    }
}

private fun UserRecord.convertToProfile(): ProfileEntity {
    val firstName = displayName.substringBefore(' ')
    val secondName = displayName.substringAfter(' ')

    return ProfileEntity(
        id = uid,
        firstName = firstName,
        secondName = secondName,
        email = email,
        birthday = ""
    )
}