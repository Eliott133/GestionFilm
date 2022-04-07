package sae;

import java.io.Serializable;
import java.util.Comparator;

import tp3.JeuVideo;

public class Film implements Serializable{
	String titleId, title, year, originalTitle, datePublished, genre, duration, country, language, director, writer, productionCompany, actors, description, avgVote, votes;
	Film(String a, String b, String d, String e, String f, String g, String h, String i, String j, String k, String m, String n, String o, String p) {
		titleId = a;
		title = b;
		year = d;
		datePublished = e;
		genre = f;
		duration = g;
		country = h;
		language = i;
		director = j;
		writer = k;
		actors = m;
		description = n;
		avgVote = o;
		votes = p;
	}
	
	static public Comparator<Film> compareTitleId = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.titleId.compareToIgnoreCase(f2.titleId);

	    }
	};	
	
	static public Comparator<Film> compareTitle = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.title.compareToIgnoreCase(f2.title);

	    }
	};	
	
	static public Comparator<Film> compareYears = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.year.compareToIgnoreCase(f2.year);

	    }
	};	
	
	static public Comparator<Film> compareGenre = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.genre.compareToIgnoreCase(f2.genre);

	    }
	};	
	
	static public Comparator<Film> compareCountry = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.country.compareToIgnoreCase(f2.country);

	    }
	};
	
	static public Comparator<Film> compareLanguage = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.language.compareToIgnoreCase(f2.language);

	    }
	};
	
	static public Comparator<Film> compareDirector = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.director.compareToIgnoreCase(f2.director);

	    }
	};
	
	static public Comparator<Film> compareWriter = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.writer.compareToIgnoreCase(f2.writer);

	    }
	};
	
	static public Comparator<Film> compareCompanyProd = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.productionCompany.compareToIgnoreCase(f2.productionCompany);

	    }
	};
	
	static public Comparator<Film> compareActors = new Comparator <Film>() {

	    public int compare(Film f1, Film f2) {

	        return f1.actors.compareToIgnoreCase(f2.actors);

	    }
	};
	
	
	public String toString()
	{
		return ("Identifiant: "+titleId+" ║ Titre: "+title+" ║ Année: "+year+" ║ Date: "+datePublished+" ║ Genre: "+genre+" ║ Durée: "+duration+" ║ Pays de produciton: "+country+" ║ Langue: "+country+" ║ Producteur: "+director+" ║ Scénariste: "+writer+" ║ Acteurs: "+actors+" ║ Description: "+description+" ║ Moyenne des votes: "+avgVote+" ║ Votes: "+votes);
	}


	public static String getTitle(Film f1) {
		return f1.title;
	}

}
