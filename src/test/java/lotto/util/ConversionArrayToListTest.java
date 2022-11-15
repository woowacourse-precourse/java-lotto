package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConversionArrayToListTest {
    @DisplayName("스트링 문자열이 인티저 리스트로 변환되는지 테스트")
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
}
