package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchConditonTest {

    MatchingCondition matchingCondition;
    List<Lotto> userLottos;
    List<Integer> winning;

    @BeforeEach
    void setUP(){
        matchingCondition = new MatchingCondition();
        userLottos = new ArrayList<>();
        winning = new ArrayList<>(Arrays.asList(1,2,12,13,14,15));
    }

    @DisplayName("유저 로또번호와 당첨번호가 잘 비교 되는지 조회")
    @Test
    void matchWithWinningNumbers(){
        //given
         List<Integer> given = Arrays.asList(1,2,3,4,5,6);

         //when
        int actual = matchingCondition.usersOneLottoMatchWithWinningNumbers(given,winning);

        //then
        assertThat(actual).isEqualTo(2);
    }

    @DisplayName("보너스 번호 당첨 조건 확인")
    @Test
    void matchBonusNumber(){
        //given
        int bonus = 6;
        userLottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        boolean expected = true;

        //when
        boolean actual = matchingCondition.matchBonusNumber(bonus,userLottos);

        //then
        assertThat(actual).isEqualTo(expected);

    }

    @DisplayName("유저가 구매한 로또들이 당첨번호와 제대로 비교되는지 확인")
    @Test
    void getMatchResult(){
        //given
        int bonus = 12;
        userLottos.add(new Lotto(Arrays.asList(1,2,12,13,14,15)));
        userLottos.add(new Lotto(Arrays.asList(1,2,7,8,9,13)));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,0,0,0,0,0));

        //when
        List<Integer> actual = matchingCondition.getMatchResult(userLottos,winning,bonus);

        //then
        assertThat(actual).isEqualTo(expected);

    }
}
