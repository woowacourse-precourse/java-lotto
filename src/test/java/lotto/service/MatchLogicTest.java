package lotto.service;

import lotto.Lotto;
import lotto.view.LottoIO;
import lotto.view.UserIO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatchLogicTest {

    LottoIO lottoInfo;
    UserIO user;
    int bonus;
    MatchLogic matchLogic;
    List<Lotto> userLotto;
    List<Integer> answer;
    List<Integer> counts;
    List<Boolean> hasBonus;

    @BeforeEach
    void setup() {
        LottoIO lottoInfo = new LottoIO();
        UserIO user = new UserIO();

        userLotto = new ArrayList<>(Arrays.asList(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(6, 7, 8, 9, 10, 11)), new Lotto(List.of(1, 2, 3, 6, 7, 9)), new Lotto(List.of(1, 2, 3, 6, 7, 10))));
        answer = new ArrayList<>(List.of(1, 2, 3, 6, 7, 8));
        counts = new ArrayList<>(List.of(4, 3, 5, 5));
        hasBonus = new ArrayList<>(List.of(false, true, false, true));
        bonus = 10;

        user.setUserLotto(userLotto);
        lottoInfo.setLottoAnswer(answer);
        lottoInfo.setBonus(bonus);
        matchLogic = new MatchLogic(lottoInfo, user);
    }

    @Test
    void 당첨번호_비교() {
        int count = 0;
        for (int i = 0; i < userLotto.size(); i++) {
            Lotto usr = userLotto.get(i);
            count = matchLogic.answerMatch(usr.getNumbers(), answer);
            assertThat(count).isEqualTo(counts.get(i));
        }
    }

    @Test
    void 보너스번호_비교() {
        boolean containsBonus = false;
        for (int i = 0; i < userLotto.size(); i++) {
            Lotto usr = userLotto.get(i);
            containsBonus = matchLogic.bonusMatch(usr.getNumbers(), bonus);
            assertThat(containsBonus).isEqualTo(hasBonus.get(i));
        }
    }

    @Test
    void 로또_등수_구하기() {
        Optional<Statistics> fourthPlace = Statistics.getRank(counts.get(0), false);
        Optional<Statistics> secPlaceWithBonus = Statistics.getRank(counts.get(2), true);
        Optional<Statistics> thirdPlace = Statistics.getRank(counts.get(2), false);

        assertThat(fourthPlace.get()).isEqualTo(Statistics.FOURTH);
        assertThat(secPlaceWithBonus.get()).isEqualTo(Statistics.SEC);
        assertThat(thirdPlace.get()).isEqualTo(Statistics.THIRD);
    }

    @Test
    void 등수_저장() {
        Optional<Statistics> fourthPlace = Statistics.getRank(counts.get(0), false);

        matchLogic.setWinner(fourthPlace.get().getIndex());
        assertThat(matchLogic.getMatchNums().get(3)).isEqualTo(1);
    }

    @Test
    void 당첨_통계_로직() {
        matchLogic.countMatches();
        assertThat(matchLogic.getMatchNums()).isEqualTo(List.of(0, 1, 1, 1, 0));
    }


}