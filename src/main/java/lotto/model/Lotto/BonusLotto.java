package lotto.model.Lotto;

import java.util.List;

public class BonusLotto {

    private final Integer number;

    public BonusLotto (Integer number) {
        this.number = number;
    }

    public Boolean isBonusLotto(List<Integer> userTicket) {
        return userTicket.contains(number);
    }
}