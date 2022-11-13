package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputNumsTest {


    @Test
    void 정수_나누기_확인() {
        checkSplit("1,2,3", List.of(1, 2, 3));
        checkSplit(" 1,2,3", List.of(1, 2, 3));
        checkSplit(" 1   , 2,3", List.of(1, 2, 3));
    }

    @Test
    void 정수_나누기_예외() {
        String empty = "";
        String notNums = "a, b, c";
        String notNumOnce = "1,2,a";
        String str = "asdfiguasfpogj";

        checkSplitException(empty);
        checkSplitException(notNums);
        checkSplitException(notNumOnce);
        checkSplitException(str);

    }

    void checkSplitException(String empty) {
        assertThatThrownBy(() -> new InputNums(",", empty).splitToInts()).isInstanceOf(IllegalArgumentException.class);
    }

    void checkSplit(String input, List<Integer> integers) {

        List<Integer> actual = new InputNums(",", input).splitToInts();

        assertThat(actual).isEqualTo(integers);
    }

}