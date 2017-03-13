package am.gch.usd.common.data.model.lcp;


public enum  UserStatus {

    PENDING     (1, "Pending",  "label.user.status.pending"),
    ACTIVE      (2, "Active",   "label.user.status.active"),
    DISABLED    (3, "Disabled", "label.user.status.disabled");

    UserStatus(int value, String title, String msgKey) {
        this.value = value;
        this.title = title;
        this.msgKey = msgKey;
    }

    public static UserStatus valueOf(int value) {
        for (UserStatus e : UserStatus.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String getMsgKey() {
        return msgKey;
    }

    private final int value;

    private final String title;

    private final String msgKey;
}
