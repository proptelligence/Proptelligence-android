package com.proptelligencenet.proptelligence


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun EditProfileScreen(navController: NavController) {
    val enterNumberColor = Color(0xFF545151)
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
            .pointerInput(Unit) {
                detectTapGestures(onTap = { _ ->
                    keyboardController?.hide()
                })
            },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
                .padding(16.dp)
        ) {
            IconButton(onClick = { navController.navigate("profile")}) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
            }

        }
        Text(text = "Edit Profile", fontSize = 24.sp, fontWeight = FontWeight.Bold
            ,color = Color(android.graphics.Color.parseColor("#32357A")))

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.spongebob),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(130.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Change Picture?",
            modifier = Modifier.clickable {
                // Handle text click, open image picker

            },
            color = Color.Blue, // Change the color to indicate that it's clickable
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Name", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(android.graphics.Color.parseColor("#32357A")))
            var name by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                modifier = Modifier
                    .height(55.dp)
                    .width(290.dp),
                singleLine = true,
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter Name", color = enterNumberColor) },
                textStyle = TextStyle(
                    color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Phone Number", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(android.graphics.Color.parseColor("#32357A")))
            var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                modifier = Modifier
                    .height(55.dp)
                    .width(290.dp),
                singleLine = true,
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Enter Phone Number", color = enterNumberColor) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                textStyle = TextStyle(
                    color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Password", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(android.graphics.Color.parseColor("#32357A")))
            var password by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                modifier = Modifier
                    .height(55.dp)
                    .width(290.dp),
                singleLine = true,
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter Password", color = enterNumberColor) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                textStyle = TextStyle(
                    color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            // Handle save button click, validate inputs and save changes
        },
            modifier = Modifier
                .width(290.dp)
                .clip(RoundedCornerShape(13.dp)),
            shape = RoundedCornerShape(13.dp),
            colors = ButtonDefaults.buttonColors( Color(android.graphics.Color.parseColor("#32357A")))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.save_icon), // Use the default save icon
                contentDescription = "Save Icon",
                tint = Color.White,
                modifier = Modifier.size(16.dp) // Set the color of the icon to white
            )
            Spacer(modifier = Modifier.width(8.dp)) // Add some space between the icon and the text
            Text("Save Changes", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen(rememberNavController())
}
