package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("로또 구매시 1000원당 1장만큼 생성이 된다.")
    @Test
    void purchaseLottoTest() {
        lottoService.purchase(new Money(5000));

        assertThat(lottoService.getPurchaseLotteries().size()).isEqualTo(5);
    }

    @DisplayName("입력 받은 당첨 번호가 유효하지 않은 경우 예외가 발생한다.")
    @MethodSource("invalidWinningNumber")
    @ParameterizedTest(name = "{0} : {1}")
    void invalidWinningNumberTest(String situation, String winningNumber, String bonusNumber) {
        assertThatThrownBy(() -> lottoService.setWinningNumber(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidWinningNumber() {
        return Stream.of(
                Arguments.of("숫자가 6개보다 많은 경우", "1,2,3,4,5,6,7", "9"),
                Arguments.of("알파벳이 포함된 경우", "1,2,3,4,5,a", "9"),
                Arguments.of("숫자 범위를 벗어난 경우", "1,2,3,4,5,50", "9"),
                Arguments.of("한글이 들어간 경우", "ㄱ,ㄴ,ㄷ,ㄹ,ㅁ", "9"),
                Arguments.of("공백인 경우", "", "9"),
                Arguments.of("숫자가 적은 경우", "1,2,3", "9")
        );
    }
}