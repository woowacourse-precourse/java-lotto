package lotto.gameResult;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class BuyingLotto {
    public static final String ORDER_MESSAGE = "개를 구매했습니다.";
    public static final int LOTTO_PRICE = 1000;
    public static List<List<Integer>> lottoBundle = new ArrayList<>(); 

    public static String orderNumber(String money) {
        int won = Integer.parseInt(money);

        return "\n" + won/LOTTO_PRICE + ORDER_MESSAGE;
    }

    public static List<Integer> lottoGenerator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

    public static void lottoBundleGenerator(String money) {
        int won = Integer.parseInt(money);
        int lottoCount = won/LOTTO_PRICE;

        for(int i=0; i<lottoCount; i++) {
            lottoBundle.add(BuyingLotto.lottoGenerator());
        }
    }
}
