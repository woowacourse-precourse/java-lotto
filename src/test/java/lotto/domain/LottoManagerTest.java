package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManagerTest {
    LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
    }

    @DisplayName("구입 금액에 해당하는 개수만큼 로또를 발행했는지 테스트")
    @Test
    void findLottoCountByMoney() {
        int count = 8;
        List<Lotto> lottos = lottoManager.createLottos(count);
        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void checkLuckyNumberByOverSize() {
        assertThatThrownBy(() -> lottoManager.validateLuckyNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkLuckyNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> lottoManager.validateLuckyNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 1 ~ 45 범위 밖의 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkLuckyNumberByRangeOverNumber() {
        assertThatThrownBy(() -> lottoManager.validateLuckyNumber(List.of(1, 2, 3, 4, 5, 50)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45 범위 밖의 숫자면 예외가 발생한다.")
    @Test
    void checkBonusNumberByRangeOverNumber() {
        assertThatThrownBy(() -> lottoManager.checkDuplication(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 있는 번호면 예외가 발생한다.")
    @Test
    void checkBonusNumberInLuckyNumber() {
        assertThatThrownBy(() -> lottoManager.checkDuplication(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}