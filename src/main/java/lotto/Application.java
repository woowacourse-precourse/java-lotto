package lotto;

import lotto.input.LottoTickets;

public class Application {
    public static void main(String[] args) {
        LottoTickets lottoTickets = new LottoTickets();
        int paid = lottoTickets.getPaid();
        System.out.println(paid);
    }
}
