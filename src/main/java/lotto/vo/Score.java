package lotto.vo;

public enum Score {
    FIRST("1등", "6개 번호 일치", 2_000_000_000),
    SECOND("2등", "5개 번호 + 보너스 번호 일치", 30_000_000),
    THIRD("3등", "5개 번호 일치", 1_500_000),
    FORTH("4등", "4개 번호 일치", 50_000),
    FIFTH("5등", "3개 번호 일치", 5_000);

    private final String title;
    private final String description;
    private final Integer price;

    Score(String title, String description, Integer price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }
}