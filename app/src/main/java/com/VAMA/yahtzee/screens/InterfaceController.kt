package com.VAMA.yahtzee.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun Yahtzee(){
    var screen by rememberSaveable { mutableIntStateOf(1) }

        when (screen) {
            1 -> {
                screen = homepage()

            }

            2 -> {

                screen = game()


            }
        }

        /*
        2 -> {
            ShowProverbsGrid(proverbs) {
                CoroutineScope(Dispatchers.IO).launch {
                    Log.w("XXX", it)
                    val l = repository.readAll("%$it%")
                    proverbs = l
                }
            }
        }

        3 -> {
            ShowProverbsList(proverbs) {
                CoroutineScope(Dispatchers.IO).launch {
                    Log.w("XXX", it)
                    val l = repository.readAll("%$it%")
                    proverbs = l
                }
            }
        }

        4 -> {
            SimpleList(proverbs = proverbs) {
                CoroutineScope(Dispatchers.IO).launch {
                    val l = repository.readAll("%$it%")
                    proverbs = l
                }
            }
        }

         */
}