package lotto.enums;

public enum Announcement {
    INSERT_MONEY("구입금액을 입력해 주세요.");

    private final String announcement;

    Announcement(String announcement) {
        this.announcement = announcement;
    }

    public void announce() {
        System.out.println(announcement);
    }

}
