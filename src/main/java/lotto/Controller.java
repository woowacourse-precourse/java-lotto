package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller {
    private final int MONEY_UNIT = 1000;

    public Set<Lotto> createLottos(int money) {
        int count = money/MONEY_UNIT;
        Set<Lotto> lottoSet = new HashSet<>();

        while(lottoSet.size() == count) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoSet.add(lotto);
        }

        return lottoSet;
    }

    // 로또 클래스에 넣기 :
    public int calculateMatchLotto(List<Integer> winningLotto, List<Integer> myLotto, int bonusNumber) {
        int matchCount = 0;
        for(Integer lottoNumber :myLotto){
            if(winningLotto.contains(myLotto)){
                matchCount++;
            }
        }
        return matchCount;

    }

}
