package lotto.type;

public enum ResultType {
    MATCH_THREE("3개"),
    MATCH_FOUR("4개"),
    MATCH_FIVE("5개"),
    MATCH_SIX("6개"),
    MATCH_BONUS("보너스 볼 일치"),
    MATCH("일치"),
    DIGIT("개");
    private final String result;

    ResultType(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
