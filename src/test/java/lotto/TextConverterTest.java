package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextConverterTest {
    @Test
    @DisplayName("콤마로 문자열을 분할 후 리스트로 변환")
    void comma() {
        String[] strings = TextConverter.splitComma("1,2,3,4,5");
        List list = Arrays.asList(strings);
        System.out.println("list = " + list);
    }
}