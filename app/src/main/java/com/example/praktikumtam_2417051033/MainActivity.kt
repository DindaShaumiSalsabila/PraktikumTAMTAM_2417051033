package com.example.praktikumtam_2417051033

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val journals = Lifestyledum.dummyLs
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F3EE)),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Text(
                "Journal.",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Praktikum Teknologi Aplikasi Mobile",
                color = Color(0xFF6B6B6B)
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(journals.take(3)) { journal ->
                    JournalRowItem(journal)
                }
            }
        }
        items(journals) { journal -> DetailScreen(journal)
        }
    }
}
@Composable
fun JournalRowItem(journal: Lifestyle) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.width(160.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(journal.imageRes),
                contentDescription = journal.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = journal.title,
                modifier = Modifier.padding(horizontal = 8.dp),
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
@Composable
fun DetailScreen(journal: Lifestyle) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(journal.imageRes),
                    contentDescription = journal.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )
                var isHappy by remember { mutableStateOf(false) }
                IconButton(
                    onClick = { isHappy = !isHappy },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = if (isHappy)
                            Icons.Filled.Favorite
                        else
                            Icons.Outlined.FavoriteBorder,
                        contentDescription = "Mood",
                        tint = if (isHappy) Color.Red else Color.White
                    )
                }
            }
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = journal.title,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${journal.date} | ${journal.mood}",
                    color = Color(0xFF6B6B6B)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = journal.note,
                    color = Color(0xFF6B6B6B)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF8B6F47)
                    )
                ) {
                    Text("Tulis Sekarang")
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewJournal() {
    PraktikumTAM_2417051033Theme {
        JournalScreen()
    }
}