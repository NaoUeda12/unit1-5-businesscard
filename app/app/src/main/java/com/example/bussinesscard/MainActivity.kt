package com.example.bussinesscard

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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
//import androidx.compose.ui.graphics.BlendModeColorFilter
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinessCardTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

// TopPart関数：アイコン、フルネーム、会社名を表示
@Composable
fun TopPart(icon: Int, fullName: String, companyName: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(100.dp) // 背景とアイコンのサイズを合わせる
                .background(color = colorResource(R.color.teal_200))
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.tint(Color.Black, BlendMode.SrcIn) // ColorfilterとBlendModeをimport
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        // フルネーム
        Text(
            text = fullName,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        // 会社名
        Text(
            text = companyName,
            fontSize = 16.sp,
            color = colorResource(R.color.teal_200)
        )
    }
}

// BottomPart関数：電話番号、GitHub URL、メールアドレスを表示
@Composable
fun BottomPart(phoneNumber: String, exampleUrl: String, emailAddress: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 100.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // 電話番号
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_phone), // 電話アイコンのリソース
                contentDescription = "Phone Icon",
                modifier = Modifier.size(20.dp) // アイコンのサイズ
            )
            Spacer(modifier = Modifier.width(8.dp)) // アイコンとテキストの間に空白を入れる
            Text(
                text = "Phone: $phoneNumber",
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        // websiteアドレス
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_website), // GitHubアイコンのリソース
                contentDescription = "GitHub Icon",
                modifier = Modifier.size(20.dp) // アイコンのサイズ
            )
            Spacer(modifier = Modifier.width(8.dp)) // アイコンとテキストの間に空白を入れる
            Text(
                text = "exampleURL: $exampleUrl",
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        // メールアドレス
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_mail), // メールアイコンのリソース
                contentDescription = "Email Icon",
                modifier = Modifier.size(20.dp) // アイコンのサイズ
            )
            Spacer(modifier = Modifier.width(8.dp)) // アイコンとテキストの間に空白を入れる
            Text(
                text = "Email: $emailAddress",
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 上部（TopPart）を表示
        TopPart(
            icon = R.drawable.ic_launcher_foreground, // アイコンリソース
            fullName = "Jennifer Doe",
            companyName = "Android Develop Company"
        )

        // 下部（BottomPart）を表示
        BottomPart(
            phoneNumber = "012-345-678",
            exampleUrl = "https://www.google.com",
            emailAddress = "jennifer.doe@example.com"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        BusinessCardApp()
    }
}