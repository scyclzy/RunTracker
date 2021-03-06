package com.bignerdranch.android.runtracker;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class RunActivity extends SingleFragmentActivity {
	// A key for passing a run ID as a long
	public static final String EXTRA_RUN_ID = 
			"com.bignerdranch.android.runtracker.run_id";

	@Override
	protected Fragment createFragment() {
		long runId = getIntent().getLongExtra(EXTRA_RUN_ID, -1);
		if(runId != -1) {
			return RunFragment.newInstance(runId);
		} else {
			return new RunFragment();
		}
	}

}
