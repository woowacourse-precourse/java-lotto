package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class CompareTest {
    @Test
    void 번호6개일치(){
        Compare compare = new Compare();
        int result = compare.correctCount(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6));
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 번호5개일치(){
        Compare compare = new Compare();
        int result = compare.correctCount(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,25,4,5,6));
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 번호4개일치(){
        Compare compare = new Compare();
        int result = compare.correctCount(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,25,4,5,6));
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 번호3개일치(){
        Compare compare = new Compare();
        int result = compare.correctCount(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,25,4,5,6));
        assertThat(result).isEqualTo(5);
    }
}

class bonusNumber{
    @Test
    void 보너스번호포함(){
        Compare compare = new Compare();
        int result = compare.bonusNumber(Arrays.asList(1,2,3,4,5,6), 6);
        assertThat(result).isEqualTo(1);
    }
}