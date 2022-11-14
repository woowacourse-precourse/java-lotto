package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
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
        validateUnit(money);
        validateStartNumber(money);
        return Integer.parseInt(money);
    }

    private void validateInteger(String money) {
        if (!money.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private  void validateUnit(String money) {
        if (!money.matches("^.*.000$")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private  void validateStartNumber(String money) {
        if (money.matches("^0.*")) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 0으로 시작할 수 없습니다.");
        }
    }

    private List<List<Integer>> generate(int quantity) {
        List<List<Integer>> collectionOfNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            collectionOfNumbers.add(numbers);
        }
        return collectionOfNumbers;
    }

    private void printGeneratedNumbers() {
        System.out.println(quantity+"개를 구매했습니다.");
        for (List<Integer> collectionOfLottoNumber : collectionOfLottoNumbers) {
            sortNumbers(collectionOfLottoNumber);
        }
    }

    private  void sortNumbers(List<Integer> numbers) {
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        System.out.print("[");
        for(int i = 0; i < sortedNumbers.size()-1; i++){
            System.out.print(sortedNumbers.get(i)+", ");
        }
        System.out.println(sortedNumbers.get(sortedNumbers.size()-1)+"]");
    }
}
