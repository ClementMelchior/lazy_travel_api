package com.idovia.api.lazy_travel_api.external_api.guru.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;

@Repository
public class CityRepository {

	private ArrayList <CityModel> cities;

	public CityRepository () {
		cities=new ArrayList<CityModel>();
		cities.add(new CityModel("1", "Paris", "", "3DFRPAR", "7CFRparis___%40u09tv", "48.856614", "2.3522219"));
		cities.add(new CityModel("2", "Lyon", "",  "3DFRLYS", "7CFRlyon____%40u05kq", "45.764043", "4.835659"));
		cities.add(new CityModel("3", "Lourdes", "",  "", "7CFRlourdes_%40ezxvp", "43.091463", "-0.045726"));
		cities.add(new CityModel("4", "Toulouse", "",  "", "7CFRtoulouse%40spc00", "43.604652", "1.444209"));
		cities.add(new CityModel("5", "Nice", "",  "3DFRNCE", "7CFRvillmer_%40spv0w", "43.7101728", "7.2619532"));
		cities.add(new CityModel("6", "La Rochelle", "",  "3DFRRLE", "7CFRrochelle%40gbpnt", "46.160329", "-1.151139"));
		cities.add(new CityModel("7", "Carcassonne", "",  "", "7CFRcarcasso%40sp9tv", "43.212161", "2.353663"));
		cities.add(new CityModel("8", "Strasbourg", "",  "3DFRSXB", "7CFRstrasbou%40u0ts2", "48.5734053", "7.7521113"));
		cities.add(new CityModel("9", "Bordeaux", "",  "3DFRBOD", "7CFRbordeaux%40ezzx5", "44.837789", "-0.57918"));
		cities.add(new CityModel("10", "Marseille", "",  "3DFRMRS", "7CFRmarseill%40spey6", "43.296482", "5.36978"));
		cities.add(new CityModel("11", "Montpellier", "",  "3DFRMPL", "7CFRmontpell%40spfb1", "43.610769", "3.876716"));
		cities.add(new CityModel("12", "Lille", "",  "3DFRLIL", "7CFRlille___%40u140n", "50.62925", "3.057256"));
		cities.add(new CityModel("13", "Annecy", "",  "3DFRNCY", "7CFRannecy__%40u0hm5", "45.899247", "6.129384"));
		cities.add(new CityModel("14", "Avignon", "",  "3DFRAVN", "7CFRavignon_%40spg6j", "43.949317", "4.805528"));
		cities.add(new CityModel("15", "Aix-en-provence", "",  "3DFRAIE", "7CFRaixprov_%40spezs", "43.529742", "5.447427"));
		cities.add(new CityModel("16", "Angers", "",  "", "7CFRangers__%40gbrw5", "47.478419", "-0.563166"));
		cities.add(new CityModel("17", "Biarritz", "",  "", "7CFRbiarritz%40ezwzk", "43.4831519", "-1.558626"));
		cities.add(new CityModel("18", "Limoges", "",  "", "7CFRlimoges_%40u00uu", "45.833619", "1.261105"));
		cities.add(new CityModel("19", "Toulon" ,"", "", "7CFRtoulon__%40spsjq", "43.124228", "5.928"));
		cities.add(new CityModel("20", "Reims", "",  "", "7CFRreims___%40u0fb5", "49.258329", "4.031696"));
		cities.add(new CityModel("21", "Dijon", "",  "", "7CFRdijon___%40u07t4", "47.322047", "5.04148"));
		cities.add(new CityModel("22", "Troyes", "",  "", "7CFRtroyes__%40u0dfu", "48.2973451", "4.0744009"));
		cities.add(new CityModel("23", "Nimes", "",  "3DFRFNI", "7CFRnimes___%40spg17", "43.836699", "43.836699"));
		cities.add(new CityModel("24", "Amiens", "",  "", "7CFRamiens__%40u0ceu", "49.894067", "2.295753"));
		cities.add(new CityModel("25", "Tours", "",  "", "7CFRtours___%40u02mx", "47.394144", "0.68484"));
		cities.add(new CityModel("26", "Nantes", "",  "3DFRTNE", "7CFRnantes__%40gbquv", "47.218371", "-1.553621"));
		cities.add(new CityModel("27", "Rennes ", "",  "3DFRRNL", "7CFRrennes__%40gbwc9", "48.117266", "-1.6777926"));
		cities.add(new CityModel("28", "Perpignan", "",  "3DFRPGF", "7CFRperpigna%40spd4c", "42.6886591", "2.8948332"));
		cities.add(new CityModel("29", "Le mans", "",  "", "7CFRmans____%40u081h", "48.00611", "0.199556"));
		cities.add(new CityModel("30", "Pau", "",  "", "7CFRpau_____%40ezxwr", "43.2951", "-0.370797"));
		cities.add(new CityModel("31", "Le havre", "",  "", "7CFRhavre___%40u0b1d", "49.49437", "0.107929"));
		cities.add(new CityModel("32", "Caen", "",  "", "7CFRcaen____%40gbxzb", "49.182863", "-0.370679"));
		cities.add(new CityModel("33", "Rouen", "",  "", "7CFRrouen___%40u0bc3", "49.443232", "1.099971"));
		cities.add(new CityModel("34", "Chambery", "",  "3DFRCMF", "7CFRchambery%40u0h5n", "45.564601", "5.917781"));
		cities.add(new CityModel("35", "Brest", "",  "3DFRBES", "7CFRbrest___%40gbsg6", "48.390394", "-4.486076"));
		cities.add(new CityModel("37", "Nancy", "",  "3DFRENC", "7CFRjarvmalg%40u0skv", "48.692054", "6.184417"));
		cities.add(new CityModel("38", "Metz", "",  "3DFRMZM", "7CFRmetz____%40u0srs", "49.1193089", "6.1757156"));
		cities.add(new CityModel("39", "Dunkerque", "",  "", "7CFRdunkerqu%40u11dq", "51.034368", "2.376776"));
		cities.add(new CityModel("40", "Trouville-Deauville", "",  "", "7CFRtroudeau%40u0b0c", "49.353976", "0.075122"));
		cities.add(new CityModel("41", "Treve", "",  "", "", "49.749992", "6.637143"));
		cities.add(new CityModel("42", "Bruxelles", "",  "", "7CBEbruxelle%40u1514", "50.850340", "4.351710"));
		cities.add(new CityModel("43", "Gand", "",  "", "7CBEgand____%40u14dt", "51.054342", "3.717424"));
		cities.add(new CityModel("44", "Bruges", "",  "", "7CBEbruges__%40u1473", "51.209348", "3.2246995"));
		cities.add(new CityModel("45", "Anvers", "",  "", "", "51.2194475", "4.4024643"));
		cities.add(new CityModel("46", "Liege", "",  "", "7CBEliege___%40u15bn", "50.632557", "5.579666"));
		cities.add(new CityModel("47", "Luxembourg", "",  "", "7CLUluxembou%40u0u65", "49.815273", "6.129583"));
		cities.add(new CityModel("48", "Stuttgart", "",  "", "7CDEstuttgar%40u0wt8", "48.7758459", "9.1829321"));
		cities.add(new CityModel("49", "Francfort", "",  "", "7CDEfrankfur%40u0yjj", "50.1109221", "8.6821267"));
		cities.add(new CityModel("50", "Cologne", "",  "", "7CDEkoln____%40u1hcy", "50.937531", "6.9602786"));
		cities.add(new CityModel("51", "Geneve", "",  "3DFRTTX", "7CCHgeneve__%40u0hqg", "46.2043907", "6.1431577"));
		cities.add(new CityModel("52", "Lausanne", "",  "3DCHQLS", "7CCHlausanne%40u0k8w", "46.5196535", "6.6322734"));
		cities.add(new CityModel("53", "Berne", "",  "", "7CCHbern____%40u0m71", "46.9479222", "7.4446085"));
		cities.add(new CityModel("54", "Turin", "",  "", "7CITtorino__%40u0j2q", "45.070312", "7.6868565"));
		cities.add(new CityModel("55", "Milan", "",  "3DITMIL", "7CITmilano__%40u0nd9", "45.4654219", "9.1859243"));
		cities.add(new CityModel("56", "Rotterdam", "",  "", "7CNLrotterda%40u15pm", "51.9244201", "4.4777325"));
		cities.add(new CityModel("57", "Amsterdam", "",  "", "7CNLamsterda%40u176n", "52.370216", "4.895168"));
		cities.add(new CityModel("58", "Londres", "",  "3DGBLON", "7CGBlondon__%40gcpvj", "51.509093", "-0.094151"));
	}

	public List<CityModel> findAll() {
		return cities;
	}

	public CityModel findById(String id) {
		for (CityModel c : cities) {
			if (c.getId()==id) {
				return c;
			}
		}
		return null;
	}

	public CityModel findByCodeKelbillet(String code) {
		for (CityModel c : cities) {
			if (c.getCodeSncf()==code) {
				return c;
			}
		}	
		return null;
	}

}
