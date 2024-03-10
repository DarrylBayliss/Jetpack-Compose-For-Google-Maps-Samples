package com.darrylbayliss.composeformaps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapsComposeExperimentalApi
import com.google.maps.android.compose.clustering.Clustering
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.delay

@OptIn(MapsComposeExperimentalApi::class)
class AnimateMapActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val hydePark = LatLng(51.508610, -0.163611)
            val regentsPark = LatLng(51.531143, -0.159893)
            val primroseHill = LatLng(51.539556, -0.16076088)

            val crystalPalacePark = LatLng(51.42153, -0.05749)
            val greenwichPark = LatLng(51.476688, 0.000130)
            val lloydPark = LatLng(51.364188, -0.080703)

            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(hydePark, 10f)
            }

            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            ) {

                val parkMarkers = remember {
                    mutableStateListOf(
                        ParkItem(hydePark, "Hyde Park", "Marker in hyde Park"),
                        ParkItem(regentsPark, "Regents Park", "Marker in Regents Park"),
                        ParkItem(primroseHill, "Primrose Hill", "Marker in Primrose Hill"),
                        ParkItem(crystalPalacePark, "Crystal Palace", "Marker in Crystal Palace"),
                        ParkItem(greenwichPark, "Greenwich Park", "Marker in Greenwich Park"),
                        ParkItem(lloydPark, "Lloyd park", "Marker in Lloyd Park"),
                    )
                }

                Clustering(items = parkMarkers,
                    onClusterClick = {
                        // Handle when the click is tapped
                        true
                    }, onClusterItemClick = { marker ->
                        // Handle when the marker is tapped
                        true
                    })

                LaunchedEffect(key1 = "Animation") {
                    for (marker in parkMarkers) {
                        cameraPositionState.animate(
                            CameraUpdateFactory.newLatLngZoom(
                                marker.itemPosition, // LatLng
                                16.0f
                            ), // Zoom level
                            2000 // Animation duration in millis
                        )
                        delay(4000L) // Delay in millis
                    }
                }
            }
        }
    }

    data class ParkItem(
        val itemPosition: LatLng,
        val itemTitle: String,
        val itemSnippet: String
    ) : ClusterItem {
        override fun getPosition(): LatLng =
            itemPosition

        override fun getTitle(): String =
            itemTitle

        override fun getSnippet(): String =
            itemSnippet

        override fun getZIndex(): Float? = null
    }
}
