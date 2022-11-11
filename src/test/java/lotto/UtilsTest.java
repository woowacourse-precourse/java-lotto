package lotto;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.utils.Utils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;



class UtilsTest {

    @Test
    void sortListNaturalOrder() {
        //given
        List<Integer> case1 = Arrays.asList(1,17,45,8,5,23);

        //when
        Utils.sortListNaturalOrder(case1);

        //then
        assertThat(case1).isSorted();
    }
}