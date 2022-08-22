package com.techserve.ImperialMetricConverter.util;

class MultiplierConverter implements Converter {

        private double fac;

        public MultiplierConverter(double factor){

            this.fac = factor;
            //System.out.println("factor "+ factor);
        }

        @Override
        public double convert(double amount) {
            return amount*fac;
        }

    }