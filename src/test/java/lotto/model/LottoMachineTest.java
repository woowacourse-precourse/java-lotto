package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("주어진 가격으로 적절하게 로또를 구매하는 지 검증한다.")
    @ParameterizedTest(name = "{index} ==> 주어진 값이 {0}원이라면 로또를 {1}장 구매한다.")
    @CsvSource(value = {"20000:20", "10000:10", "1000:1", "2000:2", "500:0", "0:0", "12000:12", "12500:12"}, delimiter = ':')
    void sut_publish_lotto_by_price_then_size_is_equal_expected(int source, int expected) {
        LottoMachine lottoMachine = new LottoMachine();
        int actual = lottoMachine.publish(source).size();
        assertThat(actual).isEqualTo(expected);
    }

}