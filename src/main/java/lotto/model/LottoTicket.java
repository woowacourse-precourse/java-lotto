package lotto.model;

import static lotto.constValue.Constants.LottoInfo.THOUSAND_UNIT_LENGTH;

public class LottoTicket {
    public int countLotto(String moneyInput) {
        String lottoTicket = moneyInput.substring(0, moneyInput.length() - THOUSAND_UNIT_LENGTH);
        return Integer.parseInt(lottoTicket);
    }
}
