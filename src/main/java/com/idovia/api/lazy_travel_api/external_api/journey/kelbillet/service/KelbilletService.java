package com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.service;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idovia.api.lazy_travel_api.external_api.guru.model.CityModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.KelBilletInterface;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.model.KelbilletResponseModel;
import com.idovia.api.lazy_travel_api.external_api.journey.kelbillet.model.TicketKelbilletModel;

@Service
public class KelbilletService implements KelBilletInterface {

    // Return all nearby city form given city

    public List<TicketKelbilletModel> findAllTicketKelbillet (CityModel cityDeparture, CityModel cityArrival, String date, String hour, int maxTimeTravel) throws ParseException {

        List <TicketKelbilletModel> tickets = new ArrayList<>();
        String urlSncf = this.getCustomUrlSncf(cityDeparture.getCodeSncf(), date, hour, cityArrival.getCodeSncf()); // pour un trajet lille paris
        String urlTictatrip = this.getCustomUrlTictatrip(cityDeparture.getCodeTictatrip(), date, hour, cityArrival.getCodeTictatrip()); // pour un trajet lille paris

        tickets.addAll(findAllTicketKelbillet(urlSncf));
        tickets.addAll(findAllTicketKelbillet(urlTictatrip));
        return tickets.stream().filter(t -> t.getDuration()/60<maxTimeTravel).collect(Collectors.toList());
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

    private List<TicketKelbilletModel> findAllTicketKelbillet (String url) throws ParseException {
        ObjectMapper mapper = new ObjectMapper();
            List <TicketKelbilletModel> tickets = new ArrayList <TicketKelbilletModel> ();
            TicketKelbilletModel[] response;
            try {
                response = (mapper.readValue(new URL(url), KelbilletResponseModel.class)).getResponse();
                if (response!=null) {
                    tickets = Arrays.asList(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tickets;
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

    private String getCustomUrlSncf (String codeCityDeparture, String date, String hour, String codeCityArrival) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
        Date dateFormatted = format.parse(date+" "+hour);  
        return ("https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller="+dateFormatted.getTime()+"&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D27612%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis+Austerlitz%26departure_code%"+codeCityDeparture+"%26departure_lat%3D48.8425%26departure_lon%3D2.3656%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon+Jean+Mace%26arrival_code%"+codeCityArrival+"%26arrival_lat%3D45.74514%26arrival_lon%3D4.84185%26outbound_date%3D"+date+"%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis");
        //https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller=1668952800&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D27612%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis+Austerlitz%26departure_code%3DFRMRS%26departure_lat%3D48.8425%26departure_lon%3D2.3656%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon+Jean+Mace%26arrival_code%3DFRLYS%26arrival_lat%3D45.74514%26arrival_lon%3D4.84185%26outbound_date%3D2022-11-20%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis
        //https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller=1668952800&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D26687%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis+Austerlitz%26departure_code%3DFRMRS%26departure_lat%3D48.8425%26departure_lon%3D2.3656%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon+Jean+Mace%26arrival_code%3DFRLYS%26arrival_lat%3D45.74514%26arrival_lon%3D4.84185%26outbound_date%3D2022-11-20%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis
    } 

    private String getCustomUrlTictatrip (String codeCityDeparture, String date, String hour, String codeCityArrival) throws ParseException {
        //return ("https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=160&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller=1666994400&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D160%26output_format%3Dallgpjson%26departure_place_id%3D26687%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis%26departure_code%3Dc%7CFRparis___%40u09tv%26departure_lat%3D48.8566%26departure_lon%3D2.3515%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon%26arrival_code%3Dc%7CFRlyon____%40u05kq%26arrival_lat%3D45.764043%26arrival_lon%3D4.835659%26outbound_date%3D2022-10-29%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis");
        return ("https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=160&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller=1666994400&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D160%26output_format%3Dallgpjson%26departure_place_id%3D26687%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis%26departure_code%3Dc%"+codeCityDeparture+"%26departure_lat%3D48.8566%26departure_lon%3D2.3515%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon%26arrival_code%3Dc%"+codeCityArrival+"%26arrival_lat%3D45.764043%26arrival_lon%3D4.835659%26outbound_date%3D"+date+"%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis");
        //return ("https://www.kelbillet.com/partners/compavols/proxy.php?srv=requester&origine=kelbillet&partenaire_id=21&ville_dep_id=26687&ville_arr_id=27788&timestamp_aller="+dateFormatted.getTime()+"&pbtm=1975884105&url=%3F1%3D1%26%26partner_id%3D21%26output_format%3Dallgpjson%26departure_place_id%3D26687%26departure_type_place_id%3D1%26departure_name%3DParis%26departure_stop_name%3DParis+Austerlitz%26departure_code%"+codeCityDeparture+"%26departure_lat%3D48.8425%26departure_lon%3D2.3656%26departure_timezone%3DEurope%2FParis%26arrival_place_id%3D27788%26arrival_type_place_id%3D1%26arrival_name%3DLyon%26arrival_stop_name%3DLyon+Jean+Mace%26arrival_code%"+codeCityArrival+"%26arrival_lat%3D45.74514%26arrival_lon%3D4.84185%26outbound_date%3D"+date+"%26inbound_date%3D%26arrival_timezone%3DEurope%2FParis");

    } 

}
