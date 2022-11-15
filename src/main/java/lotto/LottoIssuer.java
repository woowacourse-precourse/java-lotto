package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    private final int LOTTO_SIZE = 6;
    private final int amount;
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoIssuer(Price price) {
        this.amount = calculateAmount(price.get());
        createLotteries();
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> get() {
        return lottoList;
    }

    private int calculateAmount(int price) {
        return price / 1000;
    }

    private void createLotteries() {
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = createRandomNumbers();
            lottoList.add(new Lotto(numbers));
        }
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//        List<Integer> numbers = new ArrayList<>();
//        while (numbers.size() < LOTTO_SIZE) {
//            int randomNumber = Randoms.pickNumberInRange(1, 45);
//            if (!numbers.contains(randomNumber)) {
//                numbers.add(randomNumber);
//            }
//        }
        return numbers;
    }
}
