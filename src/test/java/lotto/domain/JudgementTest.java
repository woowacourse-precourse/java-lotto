package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {
    private Judgement judgement = new Judgement();
    @DisplayName("로또와 유저 입력 번호를 비교하여 3개가 일치한다.")
    @Test
    void compareResult3() {
        List<Integer> user = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto = List.of(1, 3, 6, 7, 8, 9);
        int bonus = 9;
        assertThat(judgement.compare(lotto, user, bonus)).isEqualTo(3);
    }

    @DisplayName("로또와 유저 입력 번호를 비교하여 보너스 번호 및 5개가 일치한다.")
    @Test
    void compareResult5PlusBonus() {
        List<Integer> user = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto = List.of(1, 3, 4, 5, 6, 9);
        int bonus = 9;
        assertThat(judgement.compare(lotto, user, bonus)).isEqualTo(51);
    }

    @DisplayName("로또와 유저 입력 번호를 비교하여 아무것도 일치하지 않는다.")
    @Test
    void compareResultNothing() {
        List<Integer> user = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto = List.of(7, 8, 9, 10, 11, 12);
        int bonus = 44;
        assertThat(judgement.compare(lotto, user, bonus)).isEqualTo(0);
    }
}
