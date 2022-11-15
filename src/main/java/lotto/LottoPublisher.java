package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoPublisher {
    private final int LOTTERY_NUM_CNT = 6;
    private final int START_NUM = 1;
    private final int END_NUM = 45;
    private final int LOTTERY_PRICE = Application.LOTTERY_PRICE;

    private LottoPublisher() {
    }

    private static class LottoPublisherHelper {
        private static final LottoPublisher INSTANCE = new LottoPublisher();
    }

    public static LottoPublisher getInstance() {
        return LottoPublisherHelper.INSTANCE;
    }

    public List<Lotto> publish(int money) {
        int lottoCnt = money / LOTTERY_PRICE;

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            Lotto lotto = new Lotto(generateNums());
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<Integer> generateNums() {
        List<Integer> immutableNums = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTERY_NUM_CNT);
        List<Integer> nums = new ArrayList<>(immutableNums);

        nums.sort(Comparator.naturalOrder());

        return nums;
    }

}
