package lotto.Dto;

public enum Reword {
    FIVE_WORD("3",5_000),
    FOUR_WORD("4",50_000),
    THREE_WORD("5",1_500_000),
    TWO_WORD("5BonusNumber",30_000_000),
    ONE_WORD("6",2_000_000_000);
    public final String word;
    public final int money;

    Reword(String word, int money) {
        this.word = word;
        this.money = money;
    }
}
