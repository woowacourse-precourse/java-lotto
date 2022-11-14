package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.UserLotto;

public class GenerateLottoNumbers {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int MIN_NUMBER_OF_LOTTO = 1;
    private static final int MAX_NUMBER_OF_LOTTO = 45;
    private static final int SIZE_OF_PICKING_LOTTO = 6;

    public static List<UserLotto> generateLottoNumbers(int buyingPrice) {
        List<UserLotto> lottos = buyingLottos(getBuyingQuantity(buyingPrice));
        return lottos;
    }

    public static int getBuyingQuantity(int buyingPrice) {
        return buyingPrice / PRICE_OF_LOTTO;
    }

    public static List<UserLotto> buyingLottos(int quantity) {
        List<UserLotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER_OF_LOTTO, MAX_NUMBER_OF_LOTTO, SIZE_OF_PICKING_LOTTO);
            lottos.add(new UserLotto(sortedList(lottoNumbers)));
        }
        return lottos;
    }

    public static List<Integer> sortedList(List<Integer> unsortedList) {
        List<Integer> sortedList = new ArrayList<>(unsortedList);
        Collections.sort(sortedList);
        return sortedList;
    }
}
