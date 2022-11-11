package lotto.check;

import lotto.check.WinningNumberCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberCheckTest {


    @DisplayName("로또 번호 정상 입력 테스트")
    @Test
    void winningNumberTest() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThat(winningNumber).isEqualTo(
                WinningNumberCheck.check("1,2,3,4,5,6")
        );
    }

    @Test
    void rangeTest(){
        String numbers = "1,2,3,55,4,7";
        assertThatThrownBy(()->{
            WinningNumberCheck.check(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}