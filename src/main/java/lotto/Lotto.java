package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private static final String SIZE_CHECK_ERROR = "[ERROR] 입력한 번호가 6자리가 아닙니다.";
    private static final String DUPLICATE_CHECK_ERROR = "[ERROR] 입력한 번호 중 중복하는 번호가 있습니다.";
    private static final String LIMIT_CHECK_ERROR = "[ERROR] 입력한 번호 중 1~45 범위를 벗어나는 번호가 있습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIZE_CHECK_ERROR);
        }
        if (duplicateCheck(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_CHECK_ERROR);
        }
        if (limitCheck(numbers)) {
            throw new IllegalArgumentException(LIMIT_CHECK_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    private boolean duplicateCheck(List<Integer> numbers) {
        List<Integer> tempNumbers = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            if(tempNumbers.contains(numbers.get(i))) {
                return true;
            }
            tempNumbers.add(numbers.get(i));
        }
        return false;
    }
    private boolean limitCheck(List<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > LOTTO_END || numbers.get(i) < LOTTO_START) {
                return true;
            }
        }
        return false;
    }

    private void buyLotto(int price) {
        if(price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1,000원 단위가 아닙니다.");
        }
        for (int i = 0; i < price/1000; i++) {
            Randoms.pickUniqueNumbersInRange(1, 45, 6);
        }

    }



}
