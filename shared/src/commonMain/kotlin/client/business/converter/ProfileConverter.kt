package client.business.converter

import client.business.model.ProfileBusiness
import data.models.Profile

class ProfileConverter {
    fun convert(networkModel: Profile): ProfileBusiness = ProfileBusiness(
        firstName = networkModel.firstName,
        secondName = networkModel.secondName,
        email = networkModel.email,
        birthday = networkModel.birthday
    )
}