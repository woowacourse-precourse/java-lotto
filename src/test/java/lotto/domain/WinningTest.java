package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningTest {

    @DisplayName("사용자 번호와 당첨번호 보너스 번호를 받아 당첨 여부 계산")
    @Test
    void score() {
        Winning winning = new Winning();
        List<Lotto> list = new ArrayList<>();
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        list.add(lotto);
        winning.score(list, Arrays.asList(1,2,3,4,5,8), 6);
        assertThat(winning.win2).isEqualTo(1);
    }

    @DisplayName("같은 숫자 갯수 테스트")
    @Test
    void sameCount() {
        Winning winning = new Winning();
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int count = winning.sameCount(lotto, Arrays.asList(6,7,8,9,10,11));
        assertThat(count).isEqualTo(1);
    }

    @DisplayName("보너스가 맞으면 2등 증가")
    @Test
    void bonusCount1() {
        Winning winning = new Winning();
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        winning.bonusCount(lotto, 6);
        assertThat(winning.win2).isEqualTo(1);
    }

    @DisplayName("보너스가 틀리면 3등 증가")
    @Test
    void bonusCount2() {
        Winning winning = new Winning();
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        winning.bonusCount(lotto, 7);
        assertThat(winning.win3).isEqualTo(1);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void rate() {
        Winning winning = new Winning();
        double rate = winning.rate(Arrays.asList(1,0,0,0,0), 8000);
        assertThat(rate).isEqualTo(62.5);
    }

    @DisplayName("입력 받은 당첨 번호 리스트로 변환")
    @Test
    void winning() {
        Winning winning = new Winning();
        List<Integer> list = winning.winning("1,2,3,4,5,6");
        assertThat(list).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}