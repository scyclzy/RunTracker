package com.bignerdranch.android.runtracker;

import android.content.Context;
import android.location.Location;

public class TrackingLocationReceiver extends LocationReceiver {

	@Override
	public void onLocationReceived(Context context, Location loc) {
		super.onLocationReceived(context, loc);
		RunManager.get(context).insertLocation(loc);
	}

}
