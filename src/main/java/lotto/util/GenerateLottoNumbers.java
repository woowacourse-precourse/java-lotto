package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.UserLotto;

public class GenerateLottoNumbers {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    public static List<UserLotto> generateLottoNumbers(int amount) {
        return purchaseLotto(getPurchaseQuantity(amount));
    }

    public static List<UserLotto> purchaseLotto(int quantity) {
        List<UserLotto> userLotto = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_SIZE);
            userLotto.add(new UserLotto(sortedList(lottoNumbers)));
        }
        return userLotto;
    }

    public static List<Integer> sortedList(List<Integer> unsortedList) {
        List<Integer> sortedList = new ArrayList<>(unsortedList);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static int getPurchaseQuantity(int amount) {
        return amount / PRICE_OF_LOTTO;
    }
}