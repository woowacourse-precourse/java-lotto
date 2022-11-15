package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumCreator {
    public static List<Integer> lottoNumbers;

    public static void createUniqueNumbers(){
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
    }

    public static List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }
}
