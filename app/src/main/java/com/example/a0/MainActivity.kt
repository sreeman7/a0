package com.example.a0

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a0.ui.theme.A0Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A0Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DecisionMaker(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DecisionMaker(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf("Click a button") }
    var clickCount by remember { mutableStateOf(0) }

    Column(modifier = modifier.padding(20.dp)) {

        Text("Japan Restaurant Decision Maker")
        Text("Should I try this restaurant?")

        Button(
            onClick = {
                clickCount++

                val number = (1..100).random()

                if (number <= 50) {
                    result = "Yes"
                } else {
                    result = "No"
                }
            }
        ) {
            Text("Must Try it")
        }

        Button(
            onClick = {
                clickCount++

                val number = (1..100).random()

                if (number <= 25) {
                    result = "Yes"
                } else {
                    result = "No"
                }
            }
        ) {
            Text("Maybe")
        }

        Button(
            onClick = {
                clickCount++

                val number = (1..100).random()

                if (number <= 10) {
                    result = "Yes"
                } else {
                    result = "No"
                }
            }
        ) {
            Text("Skip it")
        }

        Text("Decision: $result")
        Text("Total Clicks: $clickCount")

        Text("CCID: gokula")
        Text("Student ID: 1890086")
    }
}

@Preview(showBackground = true)
@Composable
fun DecisionMakerPreview() {
    A0Theme {
        DecisionMaker()
    }
}