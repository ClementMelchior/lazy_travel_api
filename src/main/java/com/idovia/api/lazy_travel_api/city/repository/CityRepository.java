package com.idovia.api.lazy_travel_api.city.repository;

import java.util.ArrayList;
import java.util.List;

import com.idovia.api.lazy_travel_api.city.model.CityModel;

public class CityRepository {

	private ArrayList <CityModel> cities;

	public CityRepository () {
		cities.add(new CityModel("1", "Paris", "3DFRPAR", "", ""));
		cities.add(new CityModel("2", "Lyon", "3DFRLYS", "", ""));
		cities.add(new CityModel("3", "Lourdes", "3DFRLDE", "", ""));
		cities.add(new CityModel("4", "Toulouse", "3DFRTLS", "", ""));
		cities.add(new CityModel("5", "Nice", "3DFRNCE", "", ""));
		/*
		cities.add(new CityModel("6", "La Rochelle", ""));
		cities.add(new CityModel("7", "Carcassonne", ""));
		cities.add(new CityModel("8", "Strasbourg", ""));
		cities.add(new CityModel("9", "Bordeaux", ""));
		cities.add(new CityModel("10", "Marseille", ""));
		cities.add(new CityModel("11", "Montpelleir", ""));
		cities.add(new CityModel("12", "Lille", "3DFRLIL"));
		cities.add(new CityModel("13", "Annecy", ""));
		cities.add(new CityModel("14", "Avignon", ""));
		cities.add(new CityModel("15", "Aix-en-provence", ""));
		cities.add(new CityModel("16", "Angers", ""));
		cities.add(new CityModel("17", "Biarritz", ""));
		cities.add(new CityModel("18", "Limoges", ""));
		cities.add(new CityModel("19", "Toulon", ""));
		cities.add(new CityModel("20", "Reims", ""));
		cities.add(new CityModel("21", "Dijon", ""));
		cities.add(new CityModel("22", "Troyes", ""));
		cities.add(new CityModel("23", "Nimes", ""));
		cities.add(new CityModel("24", "Amiens", ""));
		cities.add(new CityModel("25", "Tours", ""));
		cities.add(new CityModel("26", "Nantes", ""));
		cities.add(new CityModel("27", "Rennes ", ""));
		cities.add(new CityModel("28", "Perpignan", ""));
		cities.add(new CityModel("29", "Le mans", ""));
		cities.add(new CityModel("30", "Pau", ""));
		cities.add(new CityModel("31", "Le havre", ""));
		cities.add(new CityModel("32", "Caen", ""));
		cities.add(new CityModel("33", "Rouen", ""));
		cities.add(new CityModel("34", "Chambery  ", ""));
		cities.add(new CityModel("35", "Brest", ""));
		cities.add(new CityModel("36", "Colmar", ""));
		cities.add(new CityModel("37", "Nancy", ""));
		cities.add(new CityModel("38", "Metz", ""));
		cities.add(new CityModel("39", "Dunkerque", ""));
		cities.add(new CityModel("40", "Trouville-Deauville", ""));
		cities.add(new CityModel("41", "Treve", ""));
		cities.add(new CityModel("42", "Bruxelles", ""));
		cities.add(new CityModel("43", "Gand", ""));
		cities.add(new CityModel("44", "Bruges", ""));
		cities.add(new CityModel("45", "Anvers", ""));
		cities.add(new CityModel("46", "Liege", ""));
		cities.add(new CityModel("47", "Luxembourg", ""));
		cities.add(new CityModel("48", "Stuttgart", ""));
		cities.add(new CityModel("49", "Francfort", ""));
		cities.add(new CityModel("50", "Cologne", ""));
		cities.add(new CityModel("51", "Geneve", ""));
		cities.add(new CityModel("52", "Lausanne", ""));
		cities.add(new CityModel("53", "Berne", ""));
		cities.add(new CityModel("54", "Turin", ""));
		cities.add(new CityModel("55", "Milan", ""));
		cities.add(new CityModel("56", "Rotterdam", ""));
		cities.add(new CityModel("57", "Amsterdam", ""));
		cities.add(new CityModel("58", "Londres", ""));
		*/
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
			if (c.getCodeKelbillet()==code) {
				return c;
			}
		}	
		return null;
	}

}
