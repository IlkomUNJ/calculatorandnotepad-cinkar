package com.example.screennavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import net.objecthunter.exp4j.ExpressionBuilder


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calc(navController: NavHostController){
    var input by remember { mutableStateOf("") }
    var showScientific by remember { mutableStateOf(false) }

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
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.White),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = if (input.isEmpty()) "0" else input,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.End
                )
            }

            if (showScientific) {
                ScientificButtons(onButtonClick = { label ->
                    input = handleInput(input, label, onToggleScientific = { showScientific = !showScientific })
                })
            }

            // Basic Buttons selalu tampil
            BasicButtons(onButtonClick = { label ->
                input = handleInput(input, label, onToggleScientific = { showScientific = !showScientific })
            })
        }

    }
}

fun handleInput(input: String, label: String, onToggleScientific: () -> Unit): String {
    return when(label) {
        "C" -> ""
        "=" -> {
            try {
                val result = ExpressionBuilder(input).build().evaluate()
                result.toString()
            } catch (e: Exception) {
                "Error"
            }
        }
        "Sc" -> { // toggle scientific
            onToggleScientific()
            input
        }
        else -> input + label
    }
}

@Composable
fun ScientificButtons(onButtonClick: (String) -> Unit) {
    val sciButtons = listOf(
        listOf("INV","Sin","Cos","Tan"),
        listOf("Ln","Log","Src","x^y")
    )

    sciButtons.forEach { row ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            row.forEach { label ->
                CalculatorButton(label = label) {
                    onButtonClick(label)
                }
            }
        }
    }
}

@Composable
fun BasicButtons(onButtonClick: (String) -> Unit) {
    val basicButtons = listOf(
        listOf("7","8","9","/"),
        listOf("4","5","6","*"),
        listOf("1","2","3","-"),
        listOf("0","(",")","+"),
        listOf("Sc", "C", ".", "=")
    )

    basicButtons.forEach { row ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            row.forEach { label ->
                CalculatorButton(label = label) {
                    onButtonClick(label)
                }
            }
        }
    }
}

@Composable
fun RowScope.CalculatorButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .weight(1f) // weight benar karena RowScope
            .height(60.dp)
    ) {
        Text(text = label, fontSize = 20.sp)
    }
}