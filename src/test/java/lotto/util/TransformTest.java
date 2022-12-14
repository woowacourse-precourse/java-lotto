package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TransformTest {
    private Transform transform;

    @DisplayName("1,2,3으로 공백 없이 들어온 문자열을 리스트로 생성하기")
    @Test
    void splitLottoNumbers() {
        String input = "1,2,3,4,5,6";
        assertThat(transform.splitedNumbers(input)).contains("1", "2", "3", "4", "5", "6");
    }

    @DisplayName("1, 2, 3으로 공백을 포함해서 들어온 문자열을 리스트로 생성하기")
    @Test
    void splitLottoNumbersWithBlank() {
        String input = "1, 2, 3, 4, 5, 6";
        assertThat(transform.splitedNumbers(input)).contains("1", "2", "3", "4", "5", "6");
    }

    @DisplayName("1 만 split 했을 때 1만 포함된 배열이 잘 나오는지 확인하기")
    @Test
    void splitLottoNumberWithBlank() {
        String input = "1 ";
        assertThat(transform.splitedNumbers(input)).contains("1");
    }

    @DisplayName("String을 가지고 있는 리스트를 Integer 데이터를 가진 리스트로 생성하기")
    @Test
    void transformType() {
        List<String> input = Arrays.asList("1", "2", "3", "4", "5", "6");
        assertThat(transform.convertType(input)).contains(1, 2, 3, 4, 5, 6);
    }
}