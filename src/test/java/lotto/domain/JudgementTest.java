package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {
    private Judgement judgement = new Judgement();
    @DisplayName("로또와 유저 입력 번호를 비교한다.")
    @Test
    void compareLottoAndUserInput() {
        List<Integer> user = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto = List.of(1, 3, 6, 7, 8, 9);
        int bonus = 9;
        assertThat(judgement.compare(lotto, user, bonus)).isEqualTo(4);
    }
}
