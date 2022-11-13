package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.GameScore;
import lotto.domain.Lotto;
import lotto.domain.LottoWinType;
import lotto.domain.User;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void 정상적으로_입력한_경우_1등(){
        // given
        User testUser = User.of(1000, List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        Lotto winLottoNumber = Lotto.of(List.of(1,2,3,4,5,6));
        int bonusLottoNumber = 7;
        Map<LottoWinType, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoWinType.FIRST_PLACE, 1);
        resultMap.put(LottoWinType.SECOND_PLACE, 0);
        resultMap.put(LottoWinType.THIRD_PLACE, 0);
        resultMap.put(LottoWinType.FOURTH_PLACE, 0);
        resultMap.put(LottoWinType.FIFTH_PLACE, 0);
        resultMap.put(LottoWinType.ELSE, 0);

        // when
        GameScore successResult = GameScore.of(2000000000, testUser.getMoney(), resultMap);
        GameScore userResult = testUser.getGameScore(winLottoNumber, bonusLottoNumber);

        // then
        assertThat(userResult.getLottoWinType().get(LottoWinType.FIRST_PLACE))
                .isEqualTo(successResult.getLottoWinType().get(LottoWinType.FIRST_PLACE));
    }

    @Test
    void 정상적으로_입력한_경우_2등(){
        // given
        User testUser = User.of(1000, List.of(new Lotto(List.of(1, 2, 3, 4, 7, 6))));
        Lotto winLottoNumber = Lotto.of(List.of(1,2,3,4,9,6));
        int bonusLottoNumber = 7;
        Map<LottoWinType, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoWinType.FIRST_PLACE, 0);
        resultMap.put(LottoWinType.SECOND_PLACE, 1);
        resultMap.put(LottoWinType.THIRD_PLACE, 0);
        resultMap.put(LottoWinType.FOURTH_PLACE, 0);
        resultMap.put(LottoWinType.FIFTH_PLACE, 0);
        resultMap.put(LottoWinType.ELSE, 0);
        // when
        GameScore successResult = GameScore.of(30000000, testUser.getMoney(), resultMap);
        GameScore userResult = testUser.getGameScore(winLottoNumber, bonusLottoNumber);

        // then
        assertThat(userResult.getLottoWinType().get(LottoWinType.SECOND_PLACE))
                .isEqualTo(successResult.getLottoWinType().get(LottoWinType.SECOND_PLACE));
    }

    @Test
    void 정상적으로_입력한_경우_3등(){
        // given
        User testUser = User.of(1000, List.of(new Lotto(List.of(1, 2, 3, 4, 10, 6))));
        Lotto winLottoNumber = Lotto.of(List.of(1,2,3,4,9,6));
        int bonusLottoNumber = 7;
        Map<LottoWinType, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoWinType.FIRST_PLACE, 0);
        resultMap.put(LottoWinType.SECOND_PLACE, 0);
        resultMap.put(LottoWinType.THIRD_PLACE, 1);
        resultMap.put(LottoWinType.FOURTH_PLACE, 0);
        resultMap.put(LottoWinType.FIFTH_PLACE, 0);
        resultMap.put(LottoWinType.ELSE, 0);
        // when
        GameScore successResult = GameScore.of(1500000, testUser.getMoney(), resultMap);
        GameScore userResult = testUser.getGameScore(winLottoNumber, bonusLottoNumber);

        // then
        assertThat(userResult.getLottoWinType().get(LottoWinType.THIRD_PLACE))
                .isEqualTo(successResult.getLottoWinType().get(LottoWinType.THIRD_PLACE));
    }

    @Test
    void 정상적으로_입력한_경우_4등(){
        // given
        User testUser = User.of(1000, List.of(new Lotto(List.of(1, 2, 3, 11, 10, 6))));
        Lotto winLottoNumber = Lotto.of(List.of(1,2,3,4,9,6));
        int bonusLottoNumber = 7;
        Map<LottoWinType, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoWinType.FIRST_PLACE, 0);
        resultMap.put(LottoWinType.SECOND_PLACE, 0);
        resultMap.put(LottoWinType.THIRD_PLACE, 0);
        resultMap.put(LottoWinType.FOURTH_PLACE, 1);
        resultMap.put(LottoWinType.FIFTH_PLACE, 0);
        resultMap.put(LottoWinType.ELSE, 0);
        // when
        GameScore successResult = GameScore.of(50000, testUser.getMoney(), resultMap);
        GameScore userResult = testUser.getGameScore(winLottoNumber, bonusLottoNumber);

        // then
        assertThat(userResult.getLottoWinType().get(LottoWinType.FOURTH_PLACE))
                .isEqualTo(successResult.getLottoWinType().get(LottoWinType.FOURTH_PLACE));
    }

    @Test
    void 정상적으로_입력한_경우_5등(){
        // given
        User testUser = User.of(1000, List.of(new Lotto(List.of(1, 2, 12, 11, 10, 6))));
        Lotto winLottoNumber = Lotto.of(List.of(1,2,3,4,9,6));
        int bonusLottoNumber = 7;
        Map<LottoWinType, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoWinType.FIRST_PLACE, 0);
        resultMap.put(LottoWinType.SECOND_PLACE, 0);
        resultMap.put(LottoWinType.THIRD_PLACE, 0);
        resultMap.put(LottoWinType.FOURTH_PLACE, 0);
        resultMap.put(LottoWinType.FIFTH_PLACE, 1);
        resultMap.put(LottoWinType.ELSE, 0);
        // when
        GameScore successResult = GameScore.of(5000, testUser.getMoney(), resultMap);
        GameScore userResult = testUser.getGameScore(winLottoNumber, bonusLottoNumber);

        // then
        assertThat(userResult.getLottoWinType().get(LottoWinType.FIFTH_PLACE))
                .isEqualTo(successResult.getLottoWinType().get(LottoWinType.FIFTH_PLACE));
    }

    @Test
    void 정상적으로_입력한_경우_없음(){
        // given
        User testUser = User.of(1000, List.of(new Lotto(List.of(1, 13, 12, 11, 10, 6))));
        Lotto winLottoNumber = Lotto.of(List.of(1,2,3,4,9,6));
        int bonusLottoNumber = 7;
        Map<LottoWinType, Integer> resultMap = new HashMap<>();
        resultMap.put(LottoWinType.FIRST_PLACE, 0);
        resultMap.put(LottoWinType.SECOND_PLACE, 0);
        resultMap.put(LottoWinType.THIRD_PLACE, 0);
        resultMap.put(LottoWinType.FOURTH_PLACE, 0);
        resultMap.put(LottoWinType.FIFTH_PLACE, 0);
        resultMap.put(LottoWinType.ELSE, 1);

        // when
        GameScore successResult = GameScore.of(0, testUser.getMoney(), resultMap);
        GameScore userResult = testUser.getGameScore(winLottoNumber, bonusLottoNumber);

        // then
        assertThat(userResult.getLottoWinType().get(LottoWinType.ELSE))
                .isEqualTo(successResult.getLottoWinType().get(LottoWinType.ELSE));
        assertThat(userResult.getLottoWinType().get(LottoWinType.FIRST_PLACE)).isEqualTo(0);
        assertThat(userResult.getLottoWinType().get(LottoWinType.SECOND_PLACE)).isEqualTo(0);
        assertThat(userResult.getLottoWinType().get(LottoWinType.THIRD_PLACE)).isEqualTo(0);
        assertThat(userResult.getLottoWinType().get(LottoWinType.FOURTH_PLACE)).isEqualTo(0);
        assertThat(userResult.getLottoWinType().get(LottoWinType.FIFTH_PLACE)).isEqualTo(0);
        assertThat(userResult.getLottoWinType().get(LottoWinType.ELSE)).isEqualTo(1);
    }
}
