package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Enum.Error.LOTTO_NUM_LENGTH_ERROR;
import static lotto.Enum.ConstantNumber.*;

public class Lotto {
    private final List<Integer> numbers;

    // 자동 로또 생성
    public Lotto(){
        this.numbers = makeLottoAuto();
    }

    // 수동 로또 생성
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> makeLottoAuto() {
        List<Integer> random_numbers = pickUniqueNumbersInRange(1,45,6);

        validate(random_numbers);

        return random_numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIX.getValue()) {
            throw new IllegalArgumentException(LOTTO_NUM_LENGTH_ERROR.getMessage());
        }
    }

}
