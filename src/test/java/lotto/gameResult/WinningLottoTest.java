package lotto.gameResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    static final List<Integer> numbers = List.of(1,2,3,4,5,6);
    static final int bonus = 7;

    @DisplayName("당첨 5등의 로또 갯수를 테스트")
    @Test
    void fifthClass() {
        List<List<Integer>> lottoBundle = List.of(
                List.of(1,2,3,8,9,10),
                List.of(4,5,6,11,12,13),
                List.of(15,16,17,18,19,20)
        );

        WinningLotto.fifthClassFind(lottoBundle, numbers);
        
        assertThat(WinningLotto.fifthClassNumber).isEqualTo(2);
    }

    @DisplayName("당첨 2등의 로또 갯수를 테스트")
    @Test
    void secondClass() {
        List<List<Integer>> lottoBundle = List.of(
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,8)
        );

        WinningLotto.secondClassFind(lottoBundle, numbers, bonus);

        assertThat(WinningLotto.secondClassNumber).isEqualTo(1);
    }
}
