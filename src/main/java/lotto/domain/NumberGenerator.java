package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    public final List<List<Integer>> collectionOfLottoNumbers;
    public final int quantity;

    public NumberGenerator(int money) {
        validate(money);
        this.quantity = money / 1000;
        this.collectionOfLottoNumbers = generate(quantity);
        printGeneratedNumbers();
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

    private void printGeneratedNumbers() {
        System.out.println(quantity+"개를 구매했습니다.");
        for (List<Integer> collectionOfLottoNumber : collectionOfLottoNumbers) {
            System.out.println(collectionOfLottoNumber);
        }
    }
}
