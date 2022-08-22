package com.techserve.ImperialMetricConverter.util;


import com.techserve.ImperialMetricConverter.exception.IncompactibleUnitException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class ImperialMetricConverter {
    HashMap<String, Unit> unitHashMap=new HashMap<>();
    HashMap<String, Unit> conversionUnitMap=new HashMap<>();
    {
        unitHashMap.put("gallon", Unit.GALLON);
        unitHashMap.put("litre", Unit.LITRE);
        unitHashMap.put("inch", Unit.INCH);
        unitHashMap.put("km", Unit.KILOMETRE);
        unitHashMap.put("celcius", Unit.CELSIUS);
        unitHashMap.put("Fahrenheit", Unit.FAHRENHEIT);
        unitHashMap.put("ounce", Unit.OUNCE);
        unitHashMap.put("ml", Unit.MILLILITRE);
        unitHashMap.put("kg", Unit.KILOGRAM);
        unitHashMap.put("pint", Unit.PINT);
        unitHashMap.put("tonne", Unit.TONNE);
        unitHashMap.put("pound", Unit.POUND);

        conversionUnitMap.put("litre", Unit.GALLON);
        conversionUnitMap.put("gallon", Unit.LITRE);
        conversionUnitMap.put("km", Unit.INCH);
        conversionUnitMap.put("inch", Unit.KILOMETRE);
        conversionUnitMap.put("Fahrenheit", Unit.CELSIUS);
        conversionUnitMap.put("celcius", Unit.FAHRENHEIT);
        conversionUnitMap.put("kg", Unit.OUNCE);
        conversionUnitMap.put("pint", Unit.MILLILITRE);
        conversionUnitMap.put("ounce", Unit.KILOGRAM);
        conversionUnitMap.put("ml", Unit.PINT);
        conversionUnitMap.put("pound", Unit.TONNE);
        conversionUnitMap.put("tonne", Unit.POUND);
    }

    public Unit getUnit(String unit_key){
        if(!unitHashMap.containsKey(unit_key)){
            return null;
        }
        return unitHashMap.get(unit_key);
    }

    public Unit getReturnUnit(String unit_key){
        if(!conversionUnitMap.containsKey(unit_key)){
            return null;
        }
        return conversionUnitMap.get(unit_key);
    }
    public double convert(double amount, Unit from, Unit to) throws IncompactibleUnitException {

        if(!from.getType().equals(to.getType())){
            throw new IncompactibleUnitException();
        }

        double based;
        if(from.isBase()){
            based = amount;
        }
        else {
            based = from.getTo().convert(amount);
        }

        double result;
        if(to.isBase()){
            result = based;
        }
        else {
            result = to.getFrom().convert(based);
        }

        return result;

    }











}