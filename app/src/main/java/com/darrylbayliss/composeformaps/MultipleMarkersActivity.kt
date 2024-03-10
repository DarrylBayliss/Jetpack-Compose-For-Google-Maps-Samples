package com.darrylbayliss.composeformaps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class MultipleMarkersActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val hydePark = LatLng(51.508610, -0.163611)
            val regentsPark = LatLng(51.531143, -0.159893)
            val primroseHill = LatLng(51.539556, -0.16076088)
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(hydePark, 10f)
            }

            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState) {
                // Marker 1
                Marker(
                    state = MarkerState(position = hydePark),
                    title = "Hyde Park",
                    snippet = "Marker in Hyde Park"
                )
                // Marker 2
                Marker(
                    state = MarkerState(position = regentsPark),
                    title = "Regents Park",
                    snippet = "Marker in Regents Park"
                )
                // Marker 3
                Marker(
                    state = MarkerState(position = primroseHill),
                    title = "Primrose Hill",
                    snippet = "Marker in Primrose Hill"
                )
            }
        }
    }
}
