package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGradeCounterTest {
    @Test
    @DisplayName("LottoGradeCounter에 대해 초기설정을 한다.")
    void LottoGradeCounterInit() throws Exception {
        //given
        LottoGradeCounter counter = new LottoGradeCounter();
        int expect = 0;
        //when
        //then
        counter.forEach((k, v) -> {
            assertThat(v).isEqualTo(expect);
        });
    }

    @Test
    @DisplayName("카운터에서 프린트용 리스트를 가져올 떄 꽝을 제거한다.")
    void checkPrintCounterRemoveBang() throws Exception {
        //given
        LottoGradeCounter counter = new LottoGradeCounter();
        counter.countByOne(LottoGrade.BANG);
        counter.countByOne(LottoGrade.BANG);
        counter.countByOne(LottoGrade.BANG);
        counter.countByOne(LottoGrade.BANG);
        int expect = 0;
        //when
        LottoGradeCounter printCounter = counter.getPrintList();
        //then
        printCounter.forEach((k, v) -> {
            assertThat(v).isEqualTo(expect);
        });
    }

    @Test
    @DisplayName("카운트업을 전체 2회씩 실행한다.")
    void countUpTwice() throws Exception {
        //given
        LottoGradeCounter counter = new LottoGradeCounter();
        //when
        counter.countByOne(LottoGrade.BANG);
        counter.countByOne(LottoGrade.BANG);
        counter.countByOne(LottoGrade.FIFTH);
        counter.countByOne(LottoGrade.FIFTH);
        counter.countByOne(LottoGrade.FOURTH);
        counter.countByOne(LottoGrade.FOURTH);
        counter.countByOne(LottoGrade.THIRD);
        counter.countByOne(LottoGrade.THIRD);
        counter.countByOne(LottoGrade.SECOND);
        counter.countByOne(LottoGrade.SECOND);
        counter.countByOne(LottoGrade.FIRST);
        counter.countByOne(LottoGrade.FIRST);
        int expect = 2;
        //then
        counter.forEach((k, v) -> {
            assertThat(v).isEqualTo(expect);
        });
    }
}