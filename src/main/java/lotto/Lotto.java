package lotto;

import java.util.List;

import static constant.LottoNumber.REQUIRE_LOTTO_NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() !=REQUIRE_LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] : 로또 번호의 개수가 잘못됐습니다.");
        }
        InputUtility.testNoDuplicate(numbers);
    }
    public List<Integer> getLottoNumber(){
        return numbers;
    }

}
