import java.time.Clock;
import java.time.Instant;
import java.time.ZonedDateTime;

public class InstantDemo {

  public static void nowWithClock(){
      //Example
// create a clock
      Clock cl = Clock.systemDefaultZone();
      // create an Instant object using now(Clock)
      Instant lt = Instant.now(cl);
// print result
      System.out.println("Instant : " + lt); // Instant : 2019-12-31T12:31:30.281Z

  }

  public static  void withTemporalAdjuster(){
      /* Syntax
      default Temporal with(TemporalAdjuster adjuster)*/


// Example

      Instant local = Instant.parse("2024-07-31T10:33:50.63Z");

      System.out.println("Instant before" + " adjustment: " + local); // Instant before adjustment: 2019-12-31T10:33:50.630Z

      Instant updatedlocal = local.with(Instant.EPOCH);

      System.out.println("Instant after" + " adjustment: " + updatedlocal); // Instant after adjustment: 1970-01-01T00:00:00Z
  }

    public static void compareTo(){
        Instant instant1 = Instant.parse("2020-01-04T05:10:57.392Z");

        Instant instant2 = Instant.parse("2020-01-04T05:10:50.392Z");

        Instant instant3 = Instant.parse("2020-01-04T05:10:57.392Z");

        System.out.println(instant1.compareTo(instant2)); // 1

        System.out.println(instant1.compareTo(instant3)); // 0

        System.out.println(instant2.compareTo(instant3)); // -1
    }

    public static void fromTemporalAccessor(){

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println("ZonedDateTime: " + zonedDateTime); // ZonedDateTime: 2020-01-04T00:00:51.261+07:00[Asia/Ho_Chi_Minh]

        Instant result = Instant.from(zonedDateTime);

        System.out.println("Instant: " + result); // Instant: 2020-01-03T17:00:51.261Z
    }

    public static void main(String[] args) {
        //nowWithClock();
       // withTemporalAdjuster();
        fromTemporalAccessor();
    }
}
