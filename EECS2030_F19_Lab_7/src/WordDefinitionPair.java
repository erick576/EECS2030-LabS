public class WordDefinitionPair {

	private String word;
	private String definition;

	public WordDefinitionPair(String word, String definition) {
		this.setWord(word);
		this.setDefinition(definition);
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		WordDefinitionPair other = (WordDefinitionPair) obj;
		if(this.getWord().contentEquals(other.getWord()) && this.getDefinition().contentEquals(other.getDefinition())) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.word + ": " + this.definition;
	}
	
	
}
