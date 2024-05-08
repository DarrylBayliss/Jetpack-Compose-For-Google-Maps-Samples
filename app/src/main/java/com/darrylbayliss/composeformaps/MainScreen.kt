package com.darrylbayliss.composeformaps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(onShowMapPressed: () -> Unit,
               onShowMultipleMarkersPressed: () -> Unit,
               onCustomiseMarkerInfoWindowPressed: () -> Unit,
               onMarkerClusteringPressed: () -> Unit,
               onGettingLocationPermissionPressed: () -> Unit,
               onDrawingShapesAndPolygonsPressed: () -> Unit,
               onShowingStreetViewPressed: () -> Unit,
               onMapAnimationsPressed: () -> Unit,
               onScaleBarsPressed: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = onShowMapPressed) {
            Text(text = "Show Map")
        }
        Button(onClick = onShowMultipleMarkersPressed) {
            Text(text = "Show Multiple Markers")
        }
        Button(onClick = onCustomiseMarkerInfoWindowPressed) {
            Text(text = "Customise Marker Info Window")
        }
        Button(onClick = onMarkerClusteringPressed) {
            Text(text = "Marker Clustering")
        }
        Button(onClick = onGettingLocationPermissionPressed) {
            Text(text = "Getting Location Permission")
        }
        Button(onClick = onDrawingShapesAndPolygonsPressed) {
            Text(text = "Drawing Shapes and Polygons")
        }
        Button(onClick = onShowingStreetViewPressed) {
            Text(text = "Showing Street View")
        }
        Button(onClick = onMapAnimationsPressed) {
            Text(text = "Map Animations")
        }
        Button(onClick = onScaleBarsPressed) {
            Text(text = "Scale Bars")
        }
    }
}