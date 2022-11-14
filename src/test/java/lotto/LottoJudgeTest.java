package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 등수 판별자는")
class LottoJudgeTest {

    @Test
    @DisplayName("로또 번호가 당첨 번호와 6개 일치하면 1등이다.")
    void matched_6LottoNumber() {
        assertLottoJudgeTest(
                List.of(1, 2, 3, 4, 5, 6),
                7,
                List.of(1, 2, 3, 4, 5, 6),
                LottoPlace.MATCHED_6
        );
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호와 5개 일치하고 보너스 번호와 일치하면 2등이다.")
    void matched_5LottoNumber_WithBonus() {
        assertLottoJudgeTest(
                List.of(1, 2, 3, 4, 5, 6),
                7,
                List.of(1, 2, 3, 4, 5, 7),
                LottoPlace.MATCHED_5_WITH_BONUS
        );
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호와 5개 일치하면 3등이다.")
    void matched_5LottoNumber() {
        assertLottoJudgeTest(
                List.of(1, 2, 3, 4, 5, 6),
                7,
                List.of(1, 2, 3, 4, 5, 26),
                LottoPlace.MATCHED_5
        );
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호와 4개 일치하면 4등이다.")
    void matched_4LottoNumber() {
        assertLottoJudgeTest(
                List.of(1, 2, 3, 4, 5, 6),
                7,
                List.of(1, 2, 3, 44, 5, 26),
                LottoPlace.MATCHED_4
        );
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호와 3개 일치하면 5등이다.")
    void matched_3LottoNumber() {
        assertLottoJudgeTest(
                List.of(1, 2, 3, 4, 5, 6),
                7,
                List.of(1, 16, 3, 34, 5, 26),
                LottoPlace.MATCHED_3
        );
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호와 2개 일치하면 등수가 없다.")
    void matched_2LottoNumber() {
        assertLottoJudgeTest(
                List.of(1, 2, 3, 4, 5, 6),
                7,
                List.of(1, 16, 33, 34, 5, 26),
                LottoPlace.NONE
        );
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호와 1개 일치하면 등수가 없다.")
    void matched_1LottoNumber() {
       assertLottoJudgeTest(
                List.of(1, 2, 3, 4, 5, 6),
                7,
                List.of(1, 16, 33, 34, 25, 26),
                LottoPlace.NONE
        );
    }

    @Test
    @DisplayName("로또 번호가 당첨 번호와 0개 일치하면 등수가 없다.")
    void matched_0LottoNumber() {
        assertLottoJudgeTest(
                List.of(1, 2, 3, 4, 5, 6),
                7,
                List.of(21, 16, 13, 34, 45, 26),
                LottoPlace.NONE
        );
    }

    private static void assertLottoJudgeTest(
            List<Integer> judgeLottoNumbers,
            int judgeBonusNumber,
            List<Integer> userLottoNumbers,
            LottoPlace result
    ) {
        LottoJudge judge = new LottoJudge(judgeLottoNumbers, judgeBonusNumber);
        Lotto userLotto = new Lotto(userLottoNumbers);
        assertThat(judge.judgePlace(userLotto)).isEqualTo(result);
    }
}