package lotto.model;

public class LottoTicket {
    public int countLotto(String moneyInput) {
        String lottoTicket = moneyInput.substring(0, moneyInput.length() - 3);
        return Integer.parseInt(lottoTicket);
    }
}
