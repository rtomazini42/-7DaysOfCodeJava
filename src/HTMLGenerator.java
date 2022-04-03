
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {
	
	public void generate(List<Filme> Filmes) throws IOException {
		try {
			Writer w = new FileWriter("output.html");  
			int n = Filmes.size();
			for (int i=0; i<n; i++) {
			      System.out.println("Titulo: " + Filmes.get(i).getTitulo());
			      System.out.println("Ano: " + Filmes.get(i).getYear());
			      w.write("<h1>" + Filmes.get(i).getTitulo() + "</h1>"); 
			      String img = "<img src="
			      		+ Filmes.get(i).getUrlImage();			      		
			      w.write(img + "\">");
			      System.out.println(img);
			      w.write("<p> Lançado em: " + Filmes.get(i).getYear() + "</p>");
			      w.write("<p> Nota: " + Filmes.get(i).getRating() + "</p>");
			      w.write("<br></br>");
			    }
			w.close();
		}catch (IOException e) {  
            e.printStackTrace(); }
		

	}
}
