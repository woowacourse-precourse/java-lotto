package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    static final Integer price = 1000;
    static final Integer count = 6;
    static final Integer startNumber = 1;
    static final Integer endNumber = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != count) {
            throw new IllegalArgumentException("[ERROR] " + count + "개가 넘는 숫자 입력");
        }

        Long nonDuplicatedElementCnt = numbers.stream().distinct().count();

        if(numbers.size() != nonDuplicatedElementCnt.intValue()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자 입력");
        }
    }

    // TODO: 추가 기능 구현
    public static Integer calQuantityByPrice(Integer money) {
        Integer quantity = money/price;

        return quantity;
    }

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, count);

        return numbers;
    }
}
