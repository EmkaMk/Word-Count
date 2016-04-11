import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class WordCounter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileReader fileReader = new FileReader(args[0]);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			HashMap<String, Integer> uniqueWords = new HashMap<>();
			// StringBuilder builder = new StringBuilder();

			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(" ");
				for (String string : words) {
					if(string.contains("?") || string.contains(".") || string.contains("!") || string.contains(","))
					{
					 string=string.replace("\\?", "").replace("!",
					 "").replace(".", "").replace(",", "");
					}

					if (!uniqueWords.containsKey(string)) {

						uniqueWords.put(string.toLowerCase(), 1);// gi dodavam
																	// unikatnite
																	// zborovi
																	// vo
																	// hashmapa
					} else if (uniqueWords.containsKey(string.toLowerCase())) {

						uniqueWords.put(string, uniqueWords.get(string) + 1);
					}

				}
			}

			bufferedReader.close();
			System.out.println(Arrays.asList(uniqueWords));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
