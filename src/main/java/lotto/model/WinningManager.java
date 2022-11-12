package lotto.model;

public class WinningManager {
    private Lotto answer;
    private BonusBall bonusBall;

    public static WinningManager from(String userInputForAnswer) {
        return new WinningManager(userInputForAnswer);
    }

    private WinningManager(String userInputForAnswer) {
        this.answer = new Lotto(userInputForAnswer);
    }

    public void initBonusBall(BonusBall bonusBall) {
        this.bonusBall = bonusBall;
    }
}



