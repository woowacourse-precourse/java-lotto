package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public List<List<Integer>> collectionOfLottoNumbers;

    public NumberGenerator(int money) {
        validate(money);
        int quantity = money / 1000;
        this.collectionOfLottoNumbers = generate(quantity);
    }

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private List<List<Integer>> generate(int quantity) {
        List<List<Integer>> collectionOfNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = generateEachNumbers();
            collectionOfNumbers.add(numbers);
        }
        return collectionOfNumbers;
    }

    private  List<Integer> generateEachNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6); // 정렬 안되있음
        Collections.sort(numbers);
        System.out.println(numbers);
        return numbers;
    }
}
