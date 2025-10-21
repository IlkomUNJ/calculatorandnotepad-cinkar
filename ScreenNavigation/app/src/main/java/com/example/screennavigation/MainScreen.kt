package com.example.screennavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navController: NavHostController){
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is main screen", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(65.dp))
        Button(onClick =  {
            navController.navigate("ScreenA"){
                popUpTo("MainScreen"){
                    inclusive = true
                }
            }
        }) {
            Text("go to screen A", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick =  {
            navController.navigate("ScreenB"){
                popUpTo("MainScreen"){
                    inclusive = true
                }
            }
        }) {
            Text("go to screen B", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick =  {
            navController.navigate("NotesApp"){
                popUpTo("MainScreen"){
                    inclusive = true
                }
            }
        }) {
            Text("Notes", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick =  {
            navController.navigate("Calc"){
                popUpTo("Calc"){
                    inclusive = true
                }
            }
        }) {
            Text("Calculator", fontSize = 20.sp)
        }
    }
}