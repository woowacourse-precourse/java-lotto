package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputeTest {
    @DisplayName("당첨 내역이 알맞게 생성되었는지 확인한다.")
    @Test
    void checkWinRecords() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 11))
        );

        assertThat(new Compute(
                lottos,
                List.of(1, 2, 3, 4, 5, 6),
                11,
                6000
        ).getWinRecords().toString())
                .contains(
                        "THREE=1",
                        "FOUR=1",
                        "FIVE=1",
                        "FIVE_BONUS=1",
                        "SIX=1"
                );
    }

    @DisplayName("당첨 내역이 알맞게 생성되었는지 확인한다.")
    @Test
    void checkWinRecords2() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 11)),
                new Lotto(List.of(1, 2, 3, 7, 8, 11)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 11))
        );

        assertThat(new Compute(
                lottos,
                List.of(1, 2, 3, 4, 5, 6),
                11,
                6000
        ).getWinRecords().toString())
                .contains(
                        "THREE=1",
                        "FOUR=1",
                        "FIVE=1",
                        "FIVE_BONUS=1",
                        "SIX=1"
                );
    }

    @DisplayName("수익률이 제대로 계산되었는지 확인한다.")
    @Test
    void checkProfit() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 11))
        );

        assertThat(new Compute(
                lottos,
                List.of(1, 2, 3, 4, 5, 6),
                11,
                6000
        ).getProfit()).isEqualTo(33_859_250);
    }
}
