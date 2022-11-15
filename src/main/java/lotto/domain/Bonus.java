package lotto.domain;


import java.util.List;

public class Bonus {
    private static final int BONUS_NUMBER_SIZE = 1;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private List<Integer> bonusNumber;

    public Bonus(List<Integer> bonusNumber, Lotto winningLotto) {
        this.bonusNumber = bonusNumber;
    }

}
