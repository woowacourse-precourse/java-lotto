package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoPublisher {
    private static final int LOTTERY_NUM_CNT = 6;
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private final int LOTTERY_PRICE;

    public LottoPublisher(int lotteryPrice) {
        this.LOTTERY_PRICE = lotteryPrice;
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
        List<Integer> nums = new ArrayList<>();
        while (nums.size() != LOTTERY_NUM_CNT) {
            int num = Randoms.pickNumberInRange(START_NUM, END_NUM);

            if (nums.contains(num)) {
                continue;
            }

            nums.add(num);
        }

        nums.sort(Comparator.naturalOrder());

        return nums;
    }
}
