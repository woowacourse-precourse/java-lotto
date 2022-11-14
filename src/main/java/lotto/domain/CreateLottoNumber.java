package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CreateLottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public static List<Integer> createRandomLotto() {
        return sortLotto(camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6));

        /*List<Integer> tempList = new ArrayList<>();
        tempList.add(1);
        tempList.add(2);
        tempList.add(3);
        tempList.add(4);
        tempList.add(5);
        tempList.add(6);
        return tempList;*/
    }

    private static List<Integer> sortLotto(List<Integer> sortYet) {
        return LottoNumber.sortListUpper(sortYet);
    }
}
