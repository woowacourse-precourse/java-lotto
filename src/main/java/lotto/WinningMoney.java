package lotto;

import java.text.DecimalFormat;

public class WinningMoney {

    private final int winningMoney;

    public WinningMoney(int winningMoney) {
        this.winningMoney = winningMoney;
    }

    @Override
    public String toString() {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        return decFormat.format(this.winningMoney) + "원";
    }
}
