import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
    Timer timer;

    public StopWatch(int seconds) {
        timer = new Timer();
        timer.schedule(new StopTask(), seconds * 1000L);
    }

    public static void start() throws InterruptedException {
        System.out.println("Input time in minutes");
        Scanner scanner = new Scanner(System.in);
        String min = scanner.nextLine();

        if (min.equals(Main.COMMAND_LIST()[0])) {
            Main.commandLine();
        }
        if(getInt(min) < 0) {
            System.out.println(Main.DIALOG_LIST()[2]);
            start();
        }

        int minute = Integer.parseInt(min) * 60;

        System.out.println("Input time in seconds");
        String sec = scanner.nextLine();
        if (sec.equals(Main.COMMAND_LIST()[0])) {
            Main.commandLine();
        }
        if(getInt(sec) < 0) {
            System.out.println(Main.DIALOG_LIST()[2]);
            start();
        }

        int seconds = Integer.parseInt(sec);

        new StopWatch(minute + seconds);
        System.out.println("Started: " + timeMachine.getCurrentTime());
    }

    public static void startQ() throws InterruptedException {
        System.out.println("Input date in a format");
        Scanner scanner = new Scanner(System.in);
        String min = scanner.nextLine();

        if (min.equals(Main.COMMAND_LIST()[0])) {
            Main.commandLine();
        }
        if(getInt(min) < 0) {
            System.out.println(Main.DIALOG_LIST()[2]);
            start();
        }

        int minute = Integer.parseInt(min) * 60;

        System.out.println("Input time in a format");
        String sec = scanner.nextLine();
        if (sec.equals(Main.COMMAND_LIST()[0])) {
            Main.commandLine();
        }
        if(getInt(sec) < 0) {
            System.out.println(Main.DIALOG_LIST()[2]);
            start();
        }

        int seconds = Integer.parseInt(sec);

        new StopWatch(minute + seconds);
        System.out.println("Started: " + timeMachine.getCurrentTime());
    }

    public static int getInt(String input) {
        String find = "-1";

        if (input.length() >= 1 ) {
            boolean isNumber = true;

            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i))) {
                    isNumber = false;
                }
            }
            if (isNumber) {
                find = "";
                find = find.concat(input);
            }
        }
        return Integer.parseInt(find);
    }

    class StopTask extends TimerTask {
        public void run() {
            System.out.println("Time Up!" + timeMachine.getCurrentTime());
            timer.cancel();
        }
    }
}