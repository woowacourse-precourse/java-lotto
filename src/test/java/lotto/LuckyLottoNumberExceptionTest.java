package lotto;

import java.util.List;
import lotto.exception.LuckyLottoNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LuckyLottoNumberExceptionTest {

    LuckyLottoNumberException luckyLottoNumberException;

    @BeforeEach
    void initializeClass(){
        luckyLottoNumberException = new LuckyLottoNumberException();
    }

    @DisplayName("checkDuplicatedLottoNumber 메서드 테스트")
    @Test
    void checkDuplicatedLottoNumberTest() {
        assertThatThrownBy(()->luckyLottoNumberException
                .checkDuplicatedLottoNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkLottoNumberBetweenOneAndFortyFive 테스트")
    @Test
    void checkLottoNumberBetweenOneAndFortyFiveTest(){
        assertThatThrownBy(()->luckyLottoNumberException
                .checkLottoNumberBetweenOneAndFortyFive(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkDuplicatedLottoBonusNumber 테스트")
    @Test
    void checkDuplicatedLottoBonusNumberTest(){
        assertThatThrownBy(()->luckyLottoNumberException
                .checkDuplicatedLottoBonusNumber(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkLottoBonusNumberBetweenOneAndFortyFive 테스트")
    @Test
    void checkLottoBonusNumberBetweenOneAndFortyFiveTest(){
        assertThatThrownBy(()->luckyLottoNumberException
                .checkLottoBonusNumberBetweenOneAndFortyFive(1000000))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
