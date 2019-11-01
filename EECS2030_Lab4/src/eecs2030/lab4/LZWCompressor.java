package eecs2030.lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to implement LZW compression (encoding) and decompression
 * (decoding) of a given input string.
 * 
 * 
 * <p>
 * The LZWCompressor maintains a list of characters representing an input
 * sequence to be encoded/decoded. It also maintains a local LZWDictionary,
 * which is initialized with unique characters from the input sequence, and is
 * used to encode/decode the input sequence.
 * <p>
 * 
 * <p>
 * Class invariant: The LZWDictionary always holds only the initial single
 * character patterns as its entries (i.e. it may grow during encode/decode
 * operations, however must be reset to its initial state after an encode/decode
 * operation).
 * </p>
 * 
 * 
 * @author eecs2030
 *
 */
public class LZWCompressor {

	// FIELDS
	// input sequence to be encoded
	// dictionary to use when encoding/decoding
	String input;
	LZWDictionary d;
	List<String> enc;

	/**
	 * Initialize this LZWCompressor to encode/decode a specified input string.
	 * 
	 * 
	 * <p>
	 * A list of characters is initialized from the sequence of characters specified
	 * in a provided string. The unique characters from this string are also used to
	 * initialize an LZWDictionary maintained and used by the LZWCompressor when
	 * encoding/decoding
	 * </p>
	 * 
	 * 
	 * 
	 * @param input a string representing an input sequence of characters to be
	 *              encoded/decoded
	 * 
	 * @throws an IllegalArgumentException if the input string is empty
	 * 
	 */
	public LZWCompressor(String input) {
		if (input.contentEquals("")) {
			throw new IllegalArgumentException();
		}
		this.input = input;
		LZWDictionary dd = new LZWDictionary(input);
		this.d = dd;
	}

	/**
	 * Returns the original input sequence to be encoded/decoded by this
	 * LZWCompressor
	 * 
	 * @return a string representing the original input sequence
	 * 
	 */
	public String getInput() {

		return this.input;

	}

	/**
	 * Returns the dictionary used by this LZWCompressor
	 * 
	 * @return a reference to the LZWDictionary used by this LZWCompressor
	 */
	public LZWDictionary getDictionary() {

		return this.d;

	}

	/**
	 * Generates an LZW encoding of the input sequence
	 * 
	 * 
	 * <p>
	 * Uses the LZW encoding algorithm given in the lab4 specification
	 * 
	 * @return a list of integers representing the sequence of codes (indexes of
	 *         character patterns) learned by an LZWDictionary during the encoding
	 *         process
	 * 
	 */
	public List<Integer> encode() {
		List<String> single = new ArrayList<>();
		List<Integer> ret = new ArrayList<>();
		List<String> copy = new ArrayList<>();
		String cc = this.input.trim();
		if (cc.length() > 0) {

			for (String s : this.d.lentries) {
				copy.add(s);
			}

			for (int i = 0; i < cc.length(); i++) {
				single.add(Character.toString(this.input.charAt(i)));
			}
			String w = single.get(0);
			int j = 0;
			String wc = "";
			while (j < single.size() - 1) {
				j = j + 1;
				String c = single.get(j);
				wc = w + c;
				if (copy.contains(wc)) {
					w = wc;
				} else {
					ret.add(copy.indexOf(w));
					copy.add(wc);
					w = c;
				}
			}
			ret.add(copy.indexOf(w));
			this.enc = copy;
			return ret;
		}
		return ret;
	}

	/**
	 * Decodes an LZW encoding to generate the original input sequence
	 * 
	 * 
	 * <p>
	 * Uses the LZW decoding algorithm given in the lab4 specification
	 * 
	 * @param encoded a list of integers representing a sequence of codes (indexes
	 *                of character patterns) learned by an LZWDictionary during the
	 *                encoding process
	 * 
	 * @return a string representation of the decoded input sequence
	 * 
	 * @throws an IllegalArgumentException if encoded is an empty list
	 * 
	 */
	public String decode(List<Integer> encoded) {

		if (encoded.size() == 0) {
			throw new IllegalArgumentException();
		}
		this.encode();
		String in = "";
		List<String> copy1 = new ArrayList<>();
		for (String s : this.d.lentries) {
			copy1.add(s);
		}
		String prev = this.enc.get(0);
		in += prev;
		String s = "";
		String c = "";
		int j = 0;
		while (j < encoded.size() - 1) {
			j = j + 1;
			String next = this.enc.get(encoded.get(j));
			if (copy1.contains(next)) {
				s = next;
			} else {
				s = prev;
				c = Character.toString(s.charAt(0));
				s = s + c;
			}
			in += s;
			String entry = prev + Character.toString(s.charAt(0));
			copy1.add(entry);
			prev = next;
		}
		return in;
	}

	/**
	 * Returns the compression ratio of an encoding
	 * 
	 * 
	 * <p>
	 * The compression ration (CR) is defined as the number of characters in the
	 * input sequence, divided by the number of codes in the encoded version of the
	 * input sequence
	 * </p>
	 * 
	 * 
	 * @return a double representing the compression ratio
	 * 
	 */
	public double compressionRatio() {
		String c = this.input.trim();
		if (c.length() == 0) {
			return 1;
		}

		LZWCompressor n = new LZWCompressor(this.input);
		List<Integer> enc = n.encode();
		return (double) c.length() / (double) enc.size();

	}

	/**
	 * Some simple test cases that can be run independently of the junit tester
	 * 
	 */
	public static void main(String[] args) {

		LZWCompressor codec = new LZWCompressor("ababababa");

		// codec = new LZWCompressor("#@$*@#($*@#$@(#*$@(#*$@#$");
		// codec = new LZWCompressor("the fat the cat the bat the rat the mat the sat
		// the tat");
		// codec = new LZWCompressor("1231411212312312312124312413");
		// codec = new
		// LZWCompressor("thefatthecatthebattheratthematthesatthetatthefatthecatthebattheratthematthesatthe");

		// ENCODE
		System.out.println("original input sequence: " + codec.getInput());
		List<Integer> enc = codec.encode();
		System.out.println("encoded sequence: " + enc);
		System.out.println("compression ratio: " + codec.compressionRatio());
		System.out.println("-------------------");

		// DECODE
		String dec = codec.decode(enc);
		System.out.println("decoded sequence: " + dec);
		System.out.println("successful decode = " + dec.equals(codec.getInput()));

	}
}
