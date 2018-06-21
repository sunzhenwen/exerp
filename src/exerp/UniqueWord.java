package exerp;

import java.io.*;
import java.util.ArrayList;

public class UniqueWord {

	public static void main(String[] args) {
		ArrayList<Word> uniqueWords = new ArrayList<Word>();
		File file = new File("testFiles/tempest.txt");
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String oneLine = null;
			
			while((oneLine = reader.readLine()) != null) {
				if(!oneLine.equals("")) {
					String[] words = oneLine.split(" ");
					for (int i = 0; i < words.length; i++) {
						String str = words[i];
						// remove punctuation in the word except "'" and "-".
						String str2 = str.replaceAll("(?!\')(?!-)\\p{Punct}", "");
						str2 = str2.toLowerCase();
						// split the string by the tab "\t"
						String[] strss = str2.split("\t");
						for (int j = 0; j < strss.length; j++) {
							String string = strss[j];
							checkUniqueWord(uniqueWords, string);
						}
						//checkUniqueWord(uniqueWords, str2);
						/*// split the string by "--"
						String[] strss = str.split("--");
						for (int j = 0; j < strss.length; j++) {
							String str2 = strss[j];
							str2 = str2.toLowerCase();
							// check whether str2 has occurred in any Word of the list uniqueWords
							checkUniqueWord(uniqueWords, str2);
						}*/
					}
				}				
			}						
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//The top 10 occurrences
		topTen(uniqueWords);
		
	}
	
	/**
	 * @param ws: a list of Word classes
	 * Based on the Bubble Sort algorithm
	 */
	private static void topTen(ArrayList<Word> ws) {
		Word temp = null;
		for(int i=0;i<ws.size()-1;i++){
	        for(int j=0;j<ws.size()-1-i;j++){  
	        	if(ws.get(j).getCounter() < ws.get(j+1).getCounter()){  
	        		temp = ws.get(j);
	        		ws.set(j, ws.get(j+1));
	        		ws.set(j+1, temp);
	        	}  
	        } 
		}
		
		// print top 10 occurrences
		for (int i = 0; i < ws.size(); i++) {
			System.out.println(ws.get(i).toString());
		}
		
	}

	/**
	 * @param uniqueWords is a list of Word
	 * @param a string s
	 * 
	 * if exist a Word class which its argument "word" is the same string of s,
	 * then the counter plus 1
	 * otherwise, create a new Word class.
	 */
	public static ArrayList<Word> checkUniqueWord(ArrayList<Word> uniqueWords, String s) {
		if (uniqueWords.size() == 0) {
			uniqueWords.add(new Word(s,1));
		} else {
			Word word = uniqueWords.get(0);
			if(word.getWord().equals(s)) {
				word.setCounter(word.getCounter() + 1);
			} else {
				uniqueWords.remove(word);
				uniqueWords = checkUniqueWord(uniqueWords, s);
				uniqueWords.add(word);
			}
		}
		return uniqueWords;
	}
	
}
