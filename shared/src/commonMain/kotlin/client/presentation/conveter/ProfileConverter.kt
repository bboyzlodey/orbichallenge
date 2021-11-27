package client.presentation.conveter

import client.business.model.ProfileBusiness
import client.presentation.model.ProfileInfoUI

class ProfileConverter {
    fun toUIModel(business: ProfileBusiness): ProfileInfoUI =
        ProfileInfoUI(
            email = business.email,
            firstName = business.firstName,
            secondName = business.secondName
        )
}