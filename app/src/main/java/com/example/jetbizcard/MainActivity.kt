package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 4.dp) {
            Column(modifier = Modifier.height(300.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
                CreateImageProfile()
                Divider()
                CreateInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value

                }) {
                    Text("Portfolio",
                    style = MaterialTheme.typography.button)
                }
                if(buttonClickedState.value){
                    Content()
                }else{
                    Box{

                    }
                }
            }
        }
    }
}

@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        border = BorderStroke(width = 2.dp, color = Color.LightGray)){

            Portfolio(data = listOf("NYC Restaurants",
                "To-Do App",
                "Japanese Quiz",
                "Drawing App"))
            
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn{
        items(1){ _ ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
            shape = RectangleShape,
            elevation = 4.dp){
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp)){

                    Image(
                        painter = painterResource(id = R.drawable.ic_food),
                        contentDescription = "profile image",
                        modifier = Modifier.size(80.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {

                        Text(data[0], fontWeight = FontWeight.Bold)
                        Text("An application allowing users to create a list of some of their favorite restaurants.",
                            style = MaterialTheme.typography.body2)

                        GitHubProjectOne()
                    }
                }
            }
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp){
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp)){

                    Image(
                        painter = painterResource(id = R.drawable.ic_to_do_image),
                        contentDescription = "profile image",
                        modifier = Modifier.size(80.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {

                        Text( data[1], fontWeight = FontWeight.Bold)
                        Text("Maintain our day-to-day tasks or list everything that we have to do.",
                            style = MaterialTheme.typography.body2)

                        GitHubProjectTwo()
                    }
                }
            }
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp){
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp)){

                    Image(
                        painter = painterResource(id = R.drawable.ic_learn_jp),
                        contentDescription = "profile image",
                        modifier = Modifier.size(80.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {

                        Text( data[2], fontWeight = FontWeight.Bold)
                        Text("Practice makes perfect and learning a new language is not an easy task the " +
                                "application gathered the top 10 most used phrases in Japan for you to learn!",
                            style = MaterialTheme.typography.body2)

                        GitHubProjectThree()
                    }
                }
            }
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp){
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp)){

                    Image(
                        painter = painterResource(id = R.drawable.ic_paint),
                        contentDescription = "profile image",
                        modifier = Modifier.size(80.dp),
                        contentScale = ContentScale.Crop
                    )

                    Column(modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {

                        Text( data[3], fontWeight = FontWeight.Bold)
                        Text("This paint canvas application allows users to draw and or " +
                                "trace any images they have stored in their device.",
                            style = MaterialTheme.typography.body2)

                        GitHubProjectFour()
                    }
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Sebastian C.",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant)

        Text(
            "Mobile Developer",
            modifier = Modifier.padding(3.dp))

        Text(
            "@196Sebastian",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun GitHubProjectOne() {
    val annotatedLinkString: AnnotatedString = buildAnnotatedString {
        val str = "View it on GitHub!"
        val startIndex = str.indexOf("View")
        val endIndex = startIndex + 18
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color(0xff64B5F6),
                fontSize = 10.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )

        addStringAnnotation(
            tag = "URL",
            annotation = "https://github.com/196Sebastian/nyc-restaurants",
            start = 0,
            end = endIndex
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString
                .getStringAnnotations( "URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}

@Composable
fun GitHubProjectTwo() {
    val annotatedLinkString: AnnotatedString = buildAnnotatedString {
        val str = "View it on GitHub!"
        val startIndex = str.indexOf("View")
        val endIndex = startIndex + 18
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color(0xff64B5F6),
                fontSize = 10.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )

        addStringAnnotation(
            tag = "URL",
            annotation = "https://github.com/196Sebastian/to-do-app",
            start = 0,
            end = endIndex
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString
                .getStringAnnotations( "URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}

@Composable
fun GitHubProjectThree() {
    val annotatedLinkString: AnnotatedString = buildAnnotatedString {
        val str = "View it on GitHub!"
        val startIndex = str.indexOf("View")
        val endIndex = startIndex + 18
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color(0xff64B5F6),
                fontSize = 10.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )

        addStringAnnotation(
            tag = "URL",
            annotation = "https://github.com/196Sebastian/japanese-quiz",
            start = 0,
            end = endIndex
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString
                .getStringAnnotations( "URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}

@Composable
fun GitHubProjectFour() {
    val annotatedLinkString: AnnotatedString = buildAnnotatedString {
        val str = "View it on GitHub!"
        val startIndex = str.indexOf("View")
        val endIndex = startIndex + 18
        append(str)
        addStyle(
            style = SpanStyle(
                color = Color(0xff64B5F6),
                fontSize = 10.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )

        addStringAnnotation(
            tag = "URL",
            annotation = "https://github.com/196Sebastian/drawing-app",
            start = 0,
            end = endIndex
        )
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        text = annotatedLinkString,
        onClick = {
            annotatedLinkString
                .getStringAnnotations( "URL", it, it)
                .firstOrNull()?.let { stringAnnotation ->
                    uriHandler.openUri(stringAnnotation.item)
                }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}