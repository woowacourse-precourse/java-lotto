package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

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
            while(oneLotto.size() != Values.LOTTO_NUM.getValue()) {
                oneLotto.add(Randoms.pickNumberInRange(1, 45));
            }
            lottos.add(oneLotto);
        }

        return lottos;
    }

}


