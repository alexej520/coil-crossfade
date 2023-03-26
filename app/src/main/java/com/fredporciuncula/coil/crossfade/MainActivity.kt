package com.fredporciuncula.coil.crossfade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.Coil
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.transition.CrossfadeTransition

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Coil.setImageLoader(
      ImageLoader.Builder(this)
        // When we have the CrossfadeTransition here...
        .transitionFactory(CrossfadeTransition.Factory())
        .build()
    )
    setContent {
      AsyncImage(
        model = "https://uploads-ssl.webflow.com/63923a65d5aabf0ad18a0ebd/" +
            "6419ad1b3d99c5758d111c78_mission1a_background_image.jpg",
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        // ...having or not this placeholder will change the scaling of the final image.
        placeholder = painterResource(R.drawable.placeholder_larger),
        contentScale = ContentScale.Crop,
      )

      // If we remove CrossfadeTransition, the placeholder stops affecting the scale, though.
      // And if we use placeholder (instead of placeholder_larger), scaling isn't affected even with crossfade.
    }
  }
}
