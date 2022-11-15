package lotto.model.resources;

import java.util.List;
import lotto.ExceptionHandle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoWinTest {

    @Test
    void validation_중복() {
        List<Integer> material = List.of(1, 2, 3, 4, 5, 5);
        try {
            LottoWin lottoWin = LottoWin.of(material);
        } catch (ExceptionHandle exceptionHandle) {
            Assertions.assertThat(exceptionHandle.getMessage())
                .isEqualTo("[ERROR] 로또 당첨 번호는 1과 45 사이의 중복되지 않는 6개의 정수여야 합니다. - Lotto");
        }
    }

    @Test
    void validation_리스트_사이즈가_6이_아닐_경우() {
        List<Integer> material = List.of(1, 2, 4, 5, 5);
        try {
            LottoWin lottoWin = LottoWin.of(material);
        } catch (ExceptionHandle exceptionHandle) {
            Assertions.assertThat(exceptionHandle.getMessage())
                .isEqualTo("[ERROR] 로또 당첨 번호는 1과 45 사이의 중복되지 않는 6개의 정수여야 합니다. - Lotto");
        }
    }

    @Test
    void validation_숫자_범위() {
        List<Integer> material = List.of(1, 2, 3, 4, 55, 5);
        try {
            LottoWin lottoWin = LottoWin.of(material);
        } catch (ExceptionHandle exceptionHandle) {
            Assertions.assertThat(exceptionHandle.getMessage())
                .isEqualTo("[ERROR] 로또 당첨 번호는 1과 45 사이의 중복되지 않는 6개의 정수여야 합니다. - Lotto");
        }
    }

}