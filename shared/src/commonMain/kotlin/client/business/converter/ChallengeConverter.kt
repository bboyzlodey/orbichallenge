package client.business.converter

import client.business.model.ChallengeBusiness
import data.models.Challenge

class ChallengeConverter {
    fun convert(networkModel: Challenge) : ChallengeBusiness = ChallengeBusiness(
        id = networkModel.id,
        title = networkModel.title,
        description = networkModel.description,
        imageUrl = networkModel.imageUrl
    )
}