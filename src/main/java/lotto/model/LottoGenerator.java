package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoGenerator {
    // 한장의 로또를 만들어주는 메서드
    public static List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
