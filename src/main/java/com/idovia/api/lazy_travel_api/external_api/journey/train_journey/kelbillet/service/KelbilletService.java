package com.idovia.api.lazy_travel_api.external_api.journey.train_journey.kelbillet.service;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.train_journey.kelbillet.KelBilletInterface;
import com.idovia.api.lazy_travel_api.external_api.journey.train_journey.kelbillet.model.KelbilletResponseModel;
import com.idovia.api.lazy_travel_api.external_api.journey.train_journey.kelbillet.model.TicketKelbilletModel;

public class KelbilletService implements KelBilletInterface {

    // https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller=1666908000&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D26687%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis+Austerlitz%26departure_code%3DFRPAR%26departure_lat%3D48.8425%26departure_lon%3D2.3656%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon+Jean+Mace%26arrival_code%3DFRLYS%26arrival_lat%3D45.74514%26arrival_lon%3D4.84185%26outbound_date%3D2022-10-28%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis
    // https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=26687&ville_arr_id=27978&timestamp_aller=1666908000&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D26687%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis+Austerlitz%26departure_code%3DFRPAR%26departure_lat%3D48.8425%26departure_lon%3D2.3656%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27978%26arrival_type_place_id%3D1%26arrival_name%3DLille%26arrival_stop_name%3DLille+Flandres%26arrival_code%3DFRLIL%26arrival_lat%3D50.63608%26arrival_lon%3D3.07142%26outbound_date%3D2022-10-28%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis
    // https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller=1666994400&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D26687%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis+Austerlitz%26departure_code%3DFRPAR%26departure_lat%3D48.8425%26departure_lon%3D2.3656%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon+Jean+Mace%26arrival_code%3DFRLYS%26arrival_lat%3D45.74514%26arrival_lon%3D4.84185%26outbound_date%3D2022-10-29%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis
    // https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=27612&ville_arr_id=27788&timestamp_aller=1666908000&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D27612%26departure_type_place_id%3D1%26departure_name%3DMarseille%26departure_stop_name%3DMarseille+Saint-Charles%26departure_code%3DFRMRS%26departure_lat%3D43.3028%26departure_lon%3D5.3816%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon+Jean+Mace%26arrival_code%3DFRLYS%26arrival_lat%3D45.74514%26arrival_lon%3D4.84185%26outbound_date%3D2022-10-28%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis
    // partenaire_id = 21 (sncf) 56 (kombo)
    // uniquement le 26arrival_code%3DFRLYS et 26departure_code%3DFRPAR serve

    // Return all nearby city form given city

    public List<TicketKelbilletModel> findAllTicketKelbillet (CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws ParseException {

        
        //String url = this.getCustomUrl("3DFRLYS", "1666908000", "3DFRPAR"); // pour un trajet lille paris
        String url = this.getCustomUrl(cityDeparture.getCodeKelbillet(), date, hour, cityArrival.getCodeKelbillet()); // pour un trajet lille paris

        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList((mapper.readValue(new URL(url), KelbilletResponseModel.class)).getResponse());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TicketKelbilletModel> findAllTicketKelbilletBestMatch(CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws ParseException {
        List <TicketKelbilletModel> tickets = findAllTicketKelbillet(cityDeparture, cityArrival, date, hour, maxTimeTravel);

        List <TicketKelbilletModel> ticketsreduce = tickets.stream().filter(t -> {
            try {
                return (isUnderMaxTimeTravel(t, maxTimeTravel) && isNotTooLate(t, date, hour));
            } catch (ParseException e) {
                e.printStackTrace();
                return false;
            }
        }).sorted( (t1, t2) -> {
            return Integer.compare(Integer.parseInt(t1.getPrice()), Integer.parseInt(t2.getPrice()));
        })
        .collect(Collectors.toList());

        return ticketsreduce;
    }



    // private methode

    private boolean isUnderMaxTimeTravel(TicketKelbilletModel t, int maxTimeTravel) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  

        return (format.parse(t.getArrival_date()).getTime() - format.parse(t.getDeparture_date()).getTime())<=(maxTimeTravel*60000);
    }

    private boolean isNotTooLate(TicketKelbilletModel t, String date, String hour) throws ParseException {
        SimpleDateFormat formatKelbillet=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        return (formatKelbillet.parse(t.getDeparture_date()).getTime() <= format.parse(date+" "+hour).getTime()+10800000 && formatKelbillet.parse(t.getDeparture_date()).getTime() >= format.parse(date+" "+hour).getTime());
    }

    private String getCustomUrl (String codeCityDeparture, String date, String hour, String codeCityArrival) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        Date dateFormatted = format.parse(date+" "+hour);  

        return ("https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller="+dateFormatted.getTime()+"&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D26687%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis+Austerlitz%26departure_code%"+codeCityDeparture+"%26departure_lat%3D48.8425%26departure_lon%3D2.3656%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon+Jean+Mace%26arrival_code%"+codeCityArrival+"%26arrival_lat%3D45.74514%26arrival_lon%3D4.84185%26outbound_date%3D"+date+"%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis");

    } 

}