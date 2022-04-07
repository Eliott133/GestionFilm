package sae;

import java.io.*;
import java.lang.Object.*;
import java.util.*;

public class sae2 {

	//public static String path = "C:/Users/Eliott/Desktop/testFilm.txt";
	public static String path = "";
	public static String row = null;
	
	public static void main(String[] args) throws InterruptedException {
		affichBien(" __     ___            ___            ___");
		affichBien("|__) | |__  |\\ | \\  / |__  |\\ | |  | |__"); 
		affichBien("|__) | |___ | \\|  \\/  |___ | \\| \\__/ |___");
		System.out.println();
		
		Thread.sleep(1000);
                                     
		FichierCharger();
	}
	public static void menu(String path) throws InterruptedException{
		int rep;
		String continu;
		cadre("Que voulez-vous faire ?","    •1 Trier la liste","    •2 Filtrer la liste","    •3 Rechercher un film","    •4 Afficher", "    •5 Retour", null, null, null, null, null);
	     //Il faudra supprimer la liste comme demandé avant de faire un retour
		rep=Clavier.lireInt();
		switch(rep) {
		case 1 :
			//il faut trier par date, nom,...
			triMenu(path);
			Thread.sleep(1500);
			System.out.println("Tapez 0 si vous souhaiter continuer");
			continu = Clavier.lireLigne();
			if(continu.equals("0")) {
				menu(path);
			}
			else {
				stop();
			}
			break;
		case 2 :
			filtreMenu(path);
			Thread.sleep(1500);
			System.out.println("Tapez 0 si vous souhaiter continuer");
			continu = Clavier.lireLigne();
			if(continu.equals("0")) {
				menu(path);
			}
			else {
				stop();
			}
			break;
		case 3 :
			System.out.println("Quelle film souhaitez vous chercher ?");
			String f = Clavier.lireLigne();
			filtreTitle(f);
			menu(path);
			break;
		case 4 :
			afficher(path);
			Thread.sleep(1500);
			System.out.println("Tapez 0 si vous souhaiter continuer");
			continu = Clavier.lireLigne();
			if(continu.equals("0")) {
				menu(path);
			}
			else {
				stop();
			}
			break;
		case 5:
			FichierCharger();
			break;
		default :
			System.out.println("Vous devez donner un chiffre (1, 2, 3 ou 4)");
			System.out.println();
			Thread.sleep(2000);
			menu(path);
			break;
		}
			
	}
	public static void rechercheMenu() throws InterruptedException{
		cadre("Tapez ce que vous voulez chercher","   •1 Retour", null, null, null, null, null, null, null, null, null);
		String rep = Clavier.lireLigne();
		switch(rep){
		case "1" :
			menu(path);
			break;
		default :
			System.out.println(rep);
			//il faut mettre la fonction de recherche ici
			break;
		}
	}
	public static void FichierCharger() throws InterruptedException{
		int rep;
		cadre("Quel fichier voulez-vous charger ?","   •1 Base complète(80 944 films)","   •2 Base partielle(40 000 fims)","   •3 Base partielle(10 000 films)","   •4 Base partielle(1 000 films)","   •5 Base partielle(100 films)","   •6 Arrêter le programme", null, null, null, null);
		rep=Clavier.lireInt();
		switch(rep) {
		case 1 :
			//charger base complète (80 944 films)
			System.out.println("Cas 1");
			path = "C:/Users/Eliott/Downloads/IMDbmoviesFULL.tsv";
			menu(path);
			break;
		case 2 :
			//charger base partielle (40 000 films)
			System.out.println("Cas 2");
			path = "C:/Users/Eliott/Downloads/IMDbmoviesCUT40000.tsv";
			menu(path);
			break;
		case 3 :
			//charger base partielle (10 000 films)
			System.out.println("Cas 3");
			path = "C:/Users/Eliott/Downloads/IMDbmoviesCUT10000.tsv";
			menu(path);
			break;
		case 4 :
			//charger base partielle (1 000 films)
			System.out.println("Cas 4");
			path = "C:/Users/Eliott/Downloads/IMDbmoviesCUT1000.tsv";
			menu(path);
			break;
		case 5 :
			//charger base partielle (100 films)
			System.out.println("Cas 5");
			path = "C:/Users/Eliott/Downloads/IMDbmoviesCUT100.tsv";
			menu(path);
			break;
		case 6 :
			stop();
		default :
			System.out.println("Vous devez donner un chiffre (1, 2, 3, 4 ou 5)");
			System.out.println();
			Thread.sleep(2000);
			FichierCharger();
			break;
		}
	}
	public static void filtreMenu(String path) throws InterruptedException{
		cadre("Par quoi voulez-vous filtrer la liste ?","   •1 Par titre","   •2 Par année de réalisation","   •3 Par genre","   •4 Par durée","   •5 Par pays de production","   •6 Par langue","   •7 Par réalisateur","   •8 Par scénariste","   •9 Par acteurs", "   •10 Retour");
		int rep=Clavier.lireInt();
		switch(rep){
		case 1:
			//Filtrer par titre
			System.out.println("Par quelle titre ?");
			String repTitle = Clavier.lireLigne();
			filtreTitle(repTitle);
			break;
		case 2:
			//Filtrer par année de réalisation
			System.out.println("Par quelle année ?");
			String repAnner = Clavier.lireLigne();
			filtreYears(repAnner);
			break;
		case 3:
			//Filtrer par genre
			System.out.println("Par quelle genre ?");
			String repGenre = Clavier.lireLigne();
			filtreGenre(repGenre);
			break;
		case 4:
			//Filtrer par durée
			System.out.println("Par quelle durée ?");
			String repDuration = Clavier.lireLigne();
			filtreDuration(repDuration);
			break;
		case 5:
			//Filtrer par pays de production
			System.out.println("Par quelle pays de production ?");
			String repCountry = Clavier.lireLigne();
			filtreCountry(repCountry);
			break;
		case 6:
			//Filtrer par langue
			System.out.println("Par quelle langue ?");
			String repLangue = Clavier.lireLigne();
			filtreLanguage(repLangue);
			break;
		case 7:
			//Filtrer par réalisateur
			System.out.println("Par quelle réalisateur ?");
			String repDirector = Clavier.lireLigne();
			filtreDirector(repDirector);
			break;
		case 8:
			//Filtrer par scénariste
			System.out.println("Par quelle scénariste ?");
			String repWriter = Clavier.lireLigne();
			filtreWriter(repWriter);
			break;
		case 9:
			//Filtrer par liste des acteurs
			System.out.println("Par quelle scénariste ?");
			String repActors = Clavier.lireLigne();
			filtreActor(repActors);
			break;
		case 10:
			menu(path);
			break;
		default :
			System.out.println("Vous devez donner un chiffre (1, 2, 3, 4, 5, 6, 7, 8, 9 ou 10)");
			System.out.println();
			Thread.sleep(3500);
			filtreMenu(path);
			break;
		
		}
	}
	public static void triMenu(String path) throws InterruptedException{
		int rep;
		cadre("Par quoi voulez-vous trier la liste ?","   •1 Par titre","   •2 Par année de réalisation","   •3 Par genre","   •4 Par durée","   •5 Par pays de production","   •6 Par langue","   •7 Par réalisateur","   •8 Par scénariste","   •9 Par acteurs", "   •10 Retour");
		rep=Clavier.lireInt();
		switch(rep){
		case 1:
			//Trier par titre
			triTitle(path);
			break;
		case 2:
			//Trier par année de réalisation
			triYears(path);
			break;
		case 3:
			//trier par genre
			triGenre(path);
			break;
		case 4:
			//trier par durée
			break;
		case 5:
			//trier par pays de production
			filtreCountry(path);
			break;
		case 6:
			//trier par langue
			triLanguage(path);
			break;
		case 7:
			//trier par réalisateur
			triDirector(path);
			break;
		case 8:
			//trier par scénariste
			triWriter(path);
			break;
		case 9:
			//trier par liste des acteurs
			triActors(path);
			break;
		case 10:
			menu(path);
			break;
		default :
			System.out.println("Vous devez donner un chiffre (1, 2, 3, 4, 5, 6, 7, 8, 9 ou 10)");
			System.out.println();
			Thread.sleep(3500);
			triMenu(path);
			break;
		
		}
	}
	
	
	public static void typeTri () throws InterruptedException{
        int rep;
        cadre("Comment voulez-vous trier la liste ?","   •1 En tri java", "   •2 En tri selection", "   •3 En tri fusion", "   •4 Retour", null, null, null, null, null, null );
        rep=Clavier.lireInt();
        switch(rep){
        case 1:
            //tri java
            break;
        case 2:
            //tri selection
            break;
        case 3:
            //tri fusion
            break;
        case 4:
            triMenu(path);
        default:
            System.out.println("Vous devez donner un chiffre (1, 2, 3 ou 4)");
            System.out.println();
            Thread.sleep(3500);
            typeTri();
            break;


        }
    }
	
	public static void cadre(String ch1, String ch2, String ch3, String ch4, String ch5, String ch6, String ch7, String ch8, String ch9, String ch10, String ch11){

		System.out.println("╔═══════════════════════════════════════════╗");
		ligneC(ch1);
		ligneC(ch2);
		ligneC(ch3);
		ligneC(ch4);
		ligneC(ch5);
		ligneC(ch6);
		ligneC(ch7);
		ligneC(ch8);
		ligneC(ch9);
		ligneC(ch10);
		ligneC(ch11);
		System.out.println("╚═══════════════════════════════════════════╝");
	}
	public static void ligneC(String ch){
		int n, i;
		if(ch!=null){
			n=ch.length();
			System.out.print("║ "+ch);
			for(i=0;i<41-n;i++){
				System.out.print(" ");
			}
			System.out.print(" ║\n");
		}
	}
	public static void stop(){
		try {
			affichBien("                                     _ ");
			affichBien("    /\\                              (_)");
			affichBien("   /  \\  _   _   _ __ _____   _____  _ _ __ ");
			affichBien("  / /\\ \\| | | | | '__/ _ \\ \\ / / _ \\| | '__|");
			affichBien(" / ____ \\ |_| | | | |  __/\\ V / (_) | | |   ");
			affichBien("/_/    \\_\\__,_| |_|  \\___| \\_/ \\___/|_|_|  ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                                             
		System.exit(0);
	}

	public static void triTitleId(String path) {
		String value[] = null;
		LinkedList<Film> g= new LinkedList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Collections.sort(g, Film.compareTitleId);
			Iterator<Film> it = g.iterator();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void triTitle(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			//Collections.sort(g, Film.compareTitle);
			triSelection(g, Film.compareTitle);
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void triYears(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Collections.sort(g, Film.compareYears);
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void triGenre(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Collections.sort(g, Film.compareGenre);
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void triCountry(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Collections.sort(g, Film.compareCountry);
			Iterator<Film> it = g.iterator();
			//it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void triDirector(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Collections.sort(g, Film.compareDirector);
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void triLanguage(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Collections.sort(g, Film.compareLanguage);
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void triWriter(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Collections.sort(g, Film.compareWriter);
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void triActors(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Collections.sort(g, Film.compareActors);
			Iterator<Film> it = g.iterator();
			//it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(i+" - "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void afficher(String path) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void filtreGenre(String genreFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.genre.contains(genreFiltre));
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void filtreYears(String yearFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.year.contains(yearFiltre));
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void filtreCountry(String countryFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.country.contains(countryFiltre));
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void filtreLanguage(String languageFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.language.contains(languageFiltre));
			Iterator<Film> it = g.iterator();
			//it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void filtreDuration(String durationFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.duration.contains(durationFiltre));
			Iterator<Film> it = g.iterator();
			it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void filtreTitle(String titleFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.title.contains(titleFiltre));
			Iterator<Film> it = g.iterator();
			//it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void filtreDirector(String directorFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.director.contains(directorFiltre));
			Iterator<Film> it = g.iterator();
			//it.next();
			int i =1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void filtreWriter(String writerFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.writer.contains(writerFiltre));
			Iterator<Film> it = g.iterator();
			//it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void filtreActor(String actorsFiltre) {
		String value[] = null;
		ArrayList<Film> g= new ArrayList<Film>();
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			while((row = read.readLine()) != null) {
				value = row.split("\t");
				String titleId = value[0];
				titleId=String.format("%-20s", titleId);
				String title = value[1];
				title=String.format("%-65s", title);
				String year = value[3];
				year=String.format("%-7s", year);
				String datePublished = value[4];
				datePublished=String.format("%-20s", datePublished);
				String genre = value[5];
				genre=String.format("%-30s", genre);
				String duration = value[6];
				duration=String.format("%-10s", duration);
				String country = value[7];
				country=String.format("%-80s", country);
				String language = value[8];
				language=String.format("%-71s", language);
				String director = value[9];
				director=String.format("%-50s", director);
				String writer = value[10];
				writer=String.format("%-65s", writer);
				String actors = value[12];
				actors=String.format("%-417s", actors);
				String description = value[13];
				description=String.format("%-261s", description);
				String avgVote = value[14];
				avgVote=String.format("%-11s", avgVote);
				String votes = value[15];
				votes=String.format("%-261s", votes);
				g.add(new Film(titleId, title, year, datePublished, genre, duration, country, language, director, 
						writer, actors, description, avgVote, votes));
			}
			g.removeIf(f -> !f.actors.contains(actorsFiltre));
			Iterator<Film> it = g.iterator();
			//it.next();
			int i = 1;
			while (it.hasNext()){
				System.out.println(compteur(i)+ " "+it.next());
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
	public static void nbColumn(String path) {
		String value[] = null;
		try {
			BufferedReader read = new BufferedReader(new FileReader(path));
			row = read.readLine();
			value = row.split("\t");
			int nbColumn = value.length;
			System.out.println(nbColumn);
			for(int i=0;i<=nbColumn-1;i++) {
				System.out.println(value[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String compteur(int nb) {
		return nb+"     -";
	}
	
	public static void triSelection(List<Film> filmList, Comparator<Film> comp)
    {
        ListIterator<Film> i = filmList.listIterator();

        while(i.hasNext())
        {
            ListIterator<Film> min = filmList.listIterator(i.nextIndex());
            ListIterator<Film> j = filmList.listIterator(i.nextIndex());

            while(j.hasNext())
            {
                if(comp.compare((Film) j.next(), (Film)min.next()) < 0)
                {
                    min = filmList.listIterator(j.previousIndex());
                }
                else
                {
                    min.previous();
                }
            }

            Film tempFilm = (Film) min.next();
            min.set(i.next());
            i.set(tempFilm);
        }
    }
	
	public static void affichBien(String mot) throws InterruptedException{
		int n=mot.length();
		for (int i=0;i<n;i++){
			System.out.print(mot.charAt(i));
			Thread.sleep(16);
		}
		System.out.println();
	}
	
	
	public static void recherchelineaire(List<Film> maListe) 
	{
        double temps;

        Collections.sort(maListe, Film.compareTitle);
        System.out.println("Quel est le titre du film que vous rechercher ?");
        String rep = Clavier.lireLigne();

        long start = System.nanoTime();

        List<Film> ListeAffichage = new LinkedList<Film>();
        for (int i = 0; i < maListe.size(); i++) {
                if (Film.getTitle(maListe.get(i)).strip().equals(rep)) {
                        ListeAffichage.add(maListe.get(i));
                        Iterator<Film> it = ListeAffichage.iterator();
                        while (it.hasNext()) {
                                System.out.println(it.next());
                        }
                        break;
                }
        }
        long stop = System.nanoTime();
        temps=(float) (stop - start)/1000000;
        
        if (ListeAffichage.isEmpty()) {
                System.out.println("Le film du nom de " + rep + " n'existe pas");
        }
	}
}


