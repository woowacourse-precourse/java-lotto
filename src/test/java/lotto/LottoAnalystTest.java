package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAnalystTest {
    LottoAnalyst lottoAnalyst = new LottoAnalyst();

    @Test
    @DisplayName("로또 카운터 반환")
    void getLottoGradeCounter() throws Exception {
        //given
        List<LottoGrade> lottoGrades = List.of(
                LottoGrade.FIRST, LottoGrade.FIRST,
                LottoGrade.SECOND, LottoGrade.SECOND,
                LottoGrade.THIRD, LottoGrade.THIRD,
                LottoGrade.FOURTH, LottoGrade.FOURTH,
                LottoGrade.FIFTH, LottoGrade.FIFTH,
                LottoGrade.BANG, LottoGrade.BANG
        );
        int expect = 2;
        //when
        LottoGradeCounter counter = lottoAnalyst.analyze(lottoGrades);
        //then
        counter.forEach((k, v) -> {
            assertThat(v).isEqualTo(expect);
        });
    }

    @Test
    @DisplayName("수익률 계산-1등시")
    void getYieldTest1Grade() throws Exception {
        //given
        List<LottoGrade> lottoGrades = List.of(
                LottoGrade.FIRST
        );
        LottoGradeCounter gradeCounter = lottoAnalyst.analyze(lottoGrades);
        double expect = 200000000;
        //when
        double result = lottoAnalyst.getYield(gradeCounter);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("수익률 계산 - 8개 중 하나 5등")
    void getYieldTestFifthTo8() throws Exception {
        //given
        List<LottoGrade> lottoGrades = List.of(
                LottoGrade.FIFTH,
                LottoGrade.BANG,
                LottoGrade.BANG,
                LottoGrade.BANG,
                LottoGrade.BANG,
                LottoGrade.BANG,
                LottoGrade.BANG,
                LottoGrade.BANG
        );
        LottoGradeCounter gradeCounter = lottoAnalyst.analyze(lottoGrades);
        double expect = 62.5;
        //when
        double result = lottoAnalyst.getYield(gradeCounter);
        //then
        assertThat(result).isEqualTo(expect);
    }
}