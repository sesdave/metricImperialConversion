package com.techserve.ImperialMetricConverter.model;

public enum UnitSystem {
        IMPERIAL("Imperial"),
        METRIC("Metric"),
        ;

        private String name;

        UnitSystem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
