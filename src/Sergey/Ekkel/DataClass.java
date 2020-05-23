package Sergey.Ekkel;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DataClass {
    public static void main(String[] args) {
        /*Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        TimeZone tZon = TimeZone.getTimeZone("Europe/Kirov");
        System.out.println(tZon.useDaylightTime());
        Locale loc = new Locale("ru","RU");
        System.out.println(tZon.getDisplayName(false,TimeZone.LONG, loc));
        System.out.println(tZon.getDisplayName(false,TimeZone.SHORT, loc));

        String[] zon = TimeZone.getAvailableIDs();
        //System.out.println(Arrays.toString(zon));
        Calendar cal = Calendar.getInstance();
        System.out.println(new Date());
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(Calendar.SUNDAY);*/
        /*LocalDateTime ldt1= LocalDateTime.now();
        LocalDateTime ldt2= ldt1.plusDays(4);
        Duration duration = Duration.between(ldt1,ldt2);
        System.out.println(duration.toHours());
        LocalDateTime ldt3= LocalDateTime.of(2019, 05, 05, 22, 24);
        System.out.println(ldt3);
        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println(zid1.getRules().getOffset(Instant.now()));*/
        //createInstant();
        //dataFormat();
        //System.out.println(parseZDT("01.01.2020 16:27:14.444 +0300 Moscow Standard Time"));
        /*ZonedDateTime start = ZonedDateTime.of(1970,05,
                27,23,00,00,00,
                ZoneId.systemDefault());
        ZonedDateTime now1 = ZonedDateTime.of(2020,05,
                01,22,9,00,00,
                ZoneId.systemDefault());
        Duration yarMy = Duration.between(start,now1);
        Period per = Period.between(start.toLocalDate(),now1.toLocalDate());
        System.out.println(yarMy.toString());
        System.out.println(per.toString());
        ZoneId zid1 = ZoneId.of("Europe/Moscow");
        System.out.println(zid1.getRules().getOffset(Instant.now()));*/
        /*LocalDateTime ldt1= LocalDateTime.now();
        LocalDateTime ldt2= ldt1.plusDays(4);
        Duration duration = Duration.between(ldt1,ldt2);
        System.out.println(duration.toHours());*/
        /*LocalDateTime ldt2= LocalDateTime.of(2019, 05, 05, 22, 24);
        System.out.println(ldt2);*/

    }


//16 модуль 2 задача
    static Instant createInstant(){
        Instant in = Instant.from(LocalDateTime.of(2020,
                01,01,15,00,
                00,01)
                .atZone(ZoneId.of("Europe/Moscow")));
        return in;
    }

//16 модуль 3 задача
    static ZonedDateTime parseZDT(String str){
        DateTimeFormatter form = DateTimeFormatter.
                ofPattern("dd.MM.yyyy HH:mm:ss.SSS xx zzzz",
                        new Locale("en","GB"));
        ZonedDateTime day = ZonedDateTime.
                parse(str, form);
        return day;
    }
    static void dataFormat(){
        LocalDateTime myBirthday = LocalDateTime.of(1970,05,27,
                23,00,00,00);
        ZonedDateTime myBirth = myBirthday.atZone(ZoneId.of("Asia/Krasnoyarsk"));
        DateTimeFormatter form = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter form2 = DateTimeFormatter.
                ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter form3 = DateTimeFormatter.
                ofPattern("GGGG,EEEE,dd MMMM yyyy  a,HH:mm:ss:nn =VV,zzzz,xxx,OOOO",
                        new Locale("ru","RU"));
        String formData2 = form3.format(myBirth);
        String formData = form2.format(myBirthday);
        String formData1 = form.format(myBirth);
        System.out.println(myBirthday);
        System.out.println(myBirth);
        System.out.println(formData);
        System.out.println(formData1);
        System.out.println(formData2);
    }

}
