package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4)),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardHeading()
        ContactDetails()
    }
}

@Composable
fun CardHeading(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier
            .background(Color(0xFF073042))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = image,
                contentDescription = "Profile Image",
                modifier = modifier
                    .size(256.dp)
            )
        }
        Text(
            text = stringResource(R.string.full_name_data),
            fontSize = 32.sp,
            color = Color.White,
            lineHeight = 32.sp,
        )
        Text(
            text = stringResource(R.string.title_data),
            fontSize = 20.sp,
            color = Color.White,
            lineHeight = 48.sp,
        )
    }
}

@Composable
fun ContactDetails(modifier: Modifier = Modifier) {
    Column(
        modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ContactInfo(
            icon = Icons.Default.AccountCircle,
            iconDescription = stringResource(R.string.full_name_label),
            text = stringResource(R.string.full_name_data)
        )
        ContactInfo(
            icon = Icons.Default.Phone,
            iconDescription = stringResource(R.string.phone_label),
            text = stringResource(R.string.phone_number_data)
        )
        ContactInfo(
            icon = Icons.Default.Email,
            iconDescription = stringResource(R.string.email_label),
            text = stringResource(R.string.email_data)
        )
    }
}

// Information by Contact
@Composable
fun ContactInfo(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconDescription: String,
    text: String,
    ) {
    Row(
        modifier
            .padding(start = 48.dp, end = 48.dp, top = 2.dp, bottom = 2.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            icon,
            contentDescription = iconDescription,
            modifier = modifier
                .padding(start = 8.dp, end = 8.dp)
                .size(32.dp)
        )
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier.padding(end = 8.dp),
            fontSize = 20.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardScreenPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}