package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAnalystTest {
    LottoAnalyst lottoAnalyst = new LottoAnalyst();

    @Test
    @DisplayName("각 등수별로 2개씩 입력 후 LottoGradeCounter를 반환한다.")
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
    @DisplayName("1개 구매하여 1등 당첨시 수익률을 반환한다.")
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
    @DisplayName("8개 구매하여 1개만 5등 당첨시 수익률을 반환한다.")
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