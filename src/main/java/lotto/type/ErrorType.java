package lotto.type;

public enum ErrorType {
    MONEY("구입금액"),
    LOTTO("로또번호"),
    WINNING("당첨번호"),
    BONUS("보너스번호");

    private final String name;

    ErrorType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
