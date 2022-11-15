package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.controller.JudgeGame;
import lotto.model.GameDTO;
import lotto.model.UserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class JudgeGameTest extends NsTest {

    @DisplayName("judgeGame class로 승리 카운트 분류 테스트")
    @Test
    void judgeGameTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    UserDTO user = new UserDTO(8000);
                    GameDTO game = new GameDTO();
                    List<Integer> list = List.of(1, 2, 3, 4, 5, 6); // 당첨 번호 1,2,3,4,5,6 지정
                    game.setWinningNumber(list);
                    game.setBonusNumber(7); // 보너스 번호 7번으로 지정
                    JudgeGame judge = new JudgeGame(user, game);
                    // 각각의 승리 카운트 비교
                    assertThat(game.getWinningCount()[0]).isEqualTo(0); // 3개 일치 (0개) 비교
                    assertThat(game.getWinningCount()[1]).isEqualTo(2); // 4개 일치 (2개) 비교
                    assertThat(game.getWinningCount()[2]).isEqualTo(0); // 5개 일치 (0개) 비교
                    assertThat(game.getWinningCount()[3]).isEqualTo(1); // 5개 일치, 보너스 일치 (1개) 비교
                    assertThat(game.getWinningCount()[4]).isEqualTo(0); // 6개 일치 (0개) 비교
                },
                List.of(1, 2, 3, 4, 42, 43), // 내부에서 랜덤으로 픽하는 로또 번호를 직접 지정해서 테스트 케이스 작성
                List.of(1, 2, 3, 4, 5, 7),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 2, 3, 5, 14, 22)
        );
    }

    @Override
    public void runMain() {
    }
}
