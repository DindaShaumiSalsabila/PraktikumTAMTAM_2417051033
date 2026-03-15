package com.example.praktikumtam_2417051033

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikumtam_2417051033.model.Lifestyle
import com.example.praktikumtam_2417051033.model.Lifestyledum
import com.example.praktikumtam_2417051033.ui.theme.PraktikumTAM_2417051033Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PraktikumTAM_2417051033Theme {
                JournalScreen()
            }
        }
    }
}

@Composable
fun JournalScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F3EE))
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text("Journal.", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
        Text("Praktikum Teknologi Aplikasi Mobile", fontSize = 13.sp, color = Color(0xFF6B6B6B))
        Spacer(modifier = Modifier.height(20.dp))
        Lifestyledum.dummyLs.forEach { journal ->
            DetailScreen(journal)
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun DetailScreen(journal: Lifestyle) {
    Column(
        modifier = Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(16.dp)).padding(16.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = journal.imageRes),
                contentDescription = journal.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            var isHappy by remember { mutableStateOf(false) }
            IconButton(
                onClick = { isHappy = !isHappy },
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = if (isHappy) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Mood",
                    tint = if (isHappy) Color.Red else Color.Gray
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = journal.title, fontSize = 18.sp, fontWeight = FontWeight.Bold
        )
        Text(
            text = "${journal.date}  |  ${journal.mood}", fontSize = 12.sp, color = Color(0xFF6B6B6B)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = journal.note, fontSize = 13.sp, color = Color(0xFF6B6B6B)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth().height(42.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B6F47)
            )
        ) {
            Text("Tulis Sekarang", fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JournalListPreview() {
    PraktikumTAM_2417051033Theme { JournalScreen() }
}

@Preview(showBackground = true)
@Composable
fun JournalDetailPreview() {
    val journal = Lifestyledum.dummyLs[0]
    PraktikumTAM_2417051033Theme { DetailScreen(journal) }
}