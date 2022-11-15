package lotto.caculation;

import lotto.reward.Lotto;
import lotto.reward.RandomNumbers;
import lotto.reward.WinningCase;
import lotto.utils.WinningType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Purchase { //로또 구매 함수
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoTicket;

    public Purchase(Money money) {
        lottoTicket = new ArrayList<>();
        for (int i = 0; i < money.divideMoney(LOTTO_PRICE); i++) {
            lottoTicket.add(new Lotto(new RandomNumbers()));
        }
    }
    public Map<WinningType, Integer> getWinningResult(WinningCase winningLotto) {
        return lottoTicket.stream()
                .map(lotto -> lotto.matchWinningLotto(winningLotto))
                .collect(Collectors.toMap(winningType -> winningType, value -> 1, Integer::sum));
    }

    public List<Lotto> getLottoTickets(){
        return new ArrayList<>(lottoTicket);
    }

    public int getLottoCount(){
        return lottoTicket.size();
    }
}
