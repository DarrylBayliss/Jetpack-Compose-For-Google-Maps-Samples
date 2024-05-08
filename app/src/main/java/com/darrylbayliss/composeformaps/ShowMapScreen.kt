package com.darrylbayliss.composeformaps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun ShowMapScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val hydePark = LatLng(51.508610, -0.163611)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(hydePark, 10f)
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = hydePark),
                title = "Hyde Park",
                snippet = "Marker in Hyde Park"
            )
        }
    }
}
