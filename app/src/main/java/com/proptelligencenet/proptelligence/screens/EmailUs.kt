package com.proptelligencenet.proptelligence.screens

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.proptelligencenet.proptelligence.R

@Composable
fun EmailUs(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#F2F1F6")))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
        }

        Text(
            text = "Email Us",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 0.dp)
        )
        Spacer(modifier = Modifier.size(60.dp))


        Text(
            text = "Kindly email us with the details of your requirements along with any relevant documents. Our legal team will review the information and respond to you promptly.",
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            color = Color.Black,
        )

        Spacer(modifier = Modifier.size(40.dp))

        SocialMediaButton(
            text = "Email Now",
            icon = painterResource(id = R.drawable.ic_gmail),
            onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "message/rfc822" // Use this MIME type for emails
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("info@proptelligence.net"))
                    putExtra(Intent.EXTRA_SUBJECT, "")
                    putExtra(Intent.EXTRA_TEXT, "")
                }
                if (intent.resolveActivity(context.packageManager) != null) {
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "No email app available", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier.padding(top = 24.dp, bottom = 29.dp)
        )

    }
}

@Composable
fun SocialMediaButton(
    text: String,
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {


    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFe3e5e9), shape = RoundedCornerShape(10.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFe3e5e9)),
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = Color.Black,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp, fontStyle = FontStyle.Normal),
            maxLines = 1
        )
    }
}


@Preview(showBackground = true)
@Composable
fun EmailUsPreview() {
    EmailUs(rememberNavController())
}