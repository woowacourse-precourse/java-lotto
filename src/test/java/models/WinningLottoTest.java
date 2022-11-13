package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import system.process.exception.IllegalArgument;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private Lotto lotto;

    @BeforeEach
    void createObject() {
        lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("보너스 번호가 범위를 벗어난다면 예외 발생.")
    @Test
    void createWinningLottoByOutOfRangeBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(lotto.getNumbers(), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.NOT_IN_RANGE.getMessage());
    }

    @DisplayName("보너스 번호와 중복된 로또 번호가 있다면 예외 발생.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(lotto.getNumbers(), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(IllegalArgument.DUPLICATION.getMessage());
    }

}
