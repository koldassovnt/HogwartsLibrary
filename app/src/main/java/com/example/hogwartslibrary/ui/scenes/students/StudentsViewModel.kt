package com.example.hogwartslibrary.ui.scenes.students

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hogwartslibrary.domain.repositories.StudentsRepository
import com.example.hogwartslibrary.domain.repositories.StudentsRepositoryImpl
import com.example.hogwartslibrary.ui.scenes.students.adapters.StudentCellModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StudentsViewModel : ViewModel() {

    private val studentsRepository = StudentsRepositoryImpl()

    private val _students = MutableLiveData<List<StudentCellModel>>().apply {
        value = ArrayList()
    }
    private val _isLoading = MutableLiveData<Boolean>().apply { value = false }

    val students: LiveData<List<StudentCellModel>> = _students
    val isLoading: LiveData<Boolean> = _isLoading

    fun fetchStudents() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            withContext(Dispatchers.Default) {
                val students = studentsRepository.fetchStudents()
                _isLoading.postValue(false)
                _students.postValue(students.map { StudentCellModel(
                    id = it.id, name = "${it.name} ${it.surname}", facultyName = it.facultyName
                ) })
            }
        }
    }
}