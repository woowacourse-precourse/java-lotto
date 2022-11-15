package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("보너스 번호 추가 - 중복 숫자")
    @Test
    void addBonusNumber() throws Exception {
        //Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //When
        assertThatThrownBy(() -> lotto.setLottoBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 추가 - 범위를 넘어감")
    @Test
    void addBonusNumberOverRange() throws Exception {
        //Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //When
        assertThatThrownBy(() -> lotto.setLottoBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 숫자가 일치할 때")
    @Test
    void countAllNumbers() throws Exception {
        //Given
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        lotto.setLottoBonusNumber(7);

        //When
        int matchCount = lotto.getMatchCountWithLotto(List.of(6, 5, 4, 3, 2, 1));

        //Then
        assertThat(matchCount).isEqualTo(7);
    }

    @DisplayName("하나도 일치하지 않을 때")
    @Test
    void countNoNumbers() throws Exception {
        //Given
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        lotto.setLottoBonusNumber(7);

        //When
        int matchCount = lotto.getMatchCountWithLotto(List.of(9, 10, 11, 12, 13, 14));

        //Then
        assertThat(matchCount).isEqualTo(0);
    }

    @DisplayName("5개 맞으면서 보너스 넘버가 맞을 때")
    @Test
    void match5AndBonusNumber() throws Exception {
        //Given
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        lotto.setLottoBonusNumber(7);

        //When
        int matchCount = lotto.getMatchCountWithLotto(List.of(1, 2, 3, 4, 7, 10));

        //Then
        assertThat(matchCount).isEqualTo(6);
    }
}
