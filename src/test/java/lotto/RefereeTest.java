package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RefereeTest {

    @DisplayName("주어진 금액과 결과들을 토대로 수익률 계산")
    @Test
    void calculateEarningRate() {
        List<GameResult> gameResults = List.of(
                GameResult.FIFTH,
                GameResult.ELSE,
                GameResult.ELSE,
                GameResult.ELSE,
                GameResult.ELSE,
                GameResult.ELSE,
                GameResult.ELSE,
                GameResult.ELSE);
        GameResultResponseDto responseDto = Referee.calculateLottoResults(gameResults, 8000);
        Assertions.assertThat(responseDto.getEarningRate()).isEqualTo(62.5D);
    }
}
