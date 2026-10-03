# Assignment 3 | Bridge Pattern

- Student: Yussupov Nurlan
- Group: SE-2526
- Topic: B (Notifications)
- Repository: https://github.com/Nurlan-byte/design-patterns-assignment3
- Base commit: `448d520b17d62bf5b8977688bc5bd7b1a1dc2226`

## Role map

| Role | Class | Path |
|---|---|---|
| Abstraction | `Notification` | `src/notification/Notification.java` |
| A1 | `Reminder` | `src/notification/Reminder.java` |
| A2 | `UrgentAlert` | `src/notification/UrgentAlert.java` |
| Implementor | `Channel` | `src/channel/Channel.java` |
| I1 | `EmailChannel` | `src/channel/EmailChannel.java` |
| I2 | `SmsChannel` | `src/channel/SmsChannel.java` |
| I3 | `PushChannel` | `src/channel/PushChannel.java` |
| Client | `Main` | `src/Main.java` |

## Method locations

- Bridge field: `private Channel channel;` in `Notification.java`, line 10
- `execute()`: `Notification.java`, line 19
- `setImplementation(Channel channel)`: `Notification.java`, line 23
- T5 check: `checkRuntimeSwitch(...)` in `Main.java`

## Run

```
javac --release 17 -encoding UTF-8 -d out "@sources.txt"
java -cp out Main --demo
```

## Expected results

```
T1 PASS | Reminder + EmailChannel | result=EMAIL [Subject: Reminder; Body: Submit Assignment 3]
T2 PASS | Reminder + SmsChannel | result=SMS: [Reminder] Submit Assignment 3
T3 PASS | UrgentAlert + EmailChannel | result=EMAIL [Subject: URGENT; Body: Server is down]
T4 PASS | UrgentAlert + SmsChannel | result=SMS: [URGENT] Server is down
T5 PASS | Reminder: EmailChannel -> SmsChannel | sameObject=true | stateUnchanged=true
    before=EMAIL [Subject: Reminder; Body: Submit Assignment 3] | after=SMS: [Reminder] Submit Assignment 3
T6 PASS | Reminder + PushChannel | result=PUSH {title=Reminder, text=Submit Assignment 3}
T7 PASS | UrgentAlert + PushChannel | result=PUSH {title=URGENT, text=Server is down}
SUMMARY: 7/7 PASS
```