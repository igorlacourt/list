package com.list.test

import androidx.lifecycle.*

// init time: 13:18
class MainViewModel : ViewModel() {

    val repository: Repository = Repository()

    private var _word = MutableLiveData<String?>()

    val list: LiveData<List<String>> = _word.switchMap {
        repository.getList(it)
    }

    init {
        setWord(null)
    }

    fun setWord(word: String?) {
        _word.value = word
    }
}

class Repository {
    private val wordsList = mutableListOf("rice", "beans", "salsage", "meat", "pork")

    fun getList(word: String?) : LiveData<List<String>> {
        word?.let{ wordsList.remove(word) }
        return MutableLiveData<List<String>>(wordsList)
    }
}