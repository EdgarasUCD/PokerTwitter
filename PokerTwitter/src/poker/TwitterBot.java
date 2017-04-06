/*
 * TwitterBot.java
 * 
 */

package poker;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterBot {

	private static TwitterBot twitterBot;
	private static Twitter api;

	public static final String HASH_TAG = "#ECMXPoker";

	// Authentication constants
	private static final String CONSUMER_KEY = "n2oGby0hRj9lnqyKI3G3hhibb";
	private static final String CONSUMER_SECRET = "5p5yxly0OtxQUUrrWFmNyNdXdmlzBXBUC8aQc3PnGOhddSX2Jd";
	private static final String ACCESS_TOKEN = "849543733473406978-S6By79P4eWW9kjQPTvoFrlNZPSRRyNv";
	private static final String ACCESS_TOKEN_SECRET = "5KQOnxKfq5u6ybXSRk6xYCD8gkCiGjvHGEZ1qbuF0QJ8t";

	public static void main(String[] args) {
		TwitterBot.getInstance();
	}

	private TwitterBot() {}

	public static TwitterBot getInstance() {
		if (twitterBot == null) {
			twitterBot = new TwitterBot();
			init();
		}
		return twitterBot;
	}

	private static void init() {
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true)
		.setOAuthConsumerKey(CONSUMER_KEY)
		.setOAuthConsumerSecret(CONSUMER_SECRET)
		.setOAuthAccessToken(ACCESS_TOKEN)
		.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		api = new TwitterFactory(configurationBuilder.build()).getInstance();
		
		// FIXME Code below this line is for testing purposes. TO BE REMOVED.
		TwitterListener listener = TwitterListener.getInstance();
		listener.run();
	}

	public static Twitter getAPI() {
		return api;
	}

}