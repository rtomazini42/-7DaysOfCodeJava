import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {
	String chave = "k_f7y3cnv3";
	String site = "https://imdb-api.com/en/API/Top250Movies/" + chave;
	HttpResponse<String> response = null;
	
	
	public void inicio() {
		HttpRequest request = HttpRequest
				 .newBuilder()
		         .uri(URI.create(site))
		         .GET()
		         .build();
		   HttpClient client = HttpClient
				   .newBuilder()
				   .build();
		   HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parseJson gerador = new parseJson(response);
		   
	}
		
	   
}
