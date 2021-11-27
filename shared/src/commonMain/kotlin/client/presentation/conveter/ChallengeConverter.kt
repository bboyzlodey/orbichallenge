package client.presentation.conveter

import client.business.model.ChallengeBusiness
import client.presentation.model.ChallengeUI

class ChallengeConverter {
    fun toUIModel(business: ChallengeBusiness): ChallengeUI =
        ChallengeUI(
            id = business.id,
            imageUrl = business.imageUrl,
            title = business.title,
            description = business.description
        )
}