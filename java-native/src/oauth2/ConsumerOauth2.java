package oauth2;

import java.io.IOException;
import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class ConsumerOauth2 {

	private static final String CONSUMER_KEY = "your_consumer_key";
	private static final String CONSUMER_SECRET_KEY = "your_consumer_secret_key";

	private static final String RESOURCE = "http://www.redu.com.br/api/me.json";

	public static void main(String[] args) throws IOException {
		OAuthService service = new ServiceBuilder().provider(ReduOauth2.class)
				.apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET_KEY).callback("").build();

		
		String authUrl = service.getAuthorizationUrl(null);
		System.out.println("Authorize app in: " + authUrl);

		System.out.println("Insert the PIN");
		
		Scanner in = new Scanner(System.in);
		Verifier verifier = new Verifier(in.nextLine());

		Token accessToken = service.getAccessToken(null, verifier);


		OAuthRequest request = new OAuthRequest(Verb.GET, RESOURCE);
		service.signRequest(accessToken, request);

		System.out.println("Sending request");
		Response response = request.send();

		System.out.println("\nResponse: \n");
		System.out.println("Code: " + response.getCode());
		System.out.println("Response: " + response.getBody());

	}
}
