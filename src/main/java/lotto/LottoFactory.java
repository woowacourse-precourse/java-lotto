package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoFactory {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int LOTTO_COUNT = 6;

    public static List<Integer> createLottoRandomNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_COUNT));
    }

    public static List<Lotto> createLottoByMoney(UserAmount userAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < userAmount.calculateLottoCount(); i++) {
            lottoNumbers.add(new Lotto(createLottoRandomNumbers()));
        }
        return lottoNumbers;
    }

}
