package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.IllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConversionArrayToListTest {
    @DisplayName("스트링 문자열배열이 인티저 리스트로 변환되는지 테스트")
    @Test
    void stringArrayToIntegerListTest() {
        //given
        ConversionArrayToList conversionArrayToList = new ConversionArrayToList();
        String[] origin = {"1", "2", "3", "4", "5", "6"};
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        List<Integer> actualNumbers = conversionArrayToList.stringArrayToIntegerList(origin);

        //then
        assertThat(expectedNumbers).isEqualTo(actualNumbers);
    }

    @DisplayName("문자열 배열에 공백이 있다면 예외가 발생한다.")
    @Test
    void createContainBlankStringArray() {
        ConversionArrayToList conversionArrayToList = new ConversionArrayToList();
        String[] origin = {"1", "2", "3", "4", "5", " 9"};
        assertThatThrownBy(() -> conversionArrayToList
                .stringArrayToIntegerList(origin))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

