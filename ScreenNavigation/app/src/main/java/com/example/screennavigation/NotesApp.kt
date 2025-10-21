package com.example.screennavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.material.icons.automirrored.filled.ArrowBack


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesApp(
    navController: NavHostController,
    notes: List<String>
) {
//    val navController = rememberNavController()
//    var notes by remember { mutableStateOf(listOf<String>()) }
//    var newNoteText by remember { mutableStateOf("") }
//    var showTambahCatatan by remember { mutableStateOf(false) }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text("Notes App") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate("mainScreen")
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("addNote")
            }) {
                Icon(Icons.Filled.Add, contentDescription = "Tambah Catatan")            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (notes.isEmpty()) {
                Text("Belum ada catatan")
            } else {
                notes.forEach { note ->
                    Text(
                        text = note,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }

    }

}


