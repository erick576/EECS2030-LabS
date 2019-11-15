/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict;
	
	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
	public OneArrayDictionary() {
	this.dict = new WordDefinitionPair[100];
	this.count = 0;
	}
	
	public OneArrayDictionary(int count, WordDefinitionPair[] dict) {
		this.count = count;
		this.dict = dict;
	}
	
	
	@Override
	public int size() {
		return this.count;
	}
	
	@Override
	public boolean isEmpty() {
		return (this.count == 0);
	}
	
	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
	for(int i = 0; i < this.count; i ++) {
		if(word.contentEquals(this.dict[i].getWord())) {
			return this.dict[i].getDefinition();		}
	}	
    throw new WordNotInDictionaryException("");
	}
	
	@Override
	public void insertEntry(String word, String definition) throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
	if(this.count == 100) {
		throw new DictionaryFullException("");
	}
	for(int i = 0; i < this.count; i ++) {
		if(word.contentEquals(this.dict[i].getWord())) {
		throw new  WordAlreadyExistsInDictionaryException("");			
		}
	}
	WordDefinitionPair w = new WordDefinitionPair(word, definition);
	this.dict[this.count] = w;
	this.count ++;
	}
	
	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
	for(int i = 0; i < this.count; i ++) {
		if(word.contentEquals(this.dict[i].getWord())) {
		int index = i;
		String w = this.dict[index].getDefinition();
        this.count --;
		for(int j = index; j < this.count; j ++) {
			this.dict[j] = this.dict[j + 1];
		}
		this.dict[this.count] = null;
		return w;
		}
	}
	throw new WordNotInDictionaryException("");
	}
	
	@Override
	public String[] getWords() {
	String[] ans = new String[this.count];
	for(int i = 0; i < this.count; i ++) {
		ans[i] = this.dict[i].getWord();
	}
		return ans;
	}
	
	@Override
	public String[] getDefinitions() {
		String[] ans = new String[this.count];
		for(int i = 0; i < this.count; i ++) {
			ans[i] = this.dict[i].getDefinition();
		}
			return ans;
	}
	
	@Override
	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] ans = new WordDefinitionPair[this.count];
		for(int i = 0; i < this.count; i ++) {
			ans[i] = this.dict[i];
		}
			return ans;
	}

}
