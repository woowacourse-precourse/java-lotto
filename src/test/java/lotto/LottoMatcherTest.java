package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatcherTest {
    @Test
    @DisplayName("로또 비교 수행")
    void matchLotto() throws Exception {
        //given
        Lotto winningNumbers = new Lotto(List.of(1,2,3,4,5,6));
        Integer bonusNumber = 7;
        LottoMatcher lottoMatcher = new LottoMatcher(winningNumbers, bonusNumber);
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6))); //1등
        lottos.add(new Lotto(List.of(1,2,3,4,5,7))); // 2등
        lottos.add(new Lotto(List.of(1,2,3,4,5,8))); // 3등
        lottos.add(new Lotto(List.of(1,2,3,4,8,9))); // 4등
        lottos.add(new Lotto(List.of(1,2,3,8,9,10))); // 5등
        lottos.add(new Lotto(List.of(1,2,8,9,10,11))); // 꽝

        List<LottoGrade> expect = new ArrayList<>();
        expect.add(LottoGrade.FIRST);
        expect.add(LottoGrade.SECOND);
        expect.add(LottoGrade.THIRD);
        expect.add(LottoGrade.FOURTH);
        expect.add(LottoGrade.FIFTH);
        expect.add(LottoGrade.BANG);
        //when
        List<LottoGrade> lottoGrades = lottoMatcher.matchAll(lottos);
        //then
        assertThat(lottoGrades).isEqualTo(expect);
    }
}