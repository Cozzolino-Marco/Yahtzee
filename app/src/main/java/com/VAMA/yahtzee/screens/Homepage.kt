package com.VAMA.yahtzee.screens

import android.net.Uri
import android.widget.VideoView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.VAMA.yahtzee.R

@Composable
fun  homepage(): Int{
    var state by rememberSaveable { mutableIntStateOf(1) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.linearGradient(colors = listOf(Color.DarkGray, Color.LightGray))),
        contentAlignment = Alignment.Center) {

        // VideoView per il video di sfondo
        val context = LocalContext.current
        AndroidView(
            factory = { context ->
                VideoView(context).apply {

                    setVideoPath("C:\\Users\\marco\\OneDrive\\Desktop\\Yahtzee\\app\\src\\main\\java\\com\\VAMA\\yahtzee\\raw\\background_video.mp4")
                    setOnPreparedListener { mediaPlayer ->
                        mediaPlayer.isLooping = true
                        start()
                    }


                    /*

                    val videoUri =
                        Uri.parse("android.resource://java/com/VAMA/yahtzee/raw/background_video.mp4")
                            .apply {
                                setVideoURI(this)
                            }
                    start()
                    setOnPreparedListener { mp -> mp.isLooping = true } // Per far ripetere il video in loop
                }*/
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        Box(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter).padding(horizontal = 30.dp, vertical = 40.dp)) {

            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(220.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.help),
                    contentDescription = "help icon",
                    modifier = Modifier.size(70.dp).clickable {state = 2}
                    )

                Image(
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = "settings icon",
                    modifier = Modifier.size(50.dp).clickable {state = 2},

                    )


            }


            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.yahtzee),
                    contentDescription = "Game title",
                    modifier = Modifier.size(350.dp)

                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(vertical = 100.dp)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(50.dp)
            ) {



                MyButton(color = Color.Red, text = "Resume game") {
                    state = 2
                }
                MyButton(color = Color.Green, text = "New game") {
                    //onclick(2)
                }
                MyButton(color = Color.Blue, text = "Scoreboard") {
                    //onclick(4)
                }


            }
        }
    }
    return state
}





@Composable
fun MyButton(color: Color, text: String, onclick: () -> Unit) {
    Button(
        modifier = Modifier
            .size(width = 300.dp, height = 100.dp)

            .border(10.dp, Color.White, shape = RoundedCornerShape(3.dp)),
        onClick = onclick ,
        colors = ButtonDefaults.buttonColors(
            containerColor = color
        )
    ) {
        Text(text = text, color = Color.White, fontSize = 30.sp)
    }
}