package lotto.constant;

public enum Status {
    EMPTY(0);

    private final int status;

    private Status (int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
