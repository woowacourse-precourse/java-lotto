package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWinningNumberServiceTest {
    @Test
    void 당첨_숫자_생성_정상_입력_테스트() {
        String input = "1,2,3,4,5,6";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(LottoWinningNumberService.generateLottoWinningNumber().getNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 정수가_아닌_문자_입력_예외_발생() {
        String input = "1,2,3,4,5,a";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(LottoWinningNumberService::generateLottoWinningNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자_비정상_입력_예외_발생() {
        String input = "1,,13,4,5,6,7";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(LottoWinningNumberService::generateLottoWinningNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}