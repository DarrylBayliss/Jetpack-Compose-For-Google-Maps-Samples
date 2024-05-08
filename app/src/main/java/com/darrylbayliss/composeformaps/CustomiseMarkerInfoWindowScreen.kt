package com.darrylbayliss.composeformaps

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun CustomiseMarkerInfoWindowScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        val hydePark = LatLng(51.508610, -0.163611)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(hydePark, 10f)
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            MarkerInfoWindowContent(
                state = MarkerState(position = hydePark),
                title = "Hyde Park",
                snippet = "Marker in Hyde Park"
            ) { marker ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        modifier = Modifier.padding(top = 6.dp),
                        text = marker.title ?: "",
                        fontWeight = FontWeight.Bold
                    )
                    Text("Hyde Park is a Grade I-listed parked in Westminster")
                    Image(
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .border(
                                BorderStroke(3.dp, color = Color.Gray),
                                shape = RectangleShape
                            ),
                        painter = painterResource(id = R.drawable.hyde_park),
                        contentDescription = "A picture of hyde park"
                    )
                }
            }
        }
    }
}
