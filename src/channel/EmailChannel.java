package channel;

public class EmailChannel implements Channel {
    @Override
    public String deliver(String title, String body) {
        return "EMAIL [Subject: " + title + "; Body: " + body + "]";
    }
}