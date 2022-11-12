package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.Collections;

public class LottoMachine {
    public static void pickLottoNumbers(int countLotto){
        for(int i = 0; i < countLotto; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }
}
