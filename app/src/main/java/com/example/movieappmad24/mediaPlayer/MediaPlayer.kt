package com.example.movieappmad24.mediaPlayer

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.movieappmad24.R

//Tutorial von Leon vorgeschlagen (Moodle): https://www.youtube.com/watch?v=NpCSzl74ciY
class MediaPlayer {
    @Composable
    fun Player() {
        var lifecycle by remember {
            mutableStateOf(Lifecycle.Event.ON_CREATE)
        }
        val context = LocalContext.current

        val mediaResource =  MediaItem.fromUri(
            "android.resource://${context.packageName}/${R.raw.trailer_placeholder}"
        )

        val exoplayer = remember {
            ExoPlayer.Builder(context).build().apply {
                setMediaItem(mediaResource)
                prepare()
                playWhenReady = true
            }
        }
        val localOwner = LocalLifecycleOwner.current
        DisposableEffect(key1 = localOwner) {
            val observer = LifecycleEventObserver { _, event ->
                lifecycle = event
            }
            localOwner.lifecycle.addObserver(observer)

            onDispose {
                exoplayer.release()
                localOwner.lifecycle.removeObserver(observer)
            }
        }
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(18f / 9f)
                .padding(top = 10.dp),
            factory = {
                PlayerView(context).also { playerView ->
                    playerView.player = exoplayer
                }
            },
            update = {
                when(lifecycle) {
                    Lifecycle.Event.ON_RESUME -> {
                        it.onPause()
                        it.player?.pause()
                    }

                    Lifecycle.Event.ON_PAUSE -> {
                        it.onResume()
                    } else -> Unit
                }
            }
        )

    }
}
