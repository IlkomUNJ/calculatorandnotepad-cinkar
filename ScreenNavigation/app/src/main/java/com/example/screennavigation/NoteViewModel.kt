package com.example.screennavigation

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel() {
    private val _notes = mutableStateListOf<String>()
    val notes: List<String> get() = _notes

    fun addNote(note: String) {
        _notes.add(note)
    }
}