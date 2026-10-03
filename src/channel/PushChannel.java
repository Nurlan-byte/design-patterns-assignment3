package channel;

public class PushChannel implements Channel {
    @Override
    public String deliver(String title, String body) {
        return "PUSH {title=" + title + ", text=" + body + "}";
    }
}