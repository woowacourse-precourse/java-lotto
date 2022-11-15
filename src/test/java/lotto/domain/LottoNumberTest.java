package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumberTest {

    @DisplayName("당첨번호 비정상 입력 테스트")
    @ParameterizedTest(name = "{index}: {3}")
    @MethodSource("inputLottoNumberTest")
    void 테스트(String winningCount, String bonusCount, String errormessage, String message) {
        assertThatThrownBy(() -> new LottoNumber(winningCount, bonusCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errormessage);
    }

    private static Stream<Arguments> inputLottoNumberTest() {
        return Stream.of(
                Arguments.of("1*,2,3,4,5,6", "7", NOT_NUMBER, "숫자x"),
                Arguments.of("1,2,3,4,5,46", "7", NOT_LOTTO_NUMBER_RANGE, "숫자범위초과"),
                Arguments.of("1,2,3,4,5,0", "7", NOT_LOTTO_NUMBER_RANGE, "숫자범위미달"),
                Arguments.of("1,2,3,4,5, ", "7", NOT_NUMBER, "공백포함"),
                Arguments.of("1,2,3,4,5,6", " ", NOT_NUMBER, "보너스숫자 미입력"),
                Arguments.of("1,2,3,4,6", "7", NOT_LOTTO_LENGTH, "당첨숫자 개수미달")
        );
    }

    @Test
    void 당첨번호_정상입력() {
        new LottoNumber("1,2,3,4,5,6", "7");
    }

    @Test
    void 당첨번호_비교_테스트() {
        LottoNumber lottoNumber = new LottoNumber("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 7));

        MatchCount matchResult = lotto.getMatchResult(lottoNumber);
        MatchCount answer = new MatchCount(3, 1);

        assertTrue(answer.isSameResult(matchResult));
    }

    @Test
    void 당첨번호_비교_테스트_비정상() {
        LottoNumber lottoNumber = new LottoNumber("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 10, 11, 7));

        MatchCount matchResult = lotto.getMatchResult(lottoNumber);
        MatchCount answer = new MatchCount(4, 1);

        assertFalse(answer.isSameResult(matchResult));
    }
}