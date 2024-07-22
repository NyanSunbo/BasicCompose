package com.example.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basiccompose.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme  {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardCompose()
                }
            }
        }
    }
}

// region Compose Quadrant

@Composable
private fun QuadrantCompose(){
    Column(
        Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier.weight(1f)
        ){
            QuadrantComposeCard(
                title = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            QuadrantComposeCard(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            Modifier.weight(1f)
        ){
            QuadrantComposeCard(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            QuadrantComposeCard(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun QuadrantComposeCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

//@Preview(
//    name="Compose Quadrant",
//    showBackground = true
//)
@Composable()
private fun QuadrantComposePreview(){
    HappyBirthdayTheme {
        QuadrantCompose()
    }
}

// endregion

// region Business Card

@Composable
private fun BusinessCardCompose(){
    HappyBirthdayTheme {
        BusinessCard(
            imagePainter = painterResource(R.drawable.android_logo),
            fullName = stringResource(R.string.business_card_full_name),
            title = stringResource(R.string.business_card_title),
            telephone = stringResource(R.string.business_card_telephone),
            socialMedia = stringResource(R.string.business_card_social_media),
            email = stringResource(R.string.business_card_email),
        )
    }
}

@Composable
private fun BusinessCard(
    imagePainter: Painter,
    fullName: String,
    title: String,
    telephone: String,
    socialMedia: String,
    email: String,
    modifier: Modifier = Modifier
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF073042)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Color.White,
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.White
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 105.dp),
        ){
            val image = painterResource(R.drawable.phone_iphone_24dp_e8eaed_fill0_wght400_grad0_opsz24)
            Image(painter = image, contentDescription = null,modifier = Modifier.padding(end = 20.dp))
            Text(
                text = telephone,
                modifier = Modifier.padding(4.dp),
                color = Color.White
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 105.dp)
        ){
            val image = painterResource(R.drawable.group_24dp_e8eaed_fill0_wght400_grad0_opsz24)
            Image(painter = image, contentDescription = null,modifier = Modifier.padding(end = 20.dp))
            Text(
                text = socialMedia,
                modifier = Modifier.padding(4.dp),
                color = Color.White
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 105.dp)
        ){
            val image = painterResource(R.drawable.mail_24dp_e8eaed_fill0_wght400_grad0_opsz24)
            Image(painter = image, contentDescription = null,modifier = Modifier.padding(end = 20.dp))
            Text(
                text = email,
                modifier = Modifier.padding(4.dp),
                color = Color.White
            )
        }
    }


}

@Preview(
    name = "Business Card",
    showBackground = true

)
@Composable
private fun BusinessCardView(){
    HappyBirthdayTheme {
        BusinessCardCompose();
    }
}

// endregion

// region Task Manager

@Composable()
private fun TaskManagerCompose(){
    TaskManagerComposeCard(
        imagePainter = painterResource(R.drawable.ic_task_completed),
        title = stringResource(R.string.task_manager_title),
        description = stringResource(R.string.task_manager_description)
    )
}

//@Preview(
//    name="PreviewJetpack",
//    showBackground = true
//)
//@Composable
//fun TaskManagerView(){
//    HappyBirthdayTheme {
//        TaskManagerCompose()
//    }
//}

@Composable()
private fun TaskManagerComposeCard(
    imagePainter: Painter,
    title: String,
    description: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = imagePainter,
            contentDescription = null
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = description,
            fontSize = 16.sp
        )
    }
}


// endregion

// region Jetpack Compose

@Composable
fun JetpackCompose(){
    JetpackComposeCard(
        title = stringResource(R.string.jetpack_compose_tutorial),
        shortDescription = stringResource(R.string.jetpack_compose_paragarph_1),
        longDescription = stringResource(R.string.jetpack_compose_paragarph_2),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
private fun JetpackComposeCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Image(
            painter = imagePainter,
            contentDescription = "header image",
        )
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = shortDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = longDescription,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

/*@Preview(
    name="PreviewJetpack",
    showBackground = true
)*/
@Composable
fun JetpackImagePreview(){
    HappyBirthdayTheme {
        JetpackCompose()
    }
}

//@Preview(
//    name="PreviewJetpackText",
//    showBackground = true
//)
@Composable
fun JetpackTextPreview(){
    HappyBirthdayTheme {
        JetpackCompose()
    }
}

// endregion

// region BirthdaySolution

@Composable
fun Greeting(name: String,from: String,modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ){
        Text(
            text = stringResource(R.string.happy_birthday)  + " $name!",
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "From $from",
            fontSize = 36.sp,
            lineHeight = 116.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(name: String, from: String,modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box(){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Greeting(
            name = name,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

//@Preview(name="Birthday Image",
//         showBackground = true )
@Composable
fun BirthdayImagePreview() {
    HappyBirthdayTheme {
        GreetingImage(name = "Android", from = "IOS")
    }
}

// endregion