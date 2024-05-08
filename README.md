# Jetpack Compose For Google Maps Samples

![Main Screen](/images/mainscreen.png)

A collection of examples showing how to use the [Jetpack Compose Components](https://github.com/googlemaps/android-maps-compose) for the Google Maps SDK.

The samples include:

## Showing a map containing a single marker

![Showing a single marker](/images/showsinglemarker.png)

## Showing a map containing multiple markers

![Showing multiple markers](/images/showmultiplemarkers.png)

## Customising the window for a selected marker

![Customising window for a selected marker](/images/showcustomisedwindowmarker.png)

## Creating a cluster of markers

![Clustering Markers](/images/markerclustering.png)

## Getting Fine Location Permission using the permissions library from accompianist

![Getting Location Permission](/images/grantlocationpermission.png)

## Drawing shapes and polygons on the map

![Drawing Shapes and Polygons](/images/shapesandpolygons.png)

## Tapping on a marker and showing street view

![Showing Street View](/images/streetview.gif)

## Animating the map to different markers

![Animating the map](/images/animatemap.gif)

## Showing the scale bar

![Showing the scale bar](/images/showscalebar.png)

# Usage

1. Download the repo and open the project in Android Studio.

2. In `local.properties`, add a Google Maps API key to the file. Create the file in the root of the project if needed.

```
MAPS_API_KEY=yourkeyhere
```

Follow the instructions on the [Maps SDK for Android](https://developers.google.com/maps/documentation/android-sdk/get-api-key) pages if you need to create an API key.

3. Build and run the app.
   
4. To run a different sample update the name of the Activity in `AndroidManifest.xml` and run the app.

# Contributing

Additional samples and bug fixes are welcome. Fork the repo and raise a pull request to make a change.
