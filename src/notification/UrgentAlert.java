package notification;

import channel.Channel;

public class UrgentAlert extends Notification {
    public UrgentAlert(String id, String message, Channel channel) {
        super(id, message, channel);
    }

    @Override
    protected String title() {
        return "URGENT";
    }

    @Override
    protected String body() {
        return getMessage();
    }
}