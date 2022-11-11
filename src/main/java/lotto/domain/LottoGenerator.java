package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LottoGenerator {

    public static List<Integer> createRandomLottoNumber() {
        Set<Integer> answer = new LinkedHashSet<>();
        while (answer.size() < 6) {
            int num = Randoms.pickNumberInRange(1, 45);
            answer.add(num);
        }
        return new ArrayList<>(answer);
    }

}
