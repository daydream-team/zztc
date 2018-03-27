package com.daydream.console;

import java.util.Date;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

/**
 * Created by jobancai on 2017/8/25.
 */
public class TestJodaTime {

  @Test
  public void testDayOfWeek(){
    DateTime dateTime = new DateTime(1504398660000L);
    System.out.println(Integer.parseInt(dateTime.hourOfDay().getAsText()));
  }

  @Test
  public void testInteger(){
    Integer a = 3;
    Integer b = 3;
    System.out.println(a.equals(b));
  }

  @Test
  public void testChange(){
    Date now = new Date();
    DateTime dateTime = new DateTime(1505990126666L);
    String createTime = dateTime.toString("dd-MM-yyyy HH:mm:ss");
    System.out.println(createTime);
    System.out.println(dateTime.getMillis());
  }

  @Test
  public void testJson(){
    DateTime dateTime = DateTime.parse("à¥¨à¥¦à¥§à¥\u00AD-à¥¦à¥¯-à¥¨à¥¦-à¥¦à¥", DateTimeFormat.forPattern("yyyy-MM-dd-HH:mm:ss"));
    System.out.println(dateTime.getMillis());
    System.out.println(dateTime.dayOfWeek().getAsShortText(Locale.ENGLISH));
  }

}
