package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public final List<List<Integer>> collectionOfLottoNumbers;
    public final int quantity;
    public int purchaseAmount;

    public NumberGenerator(String money) {
        this.purchaseAmount = validate(money);
        this.quantity = purchaseAmount / 1000;
        this.collectionOfLottoNumbers = generate(quantity);
        printGeneratedNumbers();
    }

    private int validate(String money) {
        validateInteger(money);
        validateUnit(Integer.valueOf(money));
        return Integer.valueOf(money);
    }

    private void validateInteger(String money) {
        if (!money.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private  void validateUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
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
        // Collections.sort(numbers);
        return numbers;
    }

    private void printGeneratedNumbers() {
        System.out.println(quantity+"개를 구매했습니다.");
        for (List<Integer> collectionOfLottoNumber : collectionOfLottoNumbers) {
            System.out.println(collectionOfLottoNumber);
        }
    }
}
