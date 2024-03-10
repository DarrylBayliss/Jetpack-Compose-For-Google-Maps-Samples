# Jetpack Compose For Google Maps Samples

A collection of examples showing how to use the Jetpack Compose Components for the Google Maps SDK.

The samples include:

- Showing a map containing a single marker
- Showing a map containing multiple markers
- Customising the window for a selected marker
- Creating a cluster of markers
- Getting Fine Location Permission using the permissions library from accompianist
- Drawing shapes and polygons on the map
- Tapping on a marker and showing street view
- Animating the map to different markers
- Showing the scale bar

# Usage

1. Download the repo and open the project in Android Studio.

2. In `local.properties`, add a Google Maps API key to the file.

```
MAPS_API_KEY=yourkeyhere
```

Follow the instructions on the [Maps SDK for Android](https://developers.google.com/maps/documentation/android-sdk/get-api-key) pages if you need to create an API key.

3. The `ShowMapActivity` sample runs by default. To run a different sample update the name of the Activity in `AndroidManifest.xml` and run the app.

```xml
 <!-- Update the name attribute in the activity tag -->
<activity
    android:name="com.darrylbayliss.composeformaps.ShowMapActivity"
    android:exported="true"
    android:theme="@style/Theme.ComposeForMaps">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```

# Contributing

Additional samples and bug fixes are welcome. Fork the repo and raise a pull request to make a change.
