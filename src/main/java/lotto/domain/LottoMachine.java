package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static LottoMachine init() {
        return new LottoMachine();
    }

    public List<Lotto> makeLottoes(int lottoCnt) {
        if(lottoCnt < 1) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력해주세요");
        }
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoes;
    }
}
