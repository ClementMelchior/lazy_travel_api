package com.idovia.api.lazy_travel_api.external_api.guru.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.idovia.api.lazy_travel_api.external_api.guru.model.StationModel;

@Repository
public class StationRepository {

    private ArrayList<StationModel> stations = new ArrayList <StationModel> ();
    
    
    public StationRepository () {
        this.stations.add(new StationModel("1", "8700011"));
        this.stations.add(new StationModel("1", "8700013"));
        this.stations.add(new StationModel("1", "8700014"));
        this.stations.add(new StationModel("1", "8700012"));
        this.stations.add(new StationModel("1", "8700010"));
        this.stations.add(new StationModel("1", "8700015"));
        this.stations.add(new StationModel("2", "8700152"));
        this.stations.add(new StationModel("2", "8700040"));
        this.stations.add(new StationModel("2", "8702384"));
        this.stations.add(new StationModel("3", "8700105"));
        this.stations.add(new StationModel("4", "8700065"));
        this.stations.add(new StationModel("4", "8704730"));
        this.stations.add(new StationModel("4", "8706544"));
        this.stations.add(new StationModel("4", "8702033"));
        this.stations.add(new StationModel("5", "8700171"));
        this.stations.add(new StationModel("6", "8700202"));
        this.stations.add(new StationModel("7", "8700100"));
        this.stations.add(new StationModel("8", "8700023"));
        this.stations.add(new StationModel("9", "8700047"));
        this.stations.add(new StationModel("10", "8700074"));
        this.stations.add(new StationModel("10", "8700464"));
        this.stations.add(new StationModel("11", "8700097"));
        this.stations.add(new StationModel("11", "8768888"));
        this.stations.add(new StationModel("12", "8700030"));
        this.stations.add(new StationModel("12", "8704949"));
        this.stations.add(new StationModel("13", "8700135"));
        this.stations.add(new StationModel("14", "8704918"));
        this.stations.add(new StationModel("14", "8700172"));
        this.stations.add(new StationModel("15", "8700157"));
        this.stations.add(new StationModel("15", "8704980"));
        this.stations.add(new StationModel("16", "8700022"));
        this.stations.add(new StationModel("17", "8700114"));
        this.stations.add(new StationModel("18", "8700029"));
        this.stations.add(new StationModel("19", "8700108"));
        this.stations.add(new StationModel("20", "8700081"));
        this.stations.add(new StationModel("20", "8701874"));
        this.stations.add(new StationModel("21", "8700021"));
        this.stations.add(new StationModel("21", "8700429"));
        this.stations.add(new StationModel("22", "8700273"));
        this.stations.add(new StationModel("23", "8700151"));
        this.stations.add(new StationModel("23", "8770397"));
        this.stations.add(new StationModel("24", "8700001"));
        this.stations.add(new StationModel("24", "8700599"));
        this.stations.add(new StationModel("25", "8700161"));
        this.stations.add(new StationModel("26", "8700020"));
        this.stations.add(new StationModel("26", "8700618"));
        this.stations.add(new StationModel("27", "8700025"));
        this.stations.add(new StationModel("28", "8700164"));
        this.stations.add(new StationModel("29", "8700435"));
        this.stations.add(new StationModel("30", "8700106"));
        this.stations.add(new StationModel("31", "8700112"));
        this.stations.add(new StationModel("32", "8700223"));
        this.stations.add(new StationModel("33", "8700113"));
        this.stations.add(new StationModel("34", "8700055"));
        this.stations.add(new StationModel("35", "8700434"));
        this.stations.add(new StationModel("36", "8700178"));
        this.stations.add(new StationModel("37", "8700018"));
        this.stations.add(new StationModel("38", "8700019"));
        this.stations.add(new StationModel("39", "8700004"));
        this.stations.add(new StationModel("40", "8704747"));
        this.stations.add(new StationModel("41", "8000134"));
        this.stations.add(new StationModel("42", "8800004"));
        this.stations.add(new StationModel("42", "8800002"));
        this.stations.add(new StationModel("42", "8800003"));
        this.stations.add(new StationModel("42", "8800005"));
        this.stations.add(new StationModel("43", "8800031"));
        this.stations.add(new StationModel("44", "8800029"));
        this.stations.add(new StationModel("45", "8800007"));
        this.stations.add(new StationModel("45", "8800187"));
        this.stations.add(new StationModel("46", "8800012"));
        this.stations.add(new StationModel("47", "8200100"));
        this.stations.add(new StationModel("48", "8000096"));
        this.stations.add(new StationModel("49", "8000105"));
        this.stations.add(new StationModel("50", "8003368"));
        this.stations.add(new StationModel("51", "8501008"));
        this.stations.add(new StationModel("52", "8501120"));
        this.stations.add(new StationModel("53", "8507000"));
        this.stations.add(new StationModel("54", "8300001"));
        this.stations.add(new StationModel("54", "8300522"));
        this.stations.add(new StationModel("54", "8300516"));
        this.stations.add(new StationModel("55", "8300046"));
        this.stations.add(new StationModel("55", "8300418"));
        this.stations.add(new StationModel("55", "8300047"));
        this.stations.add(new StationModel("56", "8400530"));
        this.stations.add(new StationModel("56", "8400507"));
        this.stations.add(new StationModel("57", "8400058"));
        this.stations.add(new StationModel("57", "8400561"));
        this.stations.add(new StationModel("58", "7001424"));
    }



    public List<StationModel> findAll() {
        return this.stations;
    }

    public List<StationModel> findAllByIdCity(String id) {
        return findAll().stream()
            .filter(s->s.getIdCity()==id)
            .collect(Collectors.toList());
    }
    
}
