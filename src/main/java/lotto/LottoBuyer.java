package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LottoBuyer {

    private final int cost;
    private final List<Lotto> lotteries = new ArrayList<>();

    public LottoBuyer(int cost) {
        costValidate(cost);
        this.cost = cost;

        int totalLottoCount = this.cost / 1000;

        for (int cnt = 0; cnt < totalLottoCount; cnt++) {
            lotteries.add(buyLotto());
        }
    }


    public void costValidate(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력 가능합니다.");
        }
    }

    public Lotto buyLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());

        return new Lotto(numbers);
    }

    public int getCost() {
        return cost;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }
}
