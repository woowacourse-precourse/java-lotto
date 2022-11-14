package lotto.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.Prize;
import lotto.utils.Generator;

public class LottoOfUser {
    private final List<Lotto> lottos;

    public LottoOfUser() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public Map<Prize, Integer> matchWithAnswer(LottoOfAnswer answerLotto) {
        Map<Prize, Integer> userPrize = Generator.makeNewPrizeMap();
        for (Lotto lotto : lottos) {
            Prize eachLottoPrize = lotto.findPrize(answerLotto);
            addPrizeToUserPrize(userPrize, eachLottoPrize);
        }
        return userPrize;
    }

    private Map<Prize, Integer> addPrizeToUserPrize(Map<Prize, Integer> userPrize, Prize eachLottoPrize) {
        Integer beforeCount = userPrize.get(eachLottoPrize);
        userPrize.put(eachLottoPrize, beforeCount + 1);
        return userPrize;
    }
}
