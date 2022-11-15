package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberCreator {
    public static List<Integer> createLotto() {
        List<Integer> number = Randoms.pickUniqueNumbersInRange(
                Constants.MIN,
                Constants.MAX,
                Constants.MAX_COUNT);
        return new ArrayList<>(number);
    }

    public static List<List<Integer>> createLottoList(int count){
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottoNumbers.add(createLotto());
        }
        return lottoNumbers;
    }
}
