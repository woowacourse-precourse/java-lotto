package lotto.utils;

import static lotto.utils.LottoNumberGenerator.generateLottoNumber;
import static lotto.validator.NumberValidator.hasValidLotteryNumber;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @Test
    @DisplayName("랜덤으로 조건에 맞는 6개의 숫자를 생성하여 List 에 담아 반환한다.")
    void checkLottoNumberGenerator() {
        //when
        List<Integer> numbers = generateLottoNumber();

        //then
        hasValidLotteryNumber(numbers);
    }
}
