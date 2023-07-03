package kg.geeks.geeksmentor.presentation.data.viewmodel

//import com.abit8.geeksmentor.data.repository.MentorsRepositoryImpl

/*class MentorListViewModel(private val repository: MentorsRepositoryImpl) : ViewModel() {
    private val _mentors = MutableLiveData<List<MentorList>>()
    val mentors: LiveData<List<MentorList>> get() = _mentors

    fun loadMentors() {
        viewModelScope.launch {
            try {
                val mentorList = repository.getMentors()
                _mentors.value = mentorList
            } catch (e: Exception) {
                // Обработка ошибки
            }
        }
    }

}*/

