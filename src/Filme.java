
public class Filme implements Content{
		
	
	
	
	private String titulo;
	private String urlImage;
	private double rating;
	private int year;
	
	public int compareTo(Content outro) {
	    return this.rating().compareTo(outro.rating());
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String title() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String urlImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String rating() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String year() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
