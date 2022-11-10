package lotto.domain.vo;

public class Result {

    private int result = 0;
    private boolean bonus = false;

    public Result() {
    }

    public void resultPlus() {
        result += 1;
    }

    public void bonusTurnTrue() {
        bonus = true;
    }
}
