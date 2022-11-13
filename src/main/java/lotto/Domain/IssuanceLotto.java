package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class IssuanceLotto {
    private final List<Set<Integer>> issuancedLotto;

    public IssuanceLotto(int issuanceLottoNum) {
        this.issuancedLotto = createLotto(issuanceLottoNum);
    }

    public List<Set<Integer>> getIssuanceLotto() {
        return issuancedLotto;
    }

    public List<Set<Integer>> createLotto(int issuanceLottoNum) {
        List<Set<Integer>> lottos = new ArrayList<>();
        for(int count=0; count<issuanceLottoNum; count++) {
            Set<Integer> oneLotto = new TreeSet<>();
            while(oneLotto.size() != Values.LOTTO_NUM.getValue()) {
                oneLotto.add(Randoms.pickNumberInRange(1, 45));
            }
            lottos.add(oneLotto);
        }

        return lottos;
    }
}


