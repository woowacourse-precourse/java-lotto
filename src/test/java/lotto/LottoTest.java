package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
//    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
//    @Test
//    void createLottoByOverSize() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 로또 번호가 6개가 아닙니다.");
//    }
//
//    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
//    @Test
//    void createLottoByDuplicatedNumber() {
//        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 겹치는 로또 번호가 존재합니다.");
//    }
//
//    @DisplayName("로또 번호에 1과 45 사이에 있지 않는 숫자가 존재하면 예외가 발생한다.")
//    @Test
//    void createLottoByNumberOutOfRange() {
//        assertThatThrownBy(() -> new Lotto(List.of(41, 42, 43, 44, 45, 46)))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자들로 이루어져야 합니다.");
//    }
}
