package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 발행에 대한 테스트")
class PublisherTest {

    Publisher publisher = new Publisher();

    @ParameterizedTest(name = "금액이 1000으로 나누어떨어지지않으면 예외가 발생한다.")
    @CsvSource(value = {"1001", "999", "123", "2003"})
    void createLottoByInvalidMoney(int money) {
        assertThatThrownBy(() -> publisher.getLottoGroup(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}