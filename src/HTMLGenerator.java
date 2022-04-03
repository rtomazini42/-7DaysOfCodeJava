
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class HTMLGenerator {
	
	public void generate(List<Filme> Filmes) throws IOException {
		String head =
				"""
				<head>
					<meta charset=\"utf-8\">
					<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
					<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
						+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
				</head>
				""";
		try {
			Writer w = new FileWriter("output.html");  
			w.write(head);
			int n = Filmes.size();
			for (int i=0; i<n; i++) {
			      System.out.println("Titulo: " + Filmes.get(i).getTitulo());
			      System.out.println("Ano: " + Filmes.get(i).getYear());
			      w.write("<h1>" + Filmes.get(i).getTitulo() + "</h1>"); 
			      String img = "<img src="
			      		+ Filmes.get(i).getUrlImage();			      		
			      w.write(img + "\">");
			      System.out.println(img);
			      w.write("<p> Ano: " + Filmes.get(i).getYear() + "</p>");
			      w.write("<p> Nota: " + Filmes.get(i).getRating() + "</p>");
			      w.write("<br></br>");
			    }
			w.close();
		}catch (IOException e) {  
            e.printStackTrace(); }
		

	}
}
