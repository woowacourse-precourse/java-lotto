package lotto.data.entity;

public class Account {

    private final Long userId;

    public Account(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
