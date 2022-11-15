package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryTickets {

    public List<Lotto> lottoTickets;

    public LotteryTickets(int totalPurchaseNum) {
        this.lottoTickets = createLotteryTickets(totalPurchaseNum);
    }

    public List<Lotto> createLotteryTickets(int totalPurchaseNum) {
        List<Lotto> newLottoTickets = new ArrayList<>();
        for (int i = 0; i < totalPurchaseNum; i++) {
            newLottoTickets.add(makeNewLotto());
        }
        return newLottoTickets;
    }

    private Lotto makeNewLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNum = numbers.stream().sorted().collect(Collectors.toList());
        return new Lotto(sortedNum);
    }

    public int getLottoCount() {
        return lottoTickets.size();
    }

    public List<Lotto> getLottoTickets() {

        return lottoTickets;
    }

    public void setLottoTickets(List<Lotto> lottos) {
        this.lottoTickets = new ArrayList<>(lottos);
    }

}
