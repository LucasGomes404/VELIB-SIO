package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public class JPasserelle {
	private static String url;
	private static final Carte c = new Carte();
	
	public static Carte getCarte() {
		String num_adresse = null;
		
		try {
			String url = "https://opendata.paris.fr/api/records/1.0/search/?dataset=velib-disponibilite-en-temps-reel&q=&facet=name&facet=is_installed&facet=is_renting&facet=is_returning&facet=nom_arrondissement_communes";
			InputStream lien = new URL(url).openStream();
			BufferedReader fichier = new BufferedReader(new InputStreamReader(lien, StandardCharsets.UTF_8));
			JSONObject json = new JSONObject(fichier.readLine());
			fichier.close();
			JSONArray data = json.getJSONArray("records");
			
			for(int i = 0; i < json.getInt("nhits"); i++) {
				JSONObject js = data.getJSONObject(i);
				JSONObject fields = js.getJSONObject("fields");	
				String stationcode = fields.getString("stationcode");
				
				switch (stationcode.charAt(0)) {
				case '1' :
					if (stationcode.length() <= 4) {
						num_adresse = stationcode.substring(0,1);
					} else {
						num_adresse = stationcode.substring(0,2);
					}
					break;
				
				case '2' :
					if (!Objects.equals(fields.get("nom_arrondissement_communes"), "Paris")) {
						num_adresse = "92";
					} else if (stationcode.length() <= 4) {
						num_adresse = stationcode.substring(0,1);
					} else {
						num_adresse = stationcode.substring(0,2);
					}
					break;
					
				case '3' :
				case '4' :
				case '5' :
				case '6' :
				case '7' :
				case '8' :
				case '9' :
					if (stationcode.length() <= 4) {
						if (stationcode.substring(0, 4).equals("9001") || stationcode.substring(0,4).equals("9002")) {
							num_adresse = "10";
						} else {
							num_adresse = stationcode.substring(0,1);
						}
					} else {
						if (stationcode.substring(0,2).equals("92")) {
							num_adresse = "mobile";
						} else {
							num_adresse = "9" +stationcode.charAt(0);
						}
					}
					break;
				
				default :
					System.err.println("Erreur code velib.Station : " + fields.get("stationcode"));
					break;
				}
				
				c.ajouteStation(stationcode, fields.getString("name"), num_adresse, fields.getString("duedate"), fields.getString("is_renting"), fields.getString("is_installed"), fields.getInt("capacity"), fields.getInt("nomdocksavailable"), fields.getInt("numbikesavailable"));
			}			
		} catch (FileNotFoundException e) {
			System.err.println("Erreur : Le fichier n'existe pas !\n" + e);
		} catch (IOException e) {
			System.err.println("Erreur : \n" + e);
		}
		
		return c;
	}
}
