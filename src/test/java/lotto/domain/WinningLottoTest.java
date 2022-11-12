package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningLottoTest {

    @DisplayName("보너스 번호를 맞췄는지")
    @Test
    void case2() {
        List<Integer> winningNumber = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
        WinningLotto winningLotto = new WinningLotto(winningNumber, 7);
        List<Integer> myNumber = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());

        assertThat(winningLotto.containsBonus(myNumber)).isEqualTo(false);
    }

}