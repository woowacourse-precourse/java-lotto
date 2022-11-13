package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoMachine {

    private final int minNum = 1;
    private final int maxNum = 45;
    private final int numSize = 6;

    // 중복되지 않는 6개의 숫자를 뽑기
    public List<Integer> pickNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < numSize) {
            int randomNumber = Randoms.pickNumberInRange(minNum, maxNum);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;

    }

}
