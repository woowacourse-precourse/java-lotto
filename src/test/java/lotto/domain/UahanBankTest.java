package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Method;
import java.util.List;
import lotto.Lotto;
import lotto.Score;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UahanBankTest {
    private static UahanBank uahanBank;

    @DisplayName("테스트를 위해 UahanBank 클래스를 Mocking 처리한다.")
    @BeforeAll
    public static void beforeALl() {
        uahanBank = mock(UahanBank.class);
    }

    @DisplayName("등수별 점수 리스트를 생성한다.")
    @Test
    void testCreateRankScore() throws Exception {
        Method createRankScoreMethod = UahanBank.class.getDeclaredMethod("createRankScore");
        createRankScoreMethod.setAccessible(true);

        List<Score> scores = List.of(new Score(6, 0), new Score(5, 1), new Score(5, 0), new Score(4, 0),
                new Score(3, 0));

        assertThat(createRankScoreMethod.invoke(uahanBank)).usingRecursiveComparison().isEqualTo(scores);
    }

    @DisplayName("당첨과 보너스 번호를 제출한 로또와 비교해서 점수로 반환한다.")
    @Test
    void testCalculateLottoToScore() throws Exception {
        Method calculateLottoToScoreMethod = UahanBank.class.getDeclaredMethod("calculateLottoToScore", List.class,
                List.class, List.class);
        calculateLottoToScoreMethod.setAccessible(true);

        List<Integer> wonLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> bonusLotto = List.of(7);
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 7);

        Score score = new Score(5, 1);

        assertThat(calculateLottoToScoreMethod.invoke(uahanBank, wonLotto, bonusLotto, lotto)).usingRecursiveComparison().isEqualTo(score);
    }
}
