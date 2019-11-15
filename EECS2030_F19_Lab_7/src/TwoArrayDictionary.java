/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {
	
	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary
	
	String[] words;
	String[] definitions;
	
	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */
	 
	public TwoArrayDictionary() {
    this.words = new String[100];
    this.definitions = new String[100];
    this.count = 0;
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
		if(word.contentEquals(this.words[i])) {
			return this.definitions[i];
		}
	}
	throw new WordNotInDictionaryException("");
	}
	
	@Override
	public void insertEntry(String word, String definition) throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
	if(this.count == 100) {
		throw new DictionaryFullException("");
	}
	for(int i = 0; i < this.count; i ++) {
		if(word.contentEquals(this.words[i])) {
			throw new WordAlreadyExistsInDictionaryException("");
		}
	}
	this.words[this.count] = word;
	this.definitions[this.count] = definition;
	this.count ++;
	}
	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		for(int i = 0; i < this.count; i ++) {
			if(word.contentEquals(this.words[i])) {
			int index = i;
			String w = this.definitions[index];
	        this.count --;
			for(int j = index; j < this.count; j ++) {
				this.words[j] = this.words[j + 1];
				this.definitions[j] = this.definitions[j + 1];
			}
			this.words[this.count] = null;
			this.definitions[this.count] = null;
			return w;
			}
		}
		throw new WordNotInDictionaryException("");
	}
	
	@Override
	public String[] getWords() {
		String[] ans = new String[this.count];
		for(int i = 0; i < this.count; i ++) {
			ans[i] = this.words[i];
		}
			return ans;
	}
	
	@Override
	public String[] getDefinitions() {
		String[] ans = new String[this.count];
		for(int i = 0; i < this.count; i ++) {
			ans[i] = this.definitions[i];
		}
			return ans;
	}
	
	@Override
	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] ans = new WordDefinitionPair[this.count];
		for(int i = 0; i < this.count; i ++) {
			ans[i] = new WordDefinitionPair(words[i], definitions[i]);
		}
			return ans;
	}
	}

