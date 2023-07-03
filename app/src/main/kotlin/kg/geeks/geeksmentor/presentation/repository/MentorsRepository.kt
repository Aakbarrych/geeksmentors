package kg.geeks.geeksmentor.presentation.repository

import kg.geeks.geeksmentor.data.model.MentorList

interface MentorsRepository {
    suspend fun getMentors(): List<MentorList>
}

