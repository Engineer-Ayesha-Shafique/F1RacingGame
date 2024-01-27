package com.Computer_Engineer_2020_CE_39;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.text.ParseException;


public class RandomDateOfBirth {


    public static void main(String[] args) throws ParseException {
        Random random = new Random();


            //long tempo = (long) (1293861598 + random.nextDouble() * 60 * 60 * 24 * 365);
            DateFormat dateFormat = new SimpleDateFormat("yyyy");
            Date dateFrom = dateFormat.parse("2022");
            long timestampFrom = dateFrom.getTime();
            Date dateTo = dateFormat.parse("2023");
            long timestampTo = dateTo.getTime();
            long timeRange = timestampTo - timestampFrom;
            long randomTimestamp = timestampFrom + (long) (random.nextDouble() * timeRange);
            SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
            String racedate = formatter.format(new Date(randomTimestamp));
        System.out.println(racedate);
        }


    }


