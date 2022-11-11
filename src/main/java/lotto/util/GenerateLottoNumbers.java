package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.UserLotto;

public class GenerateLottoNumbers {
    public static List<UserLotto> generateLottoNumbers(int buyingPrice) {
        List<UserLotto> lottos = getBuyingLottos(getBuyingQuantity(buyingPrice));
        return lottos;
    }

    public static int getBuyingQuantity(int buyingPrice) {
        return buyingPrice / 1000;
    }

    public static List<UserLotto> getBuyingLottos(int quantity) {
        List<UserLotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new UserLotto(sortedList(lottoNumbers)));

        }
        return lottos;
    }

    public static List<Integer> sortedList(List<Integer> unsortedList) {
        List<Integer> sortedList = new ArrayList<>();
        for(int number : unsortedList) {
            sortedList.add(number);
        }
        Collections.sort(sortedList);
        return sortedList;
    }
}
