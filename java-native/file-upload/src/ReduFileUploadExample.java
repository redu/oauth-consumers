import java.io.File;
import java.io.IOException;

public class ReduFileUploadExample {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String accessToken = "YOUR_ACCESS_TOKEN";
		File file = new File("src/document_test.pdf");
		
		// Creates a multipart entity which will be embeded on the request
		Entity entity = new Entity();
		entity.addPart("lecture[media]", file, "application/pdf");
		entity.addPart("lecture[name]", "Java");
		entity.addPart("lecture[type]", "Document");		
		
		// Builds the request and injects the multipart entity
		MultipartRequest request = new MultipartRequest("/subjects/117/lectures", accessToken);
		request.setEntity(entity);
		request.send();
	}

}
