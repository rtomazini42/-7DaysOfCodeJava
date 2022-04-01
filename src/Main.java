import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

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
		   ArrayList<String> titulos_filmes = new ArrayList();
		   ArrayList<String> imagens_filmes = new ArrayList();
		   //System.out.println(moviesArray[0]);
		   for(int n=0; n<250;n++) {
			   //System.out.println(moviesArray[n]);
			   int fimDoTitulo = moviesArray[n].indexOf("fullTitle");
			   String titulo = moviesArray[n].substring(39, fimDoTitulo-2);
			   int inicioImagem = moviesArray[n].indexOf("image") + 7;
			   int fimImagem = moviesArray[n].indexOf("crew") - 2;
			   String imagem = moviesArray[n].substring(inicioImagem, fimImagem);
			   titulos_filmes.add(titulo);
			   imagens_filmes.add(imagem);
			   System.out.println("Adicionado:" + titulo);
		   }
		   	int n = titulos_filmes.size();
		    for (int i=0; i<n; i++) {
		      System.out.println("Titulo: " + titulos_filmes.get(i));
		      System.out.println("imagem: " + imagens_filmes.get(i));
		      
		    }

           System.out.println(site);
		System.out.println("Rodando");
		   
	}
	
	

}
