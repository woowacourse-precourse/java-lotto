package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoBonusTest {

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생합니다.")
    @Test
    void duplicateWithLottoWinningNumbers(){
        assertThatThrownBy(() -> new LottoBonus(List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45 사이의 숫자가 아니면 예외가 발생합니다.")
    @Test
    void bonusNotIncludeRange(){
        assertThatThrownBy(() -> new LottoBonus(List.of(1,2,3,4,5,6), 67))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호를 제대로 넣었을 때 정상작동 됩니다.")
    @Test
    void createLottoBonusCorrect(){
        assertThatNoException().isThrownBy(() -> new LottoBonus(List.of(1,2,3,4,5,6), 7));
    }
}