package com.proptelligencenet.proptelligence

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    var name by remember { mutableStateOf("") }
    var isNameValid by remember { mutableStateOf(false) }

    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(false) }

    var mobileNumber by remember { mutableStateOf("") }
    var isMobileNumberValid by remember { mutableStateOf(false) }

    var squareFeet by remember { mutableStateOf("") }
    var isSquareFeetValid by remember { mutableStateOf(false) }

    var selectedBHK by remember { mutableStateOf("2BHK") }
    var expanded by remember { mutableStateOf(false) }

    val isFormValid by remember {
        derivedStateOf {
            isNameValid && isEmailValid && isMobileNumberValid && isSquareFeetValid
        }
    }


    CustomDrawer(
        navController = navController,
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = { CustomTopAppBar(navController, coroutineScope, drawerState) },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                    .padding(top = 50.dp, start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(100.dp))

                OutlinedTextField(
                    value = name,
                    singleLine = true,
                    onValueChange = { name = it
                        isNameValid = it.isNotBlank() },
                    label = { Text("Name", color = Color.Black) },
                    modifier = Modifier.padding(bottom = 8.dp),
                    isError = !isNameValid,
                    textStyle = TextStyle(color = Color.Black)
                    )

                OutlinedTextField(
                    value = email,
                    singleLine = true,
                    onValueChange = { email = it
                        isEmailValid = it.isNotBlank()},
                    label = { Text("Email", color = Color.Black) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier.padding(bottom = 8.dp),
                    isError = !isEmailValid,
                    textStyle = TextStyle(color = Color.Black)
                )

                OutlinedTextField(
                    value = mobileNumber,
                    singleLine = true,
                    onValueChange = { mobileNumber = it
                        isMobileNumberValid = it.isNotBlank()},
                    label = { Text("Mobile Number", color = Color.Black) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    modifier = Modifier.padding(bottom = 8.dp),
                    isError = !isMobileNumberValid,
                    textStyle = TextStyle(color = Color.Black)
                )
                OutlinedTextField(
                    value = squareFeet,
                    singleLine = true,
                    onValueChange = { squareFeet = it
                        isSquareFeetValid = it.isNotBlank()},
                    label = { Text("Square Feet", color = Color.Black) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.padding(bottom = 8.dp),
                    isError = !isSquareFeetValid,
                    textStyle = TextStyle(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = { expanded = true },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#b1c7ff"))),
                    modifier = Modifier
                        .width(280.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(8.dp))

                ) {
                    Text(text = selectedBHK)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")

                    DropdownMenu(expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier.background(Color.White) // Set the background color of the dropdown menu
                        ) {

                        DropdownMenuItem(text = { Text(text = "2BHK", color = Color.Black) }, onClick = {
                            expanded = false
                            selectedBHK = "2BHK"
                        })
                        DropdownMenuItem(text = { Text(text = "3BHK", color = Color.Black) }, onClick = {
                            expanded = false
                            selectedBHK = "3BHK"
                        })
                        DropdownMenuItem(text = { Text(text = "4BHK", color = Color.Black) }, onClick = {
                            expanded = false
                            selectedBHK = "4BHK"
                        })
                    }


                }
                
                Spacer(modifier = Modifier.height(30.dp))

                // Add a button to submit the form data (you'll need to handle the submission logic)
                Button(onClick = { /* Handle form submission */ },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .width(280.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    colors = ButtonDefaults.buttonColors(Color(android.graphics.Color.parseColor("#32357A"))),
                    enabled = isFormValid
                    )
                {
                    Text("Submit", color = Color.White)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormScreenPreview(){
    FormScreen(rememberNavController())
}