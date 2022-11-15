package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class ConverterTest {

    @DisplayName("번호를 쉼표로 구분하여 입력한 문자열을 List<Integer>로 변환한다.")
    @Test
    void 쉼표로_구분된_번호_문자열을_리스트로_변환() {
        String input = "1,2,3,4,5,6";
        List<Integer> list = Converter.convertToIntegerList(input);
        assertThat(list).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또는 1,000원에 한 장씩 구매할 수 있다.")
    @Test
    void 구매금액을_로또_개수로_변환() {
        int purchaseAmount = 8000;
        assertThat(Converter.convertToCountsOfLotto(purchaseAmount)).isEqualTo(8);
    }

    @DisplayName("금액의 1000 단위마다 쉼표를 붙여준다.")
    @Test
    void 정수를_쉼표를_포함한_문자열로_변환() {
        int billion = 1000000000;
        String billionWithComma = "1,000,000,000";
        assertThat(Converter.convertToStringWithComma(billion)).isEqualTo(billionWithComma);
    }

    @DisplayName("실수의 소수점 두 번째 자리에서 반올림하고 1000 단위마다 쉼표를 붙여준다.")
    @Test
    void 실수를_소수점_첫째_자리까지_쉼표를_포함한_문자열로_변환() {
        double rate = (double)10000 / 3;
        String rateWithCommaAndDot = "3,333.3";
        assertThat(Converter.convertToStringWithCommaAndDot(rate)).isEqualTo(rateWithCommaAndDot);
    }
}