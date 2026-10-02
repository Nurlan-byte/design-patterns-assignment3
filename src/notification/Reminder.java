package notification;

import channel.Channel;

public class Reminder extends Notification {
    public Reminder(String id, String message, Channel channel) {
        super(id, message, channel);
    }

    @Override
    protected String title() {
        return "Reminder";
    }

    @Override
    protected String body() {
        return getMessage();
    }
}