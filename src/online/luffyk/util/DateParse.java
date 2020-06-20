package online.luffyk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParse {
    public static void main(String[] args) {
        String date = "2020-06-20";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = simpleDateFormat.parse(date);
            long time = date1.getTime();
            System.out.println("time:"+time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
