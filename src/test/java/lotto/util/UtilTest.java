package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {

    @DisplayName("문자열을 ','로 나누어 List<Integer>로 변환한다.")
    @Test
    void stringToIntegerList() {
        String input = "1,2,3,4,5,6";
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> actual = Util.stringToIntegerList(input);
        assertEquals(expect, actual);
    }

    @DisplayName("List<Integer> 두개를 합해 변환한다.")
    @Test
    void joinIntegerList() {
        List<Integer> expect = List.of(1,2,3,4,5,6);
        List<Integer> listA = List.of(1,2,3);
        List<Integer> listB = List.of(4,5,6);
        assertEquals(expect, Util.joinIntegerList(listA, listB));
    }
}
