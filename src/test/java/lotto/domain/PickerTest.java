package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.constant.Rank;

class PickerTest {
    private List<Lotto> userLottos;

    @BeforeEach
    void setUp() {
        this.userLottos = List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 45),
                new Lotto(1, 9, 42, 43, 44, 45),
                new Lotto(1, 2, 3, 4, 44, 45)
        );
    }

    @DisplayName("당첨번호와 보너스 번호로 당첨 결과를 반환한다")
    @Test
    void decide_winning_with_winning_numbers_and_bonus_number() {
        Picker picker = new Picker(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(7));

        assertThat(picker.pick(userLottos))
                .containsExactly(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.NONE, Rank.FOURTH);
    }

    @DisplayName("당첨번호와 보너스 번호가 겹치면 예외를 발생시킨다")
    @Test
    void throw_IllegalArgumentException_when_winning_numbers_have_bonus_number() {
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThatIllegalArgumentException().isThrownBy(() -> new Picker(winningLotto, bonusNumber));
    }
}