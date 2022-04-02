import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String chave = "k_f7y3cnv3";
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
		   ArrayList<Filme> filmes = new ArrayList();
		   //System.out.println(moviesArray[0]);
		   for(int n=0; n<250;n++) {
			   Filme filme = new Filme();
			   System.out.println(moviesArray[n]);
			   int fimDoTitulo = moviesArray[n].indexOf("fullTitle");
			   String titulo = moviesArray[n].substring(39, fimDoTitulo-2);
			   filme.setTitulo(titulo);
			   
			   int inicioImagem = moviesArray[n].indexOf("image") + 7;
			   int fimImagem = moviesArray[n].indexOf("crew") - 2;
			   String imagem = moviesArray[n].substring(inicioImagem, fimImagem);
			   filme.setUrlImage(imagem);
			   
			   int inicioRatio = moviesArray[n].indexOf("imDbRating") + 13;
			   int fimRatio = inicioRatio +3;
			   String ratio = moviesArray[n].substring(inicioRatio, fimRatio);
			   double ratioDouble = Double.parseDouble(ratio);
			   //System.out.println(ratioDouble);
			   filme.setRating(ratioDouble);
			   
			   int inicioAno = moviesArray[n].indexOf("year") + 7;
			   int fimAno = inicioAno +4;
			   String ano = moviesArray[n].substring(inicioAno, fimAno);
			   int anoInt = Integer.parseInt(ano);
			   filme.setYear(anoInt);
			   filmes.add(filme);
			   System.out.println("Adicionado:" + titulo);
		   }
		   	int n = filmes.size();
		    for (int i=0; i<n; i++) {
		      System.out.println("Titulo: " + filmes.get(i).getTitulo());
		      System.out.println("Titulo: " + filmes.get(i).getYear());
		      
		    }

           System.out.println(site);
		System.out.println("Rodando");
		   
	}
	
	

}
