package com.example.screennavigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

@Composable
fun addNote(
    onSimpan: (String) -> Unit,
    onBatal: () -> Unit,
    navController: NavHostController
) {
    var newNoteText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Tambah Catatan",
            style = MaterialTheme.typography.titleLarge,

        )

        OutlinedTextField(
            value = newNoteText,
            onValueChange = { newNoteText = it },
            label = { Text("Tulis catatan...") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    if (newNoteText.isNotBlank()) {
                        onSimpan(newNoteText)
                    }
                }
            ) {
                Text("Simpan")
            }

            OutlinedButton(onClick = { onBatal() }) {
                Text("Batal")
            }
        }
    }
}


