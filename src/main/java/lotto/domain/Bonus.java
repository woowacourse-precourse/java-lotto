package lotto.domain;

public class Bonus {

    private final Integer bonus;

    public Bonus(FirstPlace firstPlace, String bonus) {
        firstPlace.duplicateCheckBonusNumber(bonus);
        this.bonus = Integer.parseInt(bonus);
    }
}
