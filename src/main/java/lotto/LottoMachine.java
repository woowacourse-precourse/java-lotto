package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    public static List<Lotto> makeLotto(int numberOfLotto){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<numberOfLotto;i++){
            List<Integer> pickNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(pickNumber);
            lottos.add(lotto);
        }
        return lottos;
    }
}
