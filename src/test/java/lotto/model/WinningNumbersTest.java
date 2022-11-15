package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningNumbersTest {

    @Test
    @DisplayName("당첨번호 생성시 당첨번호가 보너스번호와 중복될때")
    void case1() {
        //given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 1;
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumbers, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
