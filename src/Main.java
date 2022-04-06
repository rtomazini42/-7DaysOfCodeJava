import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
System.out.println("Rodando");
	ImdbApiClient inicio = new ImdbApiClient();
	inicio.inicio();
	System.out.println("Terminado");
	
	

	}
}