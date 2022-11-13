package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_OUT_OF_RANGE_ERROR = "로또 번호는 6개를 넘을 수 없습니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LOTTO_OUT_OF_RANGE_ERROR);
        }
    }

    public void lottoStart() {
        List<Integer> lottoNumbers = new ArrayList<>();

        generateLottoNumbers(lottoNumbers);
    }

    private List<Integer> generateLottoNumbers(List<Integer> numbers) {
        numbers = Randoms.pickUniqueNumbersInRange(1,45,6);

        return numbers;
    }
}
