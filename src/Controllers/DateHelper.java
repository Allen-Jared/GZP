
package Controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {
    public static Timestamp convertLocalDateToUtcTimestamp(String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss.S");
        LocalDateTime ldt = LocalDateTime.parse(date, dtf);
        ZoneId zid = ZoneId.systemDefault();
        ZonedDateTime zdtStart = ldt.atZone(zid);
        ZonedDateTime utcStart = zdtStart.withZoneSameInstant(ZoneId.of("UTC"));
        ldt = utcStart.toLocalDateTime();
        Timestamp startsqlts = Timestamp.valueOf(ldt);
        return startsqlts;
    }
    
    public static String convertDateToCorrectFormatString(LocalDateTime date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss.S");
        return date.format(dtf);
    }
    
    public static String convertUtcTimestampToLocalDateString(String timeStamp){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss.S");
        Timestamp stamp = Timestamp.valueOf(timeStamp);
        LocalDateTime ldt = stamp.toLocalDateTime();
        ZoneId zid = ZoneId.systemDefault();
        ZonedDateTime zdtStart = ldt.atZone(zid);
        ZonedDateTime localTime = zdtStart.withZoneSameLocal(zid);
        ldt = localTime.toLocalDateTime();
        return localTime.format(dtf);
    }
}
