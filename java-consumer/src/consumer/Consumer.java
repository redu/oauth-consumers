package consumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;

public class Consumer {

	private static final String CONSUMER_KEY = "your_consumer_key";
	private static final String CONSUMER_SECRET_KEY = "your_consumer_private_key";

	private static final String REQUEST_TOKEN_URL = "http://www.redu.com.br/oauth/request_token";
	private static final String ACCESS_TOKEN_URL = "http://www.redu.com.br/oauth/access_token";
	private static final String AUTHORIZE_URL = "http://www.redu.com.br/oauth/authorize";

	public static void main(String[] args) throws OAuthMessageSignerException,
			OAuthNotAuthorizedException, OAuthExpectationFailedException,
			OAuthCommunicationException, IOException {

		OAuthConsumer consumer = new DefaultOAuthConsumer(CONSUMER_KEY,
				CONSUMER_SECRET_KEY);

		OAuthProvider provider = new DefaultOAuthProvider(REQUEST_TOKEN_URL,
				ACCESS_TOKEN_URL, AUTHORIZE_URL);

		System.out.println("Get request token");
		String authUrl = provider.retrieveRequestToken(consumer,
				OAuth.OUT_OF_BAND);

		System.out.println("Authorize app in: " + authUrl);
		System.out.println("Request token: " + consumer.getToken());
		System.out.println("Token secret: " + consumer.getTokenSecret());

		System.out.println("Insert the PIN");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pin = br.readLine();

		System.out.println("Get access token");
		provider.retrieveAccessToken(consumer, pin);

		System.out.println("Access token: " + consumer.getToken());
		System.out.println("Token secret: " + consumer.getTokenSecret());

	}

}
