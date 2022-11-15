package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.util.ArrayAndListTwoSidedConversion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayAndListTwoSidedConversionTest {

    @DisplayName("stringArrayToIntegerList 메서드 테스트")
    @Test
    void stringArrayToIntegerListTest() {
        // given
        String[] stringArray = {"1", "2", "3", "4", "5", "6"};
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        // when
        List<Integer> integerList = ArrayAndListTwoSidedConversion.stringArrayToIntegerList(stringArray);

        // then
        assertThat(integerList).isEqualTo(list);
    }

    @DisplayName("integerListToStringArray 메서드 테스트")
    @Test
    void integerListToStringArrayTest() {
        // given
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6);
        String[] array = {"1", "2", "3", "4", "5", "6"};

        // when
        String[] stringArray = ArrayAndListTwoSidedConversion.integerListToStringArray(integerList);

        // then
        assertThat(stringArray).isEqualTo(array);
    }
}
