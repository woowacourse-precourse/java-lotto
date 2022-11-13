package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Generator {

    /**
     * 1~45까지 숫자 중 중복되지 않은 6개의 정수를 뽑는 메서드
     * */
    private static List<Integer> getNums () {
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(1,45,6);
        return nums;
    }

    /**
     * 숫자 배열로 로또 생성
     * */
    public static List<Lotto> getLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<lottoCount; i++) {
            List<Integer> nums = getNums();
            Lotto lotto = new Lotto(nums);
            lottos.add(lotto);
        }
        return lottos;
    }
}
