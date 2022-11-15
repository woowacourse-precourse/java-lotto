package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.Type;
import lotto.util.InputUtility;
import lotto.util.ValidationUtility;

public class LottoBroadcast {

    private Lotto winning;
    private int bonus;

    private LottoBroadcast() {

    }

    public Lotto getWinning() {
        return winning;
    }

    public int getBonus() {
        return bonus;
    }
}
