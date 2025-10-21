package com.example.screennavigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Nav(){
    val navController = rememberNavController()
    val noteViewModel: NoteViewModel = viewModel()
    NavHost(navController= navController, startDestination = "MainScreen"){
        composable(route = "screenA"){
            ScreenA(navController)
        }
        composable(route = "screenB"){
            ScreenB(navController)
        }
        composable(route = "MainScreen"){
            MainScreen(navController)
        }
        composable(route = "notesApp"){
            val notes = noteViewModel.notes
            NotesApp(
                navController = navController,
                notes = notes
            )
        }
        composable(route = "addNote"){
            addNote(
                onSimpan = { newNote ->
                    noteViewModel.addNote(newNote)
                    navController.popBackStack()
                },
                onBatal = {
                    navController.popBackStack()
                },
                navController = navController
            )
        }
        composable(route = "Calc"){
            Calc(navController)
        }


    }
}