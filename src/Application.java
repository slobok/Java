import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class Application {

	public static void main(String[] args) {
		
	LinkedList < Movie > movies = new LinkedList < Movie > ();
	String line = null;

	try {
		BufferedReader input = new BufferedReader(new FileReader("imdb_simple.txt",StandardCharsets.UTF_8));
		while( (line = input.readLine()) != null)
			movies.add(lineToMovie(line));
	}
	catch(Exception e) {
		System.err.print(e);
	}
	
	System.out.println("Movies collection:");
	Iterator iter = movies.iterator();
	while(iter.hasNext()) {
		System.out.println(iter.next());
	}
	
	System.out.println("Movies sorted by year");
	Collections.sort(movies,new MoviesByYear());	
	iter = movies.iterator();
	while(iter.hasNext())
		System.out.println(iter.next());
	
	Map <String,Double> map1 = new < String,Double > HashMap(); 
	for(Movie movie : movies) {
		String actor1 = movie.getActor1().getName();
		String actor2 = movie.getActor2().getName();
		if(map1.containsKey(actor1)) {
			map1.put(actor1,map1.get(actor1) + 1);
		}
		else {
			map1.put(actor1, 1.0);
		}
		if(map1.containsKey(actor2)) {
			map1.put(actor2, map1.get(actor2) + 0.4);
		}
		else {
			map1.put(actor2, 0.4);
		}
	}
	ArrayList < Entry < String, Double >> entries = new ArrayList <Entry<String,Double>>(map1.entrySet());
	entries.sort(Entry.comparingByValue(Comparator.reverseOrder()));
	System.out.println("Actor with highest score:");
	System.out.println(entries.get(0).getKey() + "  - " + entries.get(0).getValue());	
	}
	
	
	public static Movie lineToMovie(String line) {
		String arg[] = line.split("#");
		return new Movie(arg);
	}

}
