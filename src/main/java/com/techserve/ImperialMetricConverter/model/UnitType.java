package com.techserve.ImperialMetricConverter.model;

public enum UnitType {
        TEMPERATURE("Temperature"),
        LENGTH("Length"),
        AREA("Area"),
        VOLUME("Volume"),
        MASS("Mass");

        private String name;

        UnitType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }