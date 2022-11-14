package lotto.caculation;

import lotto.reward.Lotto;
import lotto.reward.RandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class Purchase { //로또 구매 함수
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoTicket;

    public Purchase(Money money) {
        lottoTicket = new ArrayList<>();
        for (int i = 0; i < money.divideMoney(LOTTO_PRICE); i++) {
            lottoTicket.add(new Lotto(new RandomNumbers()));
        }
    }

    private List<Lotto> getLottoTickets(){
        return new ArrayList<>(lottoTicket);
    }

    private int getLottoCount(){
        return lottoTicket.size();
    }
}
