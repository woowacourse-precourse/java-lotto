package lotto.game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalResultTest {
    @Test
    @DisplayName("5등이 3개, 4등이 1개, 3등이 1개일 경우 갯수가 맞아야한다")
    void LottoGrade3to3And4to1And3to1MustCorrect() {
        // given
        List<LottoGrade> winnings = List.of(
                LottoGrade.FIFTH,
                LottoGrade.FIFTH,
                LottoGrade.FIFTH,
                LottoGrade.FOURTH,
                LottoGrade.THIRD
        );
        // when
        TotalResult totalResult = TotalResult.of(winnings);

        // then
        assertThat(totalResult.getCount(LottoGrade.FIFTH))
                .isEqualTo(3);
        assertThat(totalResult.getCount(LottoGrade.FOURTH))
                .isEqualTo(1);
        assertThat(totalResult.getCount(LottoGrade.THIRD))
                .isEqualTo(1);
        assertThat(totalResult.getCount(LottoGrade.SECOND))
                .isEqualTo(0);
        assertThat(totalResult.getCount(LottoGrade.FIRST))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("5등이 100개, 4등이 50개, 3등이 30개 2등이 20개, 1등이 10개일 경우 갯수가 맞아야한다")
    void LottoGradeComplexCountMustCorrect() {
        // given
        List<LottoGrade> winnings = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            winnings.add(LottoGrade.FIFTH);
        }
        for (int i = 0; i < 50; i++) {
            winnings.add(LottoGrade.FOURTH);
        }
        for (int i = 0; i < 30; i++) {
            winnings.add(LottoGrade.THIRD);
        }
        for (int i = 0; i < 20; i++) {
            winnings.add(LottoGrade.SECOND);
        }
        for (int i = 0; i < 10; i++) {
            winnings.add(LottoGrade.FIRST);
        }

        // when
        TotalResult totalResult = TotalResult.of(winnings);

        // then
        assertThat(totalResult.getCount(LottoGrade.FIFTH))
                .isEqualTo(100);
        assertThat(totalResult.getCount(LottoGrade.FOURTH))
                .isEqualTo(50);
        assertThat(totalResult.getCount(LottoGrade.THIRD))
                .isEqualTo(30);
        assertThat(totalResult.getCount(LottoGrade.SECOND))
                .isEqualTo(20);
        assertThat(totalResult.getCount(LottoGrade.FIRST))
                .isEqualTo(10);
    }

    @Test
    @DisplayName("당첨된 로또가 없으면 모든 갯수가 0이여야한다.")
    void LottoGradeNothingAllMust0() {
        // given
        List<LottoGrade> winnings = List.of();
        // when
        TotalResult totalResult = TotalResult.of(winnings);

        // then
        assertThat(totalResult.getCount(LottoGrade.FIFTH))
                .isEqualTo(0);
        assertThat(totalResult.getCount(LottoGrade.FOURTH))
                .isEqualTo(0);
        assertThat(totalResult.getCount(LottoGrade.THIRD))
                .isEqualTo(0);
        assertThat(totalResult.getCount(LottoGrade.SECOND))
                .isEqualTo(0);
        assertThat(totalResult.getCount(LottoGrade.FIRST))
                .isEqualTo(0);
    }
}