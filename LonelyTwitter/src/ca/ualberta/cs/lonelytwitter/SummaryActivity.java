package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.data.GsonFileDataManager;
import ca.ualberta.cs.lonelytwitter.data.IDataManager;

public class SummaryActivity extends Activity {

	private IDataManager dataManager;
	
	private TextView numberOfTweetsTextView;
	private TextView latencyTextView;
	private TextView lengthTextView;
	
	public static final String GET_SUMMARY = "get this summary";

	private Summary sum;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.summary);
		
		numberOfTweetsTextView = (TextView) findViewById(R.id.numberOfTweetsTextView);
		latencyTextView = (TextView) findViewById(R.id.latencyTextView);
		lengthTextView = (TextView) findViewById(R.id.lengthTextView);

		dataManager = new GsonFileDataManager(this);
		
		sum = (Summary) getIntent().getSerializableExtra(GET_SUMMARY);
		
		numberOfTweetsTextView.setText(sum.getNumOfTweets());
		latencyTextView.setText(sum.getAverageLatency());
		lengthTextView.setText(sum.getAverageLength());
		

	}

	@Override
	protected void onStart() {
		super.onStart();

	}

}