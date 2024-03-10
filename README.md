# Jetpack Compose For Google Maps Samples

A collection of examples showing how to use the Jetpack Compose Components for the Google Maps SDK.

# Usage

1. Download the repo and open the project in Android Studio. Run the app.

2. The `ShowMapActivity` runs by default. To run a different sample update the name of the Activity in `AndroidManifest.xml`

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
