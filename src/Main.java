import channel.Channel;
import channel.EmailChannel;
import channel.SmsChannel;
import notification.Notification;
import notification.Reminder;
import notification.UrgentAlert;

public class Main {
    private static final String REMINDER_ID = "N-1";
    private static final String REMINDER_TEXT = "Submit Assignment 3";
    private static final String ALERT_ID = "N-2";
    private static final String ALERT_TEXT = "Server is down";

    private static final String EXPECTED_REMINDER_EMAIL = "EMAIL [Subject: Reminder; Body: Submit Assignment 3]";
    private static final String EXPECTED_REMINDER_SMS = "SMS: [Reminder] Submit Assignment 3";
    private static final String EXPECTED_ALERT_EMAIL = "EMAIL [Subject: URGENT; Body: Server is down]";
    private static final String EXPECTED_ALERT_SMS = "SMS: [URGENT] Server is down";

    private static int passedChecks = 0;
    private static int totalChecks = 0;

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    private static void runDemo() {
        Channel email = new EmailChannel();
        Channel sms = new SmsChannel();

        checkCombination("T1", new Reminder(REMINDER_ID, REMINDER_TEXT, email), email, EXPECTED_REMINDER_EMAIL);
        checkCombination("T2", new Reminder(REMINDER_ID, REMINDER_TEXT, sms), sms, EXPECTED_REMINDER_SMS);
        checkCombination("T3", new UrgentAlert(ALERT_ID, ALERT_TEXT, email), email, EXPECTED_ALERT_EMAIL);
        checkCombination("T4", new UrgentAlert(ALERT_ID, ALERT_TEXT, sms), sms, EXPECTED_ALERT_SMS);

        printSummary();
    }

    private static void checkCombination(String checkId, Notification notification, Channel channel, String expected) {
        String classes = className(notification) + " + " + className(channel);
        String actual = notification.execute();
        boolean success = actual.equals(expected);
        recordResult(checkId, success, classes + " | result=" + actual, expected);
    }

    private static void recordResult(String checkId, boolean success, String details, String expected) {
        totalChecks++;
        if (success) {
            passedChecks++;
        }
        System.out.println(checkId + " " + (success ? "PASS" : "FAIL") + " | " + details);
        if (!success) {
            System.out.println("    expected=" + expected);
        }
    }

    private static String className(Object object) {
        return object.getClass().getSimpleName();
    }

    private static void printSummary() {
        System.out.println("SUMMARY: " + passedChecks + "/" + totalChecks + " PASS");
    }
}