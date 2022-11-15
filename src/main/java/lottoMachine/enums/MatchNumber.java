package lottoMachine.enums;

public enum MatchNumber {
    THREE_NUMBERS_MATCH(3),
    FOUR_NUMBERS_MATCH(4),
    FIVE_NUMBERS_MATCH(5),
    SIX_NUMBERS_MATCH(6);

    private final int matchNumber;

    MatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public int getMatchNumber() {
        return matchNumber;
    }
}
