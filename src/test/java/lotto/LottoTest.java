package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("보너스 번호일 경우 true 반환")
    @Test
    void returnTrueBonusNumber() {
        int bonusNumber = 6;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertTrue(lotto.isBonusNumber(6));
    }

    @DisplayName("로또 번호가 아닐 경우 false 반환")
    @Test
    void returnFalseBonusNumber() {
        int bonusNumber = 10;
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertFalse(lotto.isBonusNumber(10));
    }

    @DisplayName("당첨 로또 개수 반환")
    @Test
    void returnCountWinLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertEquals(6, lotto.getLottoNumber(lottoNumbers));
    }
}
