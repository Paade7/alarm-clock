import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class AlarmClock {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        DateTimeFormatter timeFormater = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime alarmTime = null;
        String filePath = "What If So Then - Karneef.wav";

        while(alarmTime==null){
            try{
                System.out.print("Enter time for alam clock(HH:MM:SS): ");
                String Time = sc.nextLine();

                alarmTime = LocalTime.parse(Time,timeFormater);

                System.out.println("Alarm clock set for " + alarmTime);
            }
            catch(DateTimeParseException e){
                System.out.println("Invalid format. Please provide \"HH:mm:ss\"");
            }
        }

        MyRunnable alamClock = new MyRunnable(alarmTime,filePath,sc);
        Thread alarmThread = new Thread(alamClock);
        alarmThread.start();


    }
}






