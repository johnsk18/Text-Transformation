<<<<<<< HEAD
package TextTransformation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.json.*;


// TODO: Document class definition
public class OutputDataStructure {
	// TODO: Document member variable
	// TODO: Create public accessors
	private HashMap<String, NGram> wordGrams;
	// TODO: Document member variable
	// Gram type
	// 	1 - Word
	// 	2 - BiGram
	// 	3 - TriGram
	//  ...
	// TODO: Create public accessors
	private int gramN;
	private HashSet<String> links;
	private HashMap<String, String> metaData;
	
	public JSONObject getMetaDataJSON() throws JSONException  {
		return new JSONObject(metaData);
	}
	
	public JSONObject getLinksJSON() throws JSONException {		
		return new JSONObject(links);
	}
	
	public JSONObject getNGramJSON() throws JSONException {
		JSONObject ngramJSON = new JSONObject();
		for (String key : wordGrams.keySet()) {
			ngramJSON.put(key, wordGrams.get(key).getMap());
		}
		return ngramJSON;
	}
	
	public String metaDataToString() throws JSONException {
		return getMetaDataJSON().toString();
	}
	
	public String linksToString() throws JSONException {
		return getLinksJSON().toString();
	}
	public String ngramToString() throws JSONException {
		return getNGramJSON().toString();
	}

	public String toString() {
		JSONObject concatenated = new JSONObject();
		try {
			concatenated.put("meta", getMetaDataJSON());
		} catch (Exception e) {}
		try {
			concatenated.put("links", getLinksJSON());
		} catch (Exception e) {}
		try {
			concatenated.put("ngram", getNGramJSON());
		} catch (Exception e) {}
		
		return concatenated.toString();
	}

}
=======
package TextTransformation;
import java.util.HashMap;
import java.util.HashSet;
import org.json.*;


// TODO: Document class definition
public class OutputDataStructure {
	// TODO: Document member variable
	// TODO: Create public accessors
	// TODO: Document member variable
	// Gram type
	// 	1 - Word
	// 	2 - BiGram
	// 	3 - TriGram
	//  ...
	// TODO: Create public accessors
	private HashSet<String> links;
	private HashMap<String, String> metaData;
	private HashMap<String, NgramMap> ngramsFromTags;
	
	public JSONObject metaDataJSON() throws JSONException  {
		JSONObject metaJSON = new JSONObject();
		metaJSON.put("meta", metaData);
		return metaJSON;
	}
	
	public JSONObject linksJSON() throws JSONException {		
		JSONObject metaJSON = new JSONObject();
		metaJSON.put("links", links);
		return metaJSON;
	}
	
	public JSONObject ngramJSON() throws JSONException {
		JSONObject metaJSON = new JSONObject();
		metaJSON.put("ngrams", ngramsFromTags);
		return metaJSON;
	}
	public String metaDataToString() throws JSONException {
		return metaDataJSON().toString();
	}
	
	public String linksToString() throws JSONException {
		return linksJSON().toString();
	}
	public String ngramToString() throws JSONException {
		return ngramJSON().toString();
	}

	public String toString() {
		JSONObject concatenated = new JSONObject();
		try {
			JSONObject metaJSON = metaDataJSON();
			concatenated.put("meta", metaJSON.get("meta"));
			JSONObject linksJSON = linksJSON();
			concatenated.put("links", linksJSON.get("links"));
			JSONObject ngramJSON = ngramJSON();		
			concatenated.put("ngram", ngramJSON.get("ngram"));
		} catch (Exception e) {
			return concatenated.toString();
		}
		return concatenated.toString();
	}

}
>>>>>>> 58e8b9e9539cb0dcb816b6ae949f7199d2112052
