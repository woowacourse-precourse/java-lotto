package lotto;

import lotto.exception.MyIllegalArgumentException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WinLottoTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되었을 때 예외 처리하는지 확인한다.")
    void createWinLottoByDuplicateNumber() {
        Assertions.assertThatThrownBy(() -> new WinLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(MyIllegalArgumentException.class);
    }

    @DisplayName("두 로또 번호의 교집합을 구하는 기능을 테스트한다.")
    @Test
    void compare() {
        Lotto lotto = new Lotto(Arrays.asList(3, 2, 1, 5, 4, 6));
        WinLotto winLotto = new WinLotto(Arrays.asList(1, 7, 8, 9, 10, 11), 12);
        Assertions.assertThat(winLotto.compare(lotto)).isEqualTo(Arrays.asList(1));
    }
}
