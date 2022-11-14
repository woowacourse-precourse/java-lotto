package lotto.Model;

import lotto.Utils.Convert;

public class WinningTicket {

    private Lotto lotto;

    public WinningTicket(final String number) {
        lotto = new Lotto(Convert.StrToList(number));
    }
}
