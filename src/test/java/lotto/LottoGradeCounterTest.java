package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGradeCounterTest {
    @Test
    @DisplayName("초기값이 제대로 들어가는가")
    void checkInit() throws Exception {
        //given
        LottoGradeCounter counter = new LottoGradeCounter();
        int expect = 0;
        //when
        //then
        counter.forEach((k,v) -> {
            assertThat(v).isEqualTo(expect);
        });
    }

    @Test
    @DisplayName("프린트용 Counter가 꽝을 제외하는가")
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
        printCounter.forEach((k,v) -> {
            assertThat(v).isEqualTo(expect);
        });
    }
}