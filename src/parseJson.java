import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;


public class parseJson implements JsonParser{
	public parseJson(HttpResponse<String> response){
		String json = response.body().substring(response.body().indexOf("[") + 1, response.body().lastIndexOf("]"));
        String topMovies = json.replace("},{", "},,{");
        String[] moviesArray = topMovies.split(",,");      
		   System.out.println(response.body());
		   ArrayList<Filme> filmes = new ArrayList<Filme>();
		   //System.out.println(moviesArray[0]);
		   for(int n=0; n<250;n++) {
			   Filme filme = new Filme();
			   //System.out.println(moviesArray[n]);
			   int inicioDoTitulo = moviesArray[n].indexOf("Title");
			   int fimDoTitulo = moviesArray[n].indexOf("fullTitle");
			   String titulo = moviesArray[n].substring(38, fimDoTitulo-3);
			   titulo = titulo.replace(":", " ");
			   titulo = titulo.replace("\"", " ");
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
			   //System.out.println("Adicionado:" + titulo);
		   }
		   
		   HTMLGenerator g = new HTMLGenerator();
		   try {
			g.generate(filmes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
		

