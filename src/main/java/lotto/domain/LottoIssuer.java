package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    public Lotto issueLotto() {
        return new Lotto(randomNumberGenerator());
    }

    private List<Integer> randomNumberGenerator() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
