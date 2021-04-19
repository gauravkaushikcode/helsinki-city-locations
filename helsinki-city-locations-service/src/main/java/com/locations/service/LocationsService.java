package com.locations.service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.locations.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationsService {

    private static final Logger log = LoggerFactory.getLogger(LocationsService.class);
    private RestTemplate restTemplate;

    public LocationsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MappingJacksonValue getData() throws IOException {
        ResponseEntity<HelsinkiInfo> responseEntity = restTemplate.getForEntity(
                "http://open-api.myhelsinki.fi/v1/places/", HelsinkiInfo.class);
        HelsinkiInfo info = responseEntity.getBody();
        List<Hours[]> hoursArr = Arrays.stream(info.getData())
                .map(hours->hours.getOpeningHours().getHours())
                              .collect(Collectors.toList());

        isOpen(1, "10:00:00","18:00:00");
        return dynamicFilter(Arrays.stream(info.getData())
                              .collect(Collectors.toList()));
    }
    public MappingJacksonValue dynamicFilter(List<Object> locationList) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "location", "openingHours");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DataFilter", filter);
        // Dynamic Filtering
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(locationList);
        // define the above filter on Data class
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
    public boolean isOpen(long weekday, String opens, String closes){
        ZoneId zone = ZoneId.systemDefault();
        // today
        LocalDate today = LocalDate.now(zone);
        String timeNow = getCurrentTime();

        // restaurant opens today 10:00, closes 18:00
        if(opens!=null && closes!=null)
        return  isTimeInInterval(timeNow, opens, closes);

        return false;
    }
    public static String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        String currentTime = sdfTime.format(cal.getTime());
        return currentTime;
    }
    public static boolean isTimeInInterval(String target, String start, String end) {
        return ((target.compareTo(start) >= 0)
                && (target.compareTo(end) <= 0));
    }
}
