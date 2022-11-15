package lotto.Model;

import lotto.Constant.Message;
import lotto.Utils.Convert;

public class WinningTicket {

    private final Lotto lotto;
    private int bonus;

    public WinningTicket(final String number) {
        lotto = new Lotto(Convert.StrToList(number));
    }

    public void saveBonus(final String bonus) {
        int bonusNum = Convert.StrToInt(bonus);
        if (lotto.getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException(Message.ERROR_DUPLICATE.getMessage());
        }
        this.bonus = bonusNum;
    }

    public Lotto getWinningTicket() {
        return lotto;
    }

    public int getBonusNum() {
        return bonus;
    }
}
