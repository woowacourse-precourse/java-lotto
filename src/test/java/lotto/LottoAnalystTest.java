package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAnalystTest {
    @Test
    @DisplayName("로또 카운터 반환")
    void getLottoGradeCounter() throws Exception {
        LottoAnalyst lottoAnalyst = new LottoAnalyst();
        //given
        List<LottoGrade> lottoGrades = List.of(
                LottoGrade.FIRST, LottoGrade.FIRST,
                LottoGrade.SECOND,LottoGrade.SECOND,
                LottoGrade.THIRD, LottoGrade.THIRD,
                LottoGrade.FOURTH, LottoGrade.FOURTH,
                LottoGrade.FIFTH, LottoGrade.FIFTH,
                LottoGrade.BANG, LottoGrade.BANG
                );
        int expect = 2;
        //when
        LottoGradeCounter counter = lottoAnalyst.analyze(lottoGrades);
        //then
        counter.forEach((k,v) -> {
            assertThat(v).isEqualTo(expect);
        });
    }
}