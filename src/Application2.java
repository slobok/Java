import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application2 {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		String line;
		Pattern pattern = Pattern.compile("title=\"(.*)\\s\\(dir\\.\\),\\s(.*),\\s(.*)\"\\s>(.*)</a>");
		Pattern pattern2 = Pattern.compile("<span\\sclass=\"secondaryInfo\">\\((.*)\\)</span>");
        Pattern pattern3 = Pattern.compile("<strong\\stitle=(.*)>(.*)</strong>");
		
        
        FileWriter output = new FileWriter("myimdb.txt", StandardCharsets.UTF_8, false);
        
       
		try {
			BufferedReader input = new BufferedReader(new FileReader("imdb.txt",StandardCharsets.UTF_8));
			while( (line = input.readLine()) != null) {
				Matcher matcher = pattern.matcher(line);
				if(matcher.find()) {
					System.out.print(matcher.group(1) + ", "  + matcher.group(2) +  ", " + matcher.group(3) + "-" + matcher.group(4));
					Movie movie = new Movie();
					movie.setTitle(matcher.group(4));
					movie.setDirector(new Director(matcher.group(1)));
					movie.setActor1(new Actor(matcher.group(2)));
					movie.setActor2(new Actor(matcher.group(3)));					
					if((line = input.readLine()) != null) {
						Matcher matcher2 = pattern2.matcher(line);
						if(matcher2.find()) {
							System.out.print("-" + matcher2.group(1));
							movie.setReleaseDate(Integer.parseInt(matcher2.group(1)));
							input.readLine();
							input.readLine();
							line = input.readLine();
							Matcher matcher3 = pattern3.matcher(line);
							if(matcher3.find()) {
								System.out.println("-" + matcher3.group(2));
								movie.setRating(Double.parseDouble(matcher3.group(2)));
								System.out.println(movie);
								output.write(String.format("%s#%s#%s#%s#%s#%s\n",
										movie.getTitle(),movie.getReleaseDate(),movie.getRating(),movie.getDirector().getName(),
										movie.getActor1().getName(),movie.getActor2().getName()));
							}	
						}
					}
				}
			}	
			input.close();
			output.close();
		}
		catch(Exception e) {
			System.err.print(e);
		}
	}
}
