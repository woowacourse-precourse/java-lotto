package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoOfUser {
    private final List<Lotto> lottos;

    public LottoOfUser() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public PrizeOfUser matchWithAnswer(LottoOfAnswer answerLotto) {
        PrizeOfUser userPrize = new PrizeOfUser();
        for (Lotto lotto : lottos) {
            Prize eachLottoPrize = lotto.findPrize(answerLotto);
            userPrize.addPrize(eachLottoPrize);
        }
        return userPrize;
    }

    public void printAllLotto() {
        for (Lotto lotto : lottos) {
            lotto.print();
        }
    }
}
