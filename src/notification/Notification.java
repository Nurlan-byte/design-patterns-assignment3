package notification;

import channel.Channel;
import java.util.ArrayList;
import java.util.List;

public abstract class Notification {
    private final String id;
    private final String message;
    private Channel channel;

    protected Notification(String id, String message, Channel channel) {
        validate(id, message, channel);
        this.id = id;
        this.message = message;
        this.channel = channel;
    }

    public String execute() {
        return channel.deliver(title(), body());
    }

    public void setImplementation(Channel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("channel must not be null");
        }
        this.channel = channel;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    protected abstract String title();

    protected abstract String body();

    private static void validate(String id, String message, Channel channel) {
        List<String> errors = new ArrayList<>();
        if (id == null || id.isBlank()) {
            errors.add("id must not be blank");
        }
        if (message == null || message.isBlank()) {
            errors.add("message must not be blank");
        }
        if (channel == null) {
            errors.add("channel must not be null");
        }
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Invalid notification: " + String.join("; ", errors));
        }
    }
}