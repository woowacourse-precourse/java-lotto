package lotto.Domain.MainValue;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Input.LottoValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PublishLotto {
    private final List<Set<Integer>> publishedLotto;

    public PublishLotto(int publishLottosNum) {
        this.publishedLotto = createLotto(publishLottosNum);
    }

    public List<Set<Integer>> getPublishedLotto() {
        return publishedLotto;
    }

    public List<Set<Integer>> createLotto(int publishLottosNum) {
        List<Set<Integer>> lottos = new ArrayList<>();

        for(int count=0; count<publishLottosNum; count++) {
            Set<Integer> oneLotto = new TreeSet<>();
            oneLotto.add(Randoms.pickNumberInRange(LottoValue.MIN.getNum(), LottoValue.MAX.getNum()));
            lottos.add(oneLotto);
        }

        return lottos;
    }

}


