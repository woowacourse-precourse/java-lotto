package lotto.domain;

public enum CorrectState {
    THREE_CORRECT(0,3,5000),
    FOUR_CORRECT(1,4,50000),
    FIVE_CORRECT(2,5,1500000),
    FIVE_AND_BONUS_CORRECT(3,5,30000000),
    SIX_CORRECT(4,6,2000000000),

    NOTHING(0,0,0);

    private final int index;
    private final int matchNumber;
    private final int amount;

    CorrectState(int index, int matchNumber, int amount) {
        this.index = index;
        this.matchNumber = matchNumber;
        this.amount = amount;
    }

    public int getIndex() {
        return index;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getAmount() {
        return amount;
    }

    public CorrectState valueOf(int count) {
        for(CorrectState correctState : CorrectState.values()) {
            if(correctState.getMatchNumber() == count) {
                return correctState;
            }
        }

        return NOTHING;
    }
}
