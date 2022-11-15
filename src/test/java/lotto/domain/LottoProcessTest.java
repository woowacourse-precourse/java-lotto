package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoProcessTest {
    private LottoProcess lottoProcess;

    @BeforeEach
    void setUp() {
        lottoProcess = new LottoProcess(
                List.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 7, 8, 9),
                        List.of(1, 2, 3, 4, 5, 10)
                ),
                List.of(1, 2, 3, 4, 5, 6),
                10,
                2000
        );
    }

    @DisplayName("lotto번호와 당첨 번호가 몇개 일치하는지 테스트")
    @Test
    void compareWinningNumbers() {
        int result = lottoProcess.compareWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("로또 번호와 당첨 번호를 비교해서 몇등인지 알려주는 테스트")
    @Test
    void decideRanks() {
        List<Integer> result = lottoProcess.decideRanks();
        assertThat(result).isEqualTo(List.of(1, 5, 2));
    }

    @DisplayName("5개가 맞고, 보너스 번호까지 맞추면 2등이 되는지 확인하는 테스트")
    @Test
    void decideRank() {
        int result = lottoProcess.decideRank(5, List.of(1, 2, 3, 4, 5, 10));
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("List를 주었을 때 1등부터 5등까지 등수와 명수를 매핑하여 반환하는지 테스트")
    @Test
    void countRanks() {
        Map<String, Integer> result = lottoProcess.countRanks(List.of(1, 5, 2));
        assertThat(result).isEqualTo(Map.of(
                "FIRST", 1,
                "SECOND", 1,
                "THIRD", 0,
                "FOURTH", 0,
                "FIFTH", 1
        ));
    }
}