package TextTransformation;
import java.util.HashMap;
import java.util.HashSet;
import org.json.*;


// TODO: Document class definition
public class Output {
	// TODO: Document member variable
	// TODO: Create public accessors
	private HashMap<String, NgramMap> wordGrams;
	// TODO: Document member variable
	// Gram type
	// 	1 - Word
	// 	2 - BiGram
	// 	3 - TriGram
	//  ...
	// TODO: Create public accessors
	private HashSet<String> links;
	private JSONObject metaData;
	
	public Output(HashMap<String, NgramMap> ngrams, HashSet<String> links, JSONObject meta) {
		this.wordGrams = ngrams;
		this.links=links;
		this.metaData = meta;
	}
	
	public JSONObject getMetaDataJSON() throws JSONException  {
		return new JSONObject(metaData.toString());
	}
	
	public HashSet<String> getLinksJSON() throws JSONException {
		return new HashSet<String>(links);
	}
	
	public JSONObject getNGramJSON() throws JSONException {
		JSONObject ngramJSON = new JSONObject();
		for (String key : wordGrams.keySet()) {
			JSONObject ngramGroup = new JSONObject();
			for (int n=1; n <= 5; n++) {
				ngramGroup.put(n+"grams", wordGrams.get(key).getGramsN(n));
			}
			ngramJSON.put(key, ngramGroup);
		}
		return ngramJSON;
	}
	
	public String metaDataToString() throws JSONException {
		return getMetaDataJSON().toString(2);
	}
	
	public String linksToString() throws JSONException {
		return getLinksJSON().toString();
	}
	public String ngramToString() throws JSONException {
		return getNGramJSON().toString(2);
	}

	public String toString() {
		JSONObject concatenated = new JSONObject();
		try {
			concatenated.put("meta", getMetaDataJSON());
		} catch (Exception e) {}
		try {
			concatenated.put("ngram", getNGramJSON());
		} catch (Exception e) {}
		try {
			concatenated.put("links", getLinksJSON());
		} catch (Exception e) {}
		
		
		return concatenated.toString();
	}

}

