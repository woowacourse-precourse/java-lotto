package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgementTest {
    @Test
    void 로또_번호와_당첨번호_및_보너스_번호가_일치하는_개수_구하기() {
        Judgement judgement = new Judgement();
        List<Integer> matchedCount = judgement.getRanking(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(matchedCount).isEqualTo(List.of(5, 1));
    }
}