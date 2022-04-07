package sae;

import java.io.*;
import java.util.*;

import tp3.JeuVideo;

public class File {
	static String row = "";
	static int longColumn = 22;
	public File(String path) {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
	
		String path;
		//PAHT : C://Users//Eliott//Downloads/IMDbmoviesCUT100.tsv
		System.out.println("Quelle fichier ? ");
		Scanner lire = new Scanner(System.in);
		path = lire.next();
		path = path.toLowerCase();
		lire.close();
		switch(path) {
		
		case "100":
			path = "C://Users//Eliott//Downloads/IMDbmoviesCUT100.tsv";
			break;
		
		case "1000":
			path = "C://Users//Eliott//Downloads/IMDbmoviesCUT1000.tsv";
			break;
		
		case "10000":
			path = "C://Users//Eliott//Downloads/IMDbmoviesCUT10000.tsv";
			break;
			
		case "40000":
			path = "C://Users//Eliott//Downloads/IMDbmoviesCUT40000.tsv";
			break;
			
		case "full":
			path = "C://Users//Eliott//Downloads/IMDbmoviesFULL.tsv";
			break;
		}
		
		System.out.println("Vous avez choisi : "+ path);
		//lireFichierColumn(1, path);
		lire(path);
	}
	
	
	/*public static void lireFichierColumn(int nbColumn, String path) {
		String value[] = null;
		int i = 0;
		int nbRow = 0;
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			row = read.readLine();
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				//System.out.println(value.length);
				System.out.println(value[5]);
			}
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public static void lire(String path) {
		
		/*Film film1 = new Film("Star wars", "eliot", "2004");
		Film film2 = new Film("Simpson", "math", "2000");
		Film film3 = new Film("Fast & furious", "grosBras", "2013");
		Film film4 = new Film("Rick & morty", "rick", "2006");
		
		LinkedList<Film> l = new LinkedList<Film>();		
		l.add(film1);
		l.add(film2);
		l.add(film3);
		l.add(film4);
		Collections.sort(l, Film.compareAuthor);
		Iterator<Film> it = l.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}*/
		//String path = "C://Users/Eliott/Desktop/testFilm.txt";
		String[] value = null;
		ArrayList<Film> g = new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			//row = read.readLine();
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				String title = value[1];
				String originalTitle = value[2];
				String years = value[3];
				String date = value[4];
				String genre = value[5];
				String duration = value[6];
				String pays = value[7];
				String director = value[8];
				String writer = value[9];
				String companyProd = value[10];
				String actor = value[11];
				String description = value[12];
				String avgVote = value[13];
				String vote = value[14];
				String budget = value[15];
				String usa = value[16];
				String truc = value[17];
				String metascore = value[18];
				System.out.println(value[17]);

				
				g.add(new Film (titleId, title, originalTitle, years, date, genre, duration, pays, director, writer, companyProd, actor, description, avgVote, vote, budget, usa, truc, metascore));
				Collections.sort(g, Film.compareTitle);
				/*Film f1 = new Film(titleId, title, originalTitle, years, date, genre, duration, pays, director, writer, companyProd, actor, description, avgVote, vote, budget, usa, truc, metascore);
				System.out.println(f1);*/
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
	}

}
