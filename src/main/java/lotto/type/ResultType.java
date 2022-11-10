package lotto.type;

public enum ResultType {
    MATCH_THREE("3"),
    MATCH_FOUR("4"),
    MATCH_FIVE("5"),
    MATCH_SIX("6"),
    MATCH_BONUS("보너스 볼 일치");
    private final String result;

    ResultType (String result){
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
