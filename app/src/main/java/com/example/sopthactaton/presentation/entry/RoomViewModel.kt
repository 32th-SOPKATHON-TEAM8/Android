package com.example.sopthactaton.presentation.entry

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RoomViewModel : ViewModel(){

    val _code = MutableLiveData("")
    val code: String
        get() = requireNotNull(_code.value).trim()


    val _nickname = MutableLiveData("")
    val nickname: String
        get() = _nickname.value?.trim() ?: ""



    private val _isCodeValid = MutableLiveData<Boolean>()
    private val _isNickNameValid = MutableLiveData<Boolean>()

    val isValidAndFilled: LiveData<Boolean> = MediatorLiveData<Boolean>().apply {
        addSource(_isCodeValid) { value = validateFields() }
        addSource(_isNickNameValid) { value = validateFields() }
    }

    init {
        _isCodeValid.value = false
        _isNickNameValid.value = false
    }
    private fun validateFields(): Boolean {
        return _isCodeValid.value == true
                && _isNickNameValid.value == true
    }

    fun validateNickName(text: String) {
        _isNickNameValid.value = text.trim().length in 5..10
    }


}