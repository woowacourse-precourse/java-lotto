package domain.user;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class NumberTest {

    Number number = new Number("1,2,3,4,5,6");

    @Test
    void 입력_받은_문자열을_리스트로_변환_테스트() {
        String input = "1,2,3,4,5";
        int[] intArray = { 1, 2, 3, 4, 5};
        List<Integer> result = number.stringToList(input);

        assertThat(result.size()).isEqualTo(intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            assertThat(result.get(i)).isEqualTo(intArray[i]);
        }
    }
}