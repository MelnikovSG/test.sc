package com.test.sc.assistants.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDate {

    public String simpleDate(){
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(currentDate);
        return formattedDate;
    }
}
