package com.darrylbayliss.composeformaps

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun GettingLocationPermissionScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val hydePark = LatLng(51.508610, -0.163611)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(hydePark, 10f)
        }

        // Don't forget to add the permissions to AndroidManifest.xml
        val allLocationPermissionsState = rememberMultiplePermissionsState(
            listOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
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

            // Check if we have location permissions
            if (!allLocationPermissionsState.allPermissionsGranted) {

                // Show a component to request permission from the user
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(horizontal = 36.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.White)
                ) {
                    Text(
                        modifier = Modifier.padding(top = 6.dp),
                        textAlign = TextAlign.Center,
                        text = "This app functions 150% times better with percise location enabled"
                    )
                    Button(modifier = Modifier.padding(top = 12.dp), onClick = {
                        allLocationPermissionsState.launchMultiplePermissionRequest()
                    }) {
                        Text(text = "Grant Permission")
                    }
                }
            }
        }
    }
}
