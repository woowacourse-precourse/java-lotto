package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import lotto.validation.Validation;
import org.junit.jupiter.api.Test;
import java.util.List;



class ValidationTest {

    @Test
    void validateNumberInRange_테스트() {
        //given
        List<Integer> case1 = List.of(30,1,45);
        List<Integer> case2 = List.of(0,1,45);
        List<Integer> case3 = List.of(90,1,45);

        //when
        Throwable result1 = catchThrowable(()->{
            Validation.validateNumberInRange(case1.get(0), case1.get(1), case1.get(2));
        });
        Throwable result2 = catchThrowable(()->{
            Validation.validateNumberInRange(case2.get(0), case2.get(1), case2.get(2));
        });
        Throwable result3 = catchThrowable(()->{
            Validation.validateNumberInRange(case3.get(0), case3.get(1), case3.get(2));
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }
}