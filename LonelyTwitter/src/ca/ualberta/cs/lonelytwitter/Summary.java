package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.ArrayList;

public class Summary implements Serializable{
	
	private ArrayList<Tweet> tweets;
	private String averageLengthString;
	private String numOfTweetsString;
	private String averageLatencyString;

	public Summary(ArrayList<Tweet> lts){
		tweets = lts;
		
		calculate();
	}
	
	public void calculate(){
		int numOfTweets = tweets.size();
		
		int tweetLength = 0;
		long averageLatency = 0;
		
		if(numOfTweets > 0){
			for(int i = 0; i < numOfTweets; i++){
				tweetLength += tweets.get(i).getTweetBody().length();
				if(i > 0){
					averageLatency += tweets.get(i).getTweetDate().getTime() - tweets.get(i-1).getTweetDate().getTime();
				}
			}
			
			tweetLength = tweetLength/numOfTweets;
			averageLatency = averageLatency/numOfTweets;
		
		}
		averageLengthString = "" + tweetLength;
		numOfTweetsString = "" + numOfTweets;
		averageLatencyString = "" + averageLatency;
	}
	
	public String getNumOfTweets(){
		return numOfTweetsString;
	}
	
	public String getAverageLength(){
		return averageLengthString;
	}
	
	public String getAverageLatency(){
		return averageLatencyString;
	}
	
}
