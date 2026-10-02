package channel;

public class SmsChannel implements Channel {
    @Override
    public String deliver(String title, String body) {
        return "SMS: [" + title + "] " + body;
    }
}