package com.darrylbayliss.composeformaps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeForMapsApp()
        }
    }
}
@Composable
fun ComposeForMapsApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "main") {
        composable("main") {
            MainScreen(
                onShowMapPressed = { navController.navigate("showmap") },
                onShowMultipleMarkersPressed = { navController.navigate("showmultiplemarkers") },
                onCustomiseMarkerInfoWindowPressed = { navController.navigate("customisemarkerinfowindow") },
                onMarkerClusteringPressed = { navController.navigate("markerclustering") },
                onGettingLocationPermissionPressed = { navController.navigate("locationpermission") },
                onDrawingShapesAndPolygonsPressed = { navController.navigate("drawingshapesandpolygons") },
                onShowingStreetViewPressed = { navController.navigate("streetview") },
                onMapAnimationsPressed = { navController.navigate("mapanimations") },
                onScaleBarsPressed = { navController.navigate("scalebars") }
            )
        }
        composable("showmap") { ShowMapScreen() }
        composable("showmultiplemarkers") { ShowMultipleMarkersScreen() }
        composable("customisemarkerinfowindow") { CustomiseMarkerInfoWindowScreen() }
        composable("markerclustering") { ClusteringMarkersScreen() }
        composable("locationpermission") { GettingLocationPermissionScreen() }
        composable("drawingshapesandpolygons") { DrawShapesScreen() }
        composable("streetview") { ShowStreetViewScreen() }
        composable("mapanimations") { AnimateMapScreen() }
        composable("scalebars") { ShowScaleBarScreen() }
    }
}