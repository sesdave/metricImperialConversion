package com.techserve.ImperialMetricConverter.util;

import com.techserve.ImperialMetricConverter.model.UnitSystem;
import com.techserve.ImperialMetricConverter.model.UnitType;

public enum Unit{

        //BASE UNITS
        KELVIN(UnitType.TEMPERATURE,"K", UnitSystem.METRIC,"Kelvin"),
        KILOGRAM(UnitType.MASS,"kg",UnitSystem.METRIC,"Kilogram"),
        METRE(UnitType.LENGTH,"m",UnitSystem.METRIC, "Metre"),
        LITRE(UnitType.VOLUME,"l",UnitSystem.METRIC,"Litre"),

        FAHRENHEIT(UnitType.TEMPERATURE,"F",UnitSystem.IMPERIAL,"Fahrenheit",Unit.KELVIN, amount -> (5.0d/9.0d*(amount-32.0d)) + 273.0d,
                amount -> (9.0d/5.0d)*(amount-273.0d)+32.0d),
        CELSIUS(UnitType.TEMPERATURE, "C", UnitSystem.METRIC, "Celsius", Unit.KELVIN, amount -> amount + 273.15d, amount -> amount-273.15d),

        INCH(UnitType.LENGTH,"in",UnitSystem.IMPERIAL,"Inch", Unit.METRE, 0.0254d, 39.3701d),


        TONNE(UnitType.MASS, "t", UnitSystem.METRIC, "Tonne", Unit.KILOGRAM, 1000.0d, 0.001d),

        OUNCE(UnitType.MASS, "oz",UnitSystem.IMPERIAL, "Ounce", Unit.KILOGRAM, 0.0283495d, 35.274d),
        POUND(UnitType.MASS,"lb",UnitSystem.IMPERIAL,"Pound", Unit.KILOGRAM, 0.453592d, 2.20462d),

        PINT(UnitType.VOLUME, "pt", UnitSystem.IMPERIAL, "Pint", Unit.LITRE, 0.568261d, 1.75975d),

        GALLON(UnitType.VOLUME, "gal", UnitSystem.IMPERIAL, "Gallon", Unit.LITRE, 4.54609d, 0.219969d),

        MILLILITRE(UnitType.VOLUME, "ml", UnitSystem.METRIC, "Millilitre", Unit.LITRE, 0.001d, 1000.0d),
        KILOMETRE(UnitType.LENGTH,"km",UnitSystem.METRIC,"Kilometre", Unit.METRE, 1000.0d, 0.001d);

        private UnitType type;
        private String unit;
        private UnitSystem system;
        private String name;
        private Unit reference;
        private Converter to;
        private Converter from;
        private boolean base;


        Unit(UnitType type, String unit, UnitSystem system, String name, Unit reference, double to_ref, double from_ref){
            this.type = type;
            this.unit = unit;
            this.system = system;
            this.name = name;
            this.reference = reference;
            this.to = new MultiplierConverter(to_ref);
            this.from = new MultiplierConverter(from_ref);
            base = false;
        }


        Unit(UnitType type, String unit, UnitSystem system, String name, Unit reference, Converter convert_to, Converter convert_from){
            this.type = type;
            this.unit = unit;
            this.system = system;
            this.name = name;
            this.reference = reference;
            this.to = convert_to;
            this.from = convert_from;
            base = false;
        }


        Unit(UnitType type, String unit, UnitSystem system, String name){
            System.out.println("entered s constructed");
            System.out.println("name "+name);
            this.type = type;
            this.unit = unit;
            this.system = system;
            this.name = name;
            this.reference = null;
            this.to = null;
            this.from = null;
            base = true;
        }

        public UnitType getType(){
            return type;
        }

        /*public String getSymbol() {
            return unit;
        }

         */

        public UnitSystem getSystem() {
            return system;
        }

        public String getName() {
           // System.out.println("name "+name);
            return name;
        }

        public Unit getReference() {
            return reference;
        }

        public Converter getTo() {
            return to;
        }

        public Converter getFrom() {
            return from;
        }

        public boolean isBase() {
            return base;
        }


    }