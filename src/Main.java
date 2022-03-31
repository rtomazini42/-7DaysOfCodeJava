import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String chave = "sua_chave";
		String site = "https://imdb-api.com/en/API/Top250Movies/" + chave;
		
			HttpRequest request = HttpRequest
				 .newBuilder()
		         .uri(URI.create(site))
		         .GET()
		         .build();
		   HttpClient client = HttpClient
				   .newBuilder()
				   .build();
		   HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           String json = response.body().substring(response.body().indexOf("[") + 1, response.body().lastIndexOf("]"));

           String topMovies = json.replace("},{", "},,{");

           String[] moviesArray = topMovies.split(",,");
           
		   System.out.println(response.body());
		   //System.out.println(moviesArray[0]);
		   for(int n=0; n<250;n++) {
			   System.out.println(moviesArray[n]);
		   }
		
           System.out.println(site);
		System.out.println("Rodando");
		   
	}
	
	

}
