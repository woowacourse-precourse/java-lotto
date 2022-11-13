package lotto.enumeration;

public enum Bonus {
    EQUAL(1, true),
    NOT_EQUAL(0, false);

    private final Integer statusNum;
    private final Boolean statusBool;

    Bonus(Integer statusNum, Boolean statusBool) {
        this.statusNum = statusNum;
        this.statusBool = statusBool;
    }    

    public Integer statusNum() {
        return statusNum;
    }

    public Boolean statusBool() {
        return statusBool;
    }
}
