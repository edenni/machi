package com.eden.machi.view

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.eden.machi.PermissionUtils.PermissionDeniedDialog.Companion.newInstance
import com.eden.machi.PermissionUtils.isPermissionGranted
import com.eden.machi.PermissionUtils.requestPermission
import com.eden.machi.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.maps.SupportMapFragment


class MainActivity : AppCompatActivity(), GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener, OnMapReadyCallback,
    ActivityCompat.OnRequestPermissionsResultCallback {

    private var permissionDenied = false
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val profileFragment = ProfileFragment()
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?

        mapFragment?.getMapAsync(this)
        Log.d("hhhh", "ssssssssssssssssss")
        fab.setOnClickListener {
            TimePickerFragment().show(supportFragmentManager, "timePicker")
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.map -> {
                    replaceFragment(mapFragment as Fragment)
                    true
                }
                R.id.profile -> {
                    replaceFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
        Log.d("hhhh", "vvvvvvvvvvvvvvv")
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        Log.d("hhhh", "aaaaaaaaaaaaaa")

        map = googleMap ?: return
        googleMap.setOnMyLocationButtonClickListener(this)
        googleMap.setOnMyLocationClickListener(this)
        enableMyLocation()
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private fun enableMyLocation() {
        Log.d("hhhh", "dddddddddddddddddd")
        if (!::map.isInitialized) return
        // [START maps_check_location_permission]
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
                Log.d("hhhh", "djafkj;lsdj")
                map.isMyLocationEnabled = true
        } else {
            Log.d("hhhh", "djfakldjfakdjfioodjfo")
            // Permission to access the location is missing. Show rationale and request permission
            requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                Manifest.permission.ACCESS_FINE_LOCATION, true
            )
        }
        // [END maps_check_location_permission]
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show()
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false
    }

    override fun onMyLocationClick(location: Location) {
        Toast.makeText(this, "Current location:\n$location", Toast.LENGTH_LONG).show()
    }

    // [START maps_check_location_permission_result]
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        Log.d("hhhh", "kkkkkkkkkkkkkkk")

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d("hhhh", "kkkkkkkkkkkkkkk")

        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return
        }
        if (isPermissionGranted(permissions, grantResults, Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation()
        } else {
            // Permission was denied. Display an error message
            // [START_EXCLUDE]
            // Display the missing permission error dialog when the fragments resume.
            permissionDenied = true
            // [END_EXCLUDE]
        }
    }

    // [END maps_check_location_permission_result]
    override fun onResumeFragments() {
        super.onResumeFragments()
        Log.d("hhhh", "lllllllll")

        if (permissionDenied) {
            Log.d("hhhh", "hhhjjjjjjjjjj")

            // Permission was not granted, display error dialog.
            showMissingPermissionError()
            permissionDenied = false
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private fun showMissingPermissionError() {
        newInstance(true).show(supportFragmentManager, "dialog")
    }

    companion object {
        /**
         * Request code for location permission request.
         *
         * @see .onRequestPermissionsResult
         */
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}