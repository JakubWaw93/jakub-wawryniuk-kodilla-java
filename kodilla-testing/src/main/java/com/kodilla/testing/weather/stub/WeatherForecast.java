package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast(){
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature:
            temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public Double calculateAverageTemp(){
        Map<String, Double> resultMap = new HashMap<>();
        double temp = 0;

        for (Map.Entry<String, Double> temperature:
            temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue());
            temp += temperature.getValue();
        }
        double average = temp/resultMap.size();
        return average;
    }

    public double calculateMedian(){
        List<Double> tempForMedian = new ArrayList<>();
        for (Map.Entry<String, Double> temperature:
            temperatures.getTemperatures().entrySet()) {
            tempForMedian.add(temperature.getValue());
        }
        Collections.sort(tempForMedian);
        if (tempForMedian.size()%2==0) {
            double medianTemp1 = tempForMedian.get(tempForMedian.size()/2-1);
            double medianTemp2 = tempForMedian.get(tempForMedian.size()/2);
            double median = (medianTemp1+medianTemp2)/2;
            return median;
        } else {
            double median = tempForMedian.get(tempForMedian.size()/2);
            return median;
        }



    }
}
