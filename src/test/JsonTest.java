package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

import json.JSONException;
import json.JSONParser;
import json.JSONValue;


/**
 * Acts as an entry point or Driver class in order to test the JSON parser
 * project
 * 
 * @author James Davis - c3576413
 *
 */
public class JsonTest {

	public static void main(String[] args) {
		File f = new File(
				"/home/james/Documents/Uni/Year 2/Software Systems Development/Assignment/SSD_Sect2_Assign/src/test/Testing.json");
		
		
		try {
			//Get the root JSON object and parse it into a readable value
			JSONValue fullJSON = JSONParser.parse(new FileReader(f));
			
			String[] splitJSON = fullJSON.toString().split(",");
			
			System.out.println(fullJSON);
			System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
