package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class LottoBonusTest {

    @DisplayName("당첨 번호와 중복된 숫자가 존재하면 예외가 발생한다.")
    @Test
    void 로또번호_중복() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String orderBonusNumber = "3";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LottoBonus lottoBonus = new LottoBonus(lottoNumbers, orderBonusNumber);
        });

    }

    @DisplayName("숫자 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 숫자_범위() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        String orderBonusNumber = "46";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LottoBonus lottoBonus = new LottoBonus(lottoNumbers, orderBonusNumber);
        });

    }
}