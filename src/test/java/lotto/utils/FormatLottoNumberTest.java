package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatLottoNumberTest {

    @DisplayName("당첨번호 입력 포멧팅 테스트")
    @Test
    void winningNumberInputTest() {
        List<Integer> list = FormatLottoNumber.get("1,2,3,4,5,6");
        assertEquals("123456", list.stream().map(String::valueOf).collect(Collectors.joining()));
    }
}