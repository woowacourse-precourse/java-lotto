package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoGenerator {

    public List<Lotto> createLottos(int money) {
        List<Lotto> lottoList = new ArrayList<>();
        int amount = getAmountOfLottos(money);

        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(createRandomNumbers());
            lottoList.add(lotto);
        }

        printLottos(lottoList);

        return lottoList;
    }

    private int getAmountOfLottos(int money) {
        return money / 1000;
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private void printLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        System.out.print("[");
        System.out.print(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            int number = numbers.get(i);
            System.out.print(", " + number);
        }
        System.out.print("]\n");
    }
}
