package lotto;

import lotto.Domain.LottoWinnerNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 문자열 당첨 번호는 리스트로 변환된다.")
    void convertWinnerNumber() {
        //given
        String winnerLottoNumber = "1,3,5,7,9,11";
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(winnerLottoNumber);
        List<Integer> expectLottoNumber = new ArrayList<>(Arrays.asList(1,3,5,7,9,11));

        //when
        List<Integer> convertLottoNumber = lottoWinnerNumber.convertWinnerNumber(winnerLottoNumber);

        //then
        assertEquals(convertLottoNumber,expectLottoNumber);
    }

    @Test
    @DisplayName("당첨 번호에 숫자와 콤마 이외의 문자가 있다면 예외가 발생한다.")
    void validInputWinNumber() {
        assertThatThrownBy(() -> new LottoWinnerNumber("2,3,4,8,9;10;"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
