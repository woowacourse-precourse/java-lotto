package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final int LOTTO_SIZE = 6;
    private final int amount;
    private List<Lotto> lottoList = new ArrayList<>();

    public LottoManager(Price price) {
        this.amount = calculateAmount(price.get());
        createLotteries();
    }

    public int getAmount() {
        return amount;
    }

    public void printLotteries() {
        for (int i = 0; i < amount; i++)
            System.out.println(lottoList.get(i).getNumbers());
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
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < LOTTO_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
