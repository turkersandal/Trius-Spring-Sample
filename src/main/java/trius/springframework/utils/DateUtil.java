package trius.springframework.utils;

import org.thymeleaf.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

   public static String TR_SIMPLE_PATTERN = "dd.MM.YYYY";

   public static Date currentDate(){ return Calendar.getInstance().getTime(); }

   public static String dateToString(Date date,String pattern){
       if(StringUtils.isEmpty(pattern))
           pattern = TR_SIMPLE_PATTERN;
       SimpleDateFormat df = new SimpleDateFormat(pattern);

       return df.format(date);
   }

   public static Date stringToDate(String date,String pattern){

       if(StringUtils.isEmpty(pattern))
           pattern = TR_SIMPLE_PATTERN;
       SimpleDateFormat df = new SimpleDateFormat(pattern);

       try {
           return df.parse(date);
       } catch (ParseException e) {
           e.printStackTrace();
           return currentDate();
       }

   }


}
