package com.bignerdranch.android.runtracker;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.android.runtracker.RunDatabaseHelper.RunCursor;

public class RunListFragment extends ListFragment {
	
	private RunCursor mCursor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Query the list of runs
		mCursor = RunManager.get(getActivity()).queryRuns();
	}

	@Override
	public void onDestroy() {
		mCursor.close();
		super.onDestroy();
	}

	private static class RunCursorAdapter extends CursorAdapter {

		private RunCursor mRunCursor;
		
		public RunCursorAdapter(Context context, RunCursor c) {
			super(context, c, 0);
			mRunCursor = c;
			
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			// Get the run or the current row
			Run run = mRunCursor.getRun();
			
			// Set up the start date text view
			TextView startDateTextView = (TextView)view;
			String cellText = context.getString(R.string.cell_text, run.getStartDate());
			startDateTextView.setText(cellText);
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			// Use a layout inflater to get a row view
			LayoutInflater inflater = (LayoutInflater)context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			return inflater
					.inflate(android.R.layout.simple_list_item_1, parent, false);
		}
		
	}
}
