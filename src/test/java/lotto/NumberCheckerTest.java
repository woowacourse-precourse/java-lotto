package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberCheckerTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void compareNumbers() {
        List<Integer> answerlist = Arrays.asList(8, 22, 13, 4, 35, 6);
        List<List<Integer>> mylist = Arrays.asList(Arrays.asList(8, 22, 13, 4, 35, 6),Arrays.asList(8, 22, 13, 4, 35, 6));
//        NumberChecker checker = new NumberChecker(answerlist, mylist);
//        assertThat(NumberChecker.compareNumber()).isEqualTo(List.of(6,6));
    }

}