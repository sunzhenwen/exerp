package exerp;

/**
 * @author Sun
 * word: the unique word
 * counter: the number of occurrences of the word
 *
 */
public class Word {

	private String  word;
	private int counter;
	
	public Word(String word, int counter) {
		super();
		this.word = word;
		this.counter = counter;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return word + " (" + counter + ")";
	}
	
}
