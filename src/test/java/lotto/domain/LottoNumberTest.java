package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    void 당첨번호_정상입력() {
        new LottoNumber("1,2,3,4,5,6", "7");
    }

    @Test
    void 당첨번호_비정상입력_숫자x() {
        assertThatThrownBy(() -> new LottoNumber("1*,2,3,4,5,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER);
    }

    @Test
    void 당첨번호_비정상입력_숫자범위초과() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5,46", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 당첨번호_비정상입력_숫자범위미달() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5,0", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_LOTTO_NUMBER_RANGE);
    }

    @Test
    void 당첨번호_비정상입력_공백포함() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5, ", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER);
    }

    @Test
    void 당첨번호_비정상입력_보너스_숫자_미입력() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5,6", " "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NUMBER);
    }

    @Test
    void 당첨번호_비정상입력_당첨숫자_개수_미달() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,6", "7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_LOTTO_LENGTH);
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