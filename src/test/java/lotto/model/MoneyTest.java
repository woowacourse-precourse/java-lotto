package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.MoneyConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    private static Stream<Arguments> provideMoneyAndResultAndRateAnswer() {
        return Stream.of(
                Arguments.of(Money.from("8000"), Result.of(List.of(Rank.from(5))),"62.5"),
                Arguments.of(Money.from("344000"), Result.of(List.of(Rank.from(5))),"1.5"),
                Arguments.of(Money.from("20000"), Result.of(List.of(Rank.from(5))),"25.0"),
                Arguments.of(Money.from("13000"), Result.of(List.of(Rank.from(5))),"38.5"),
                Arguments.of(Money.from("10000"), Result.of(List.of(Rank.from(5))),"50.0"),
                Arguments.of(Money.from("1000"), Result.of(List.of(Rank.from(5))),"500.0"),
                Arguments.of(Money.from("1000"), Result.of(List.of(Rank.from(5))),"500.0"),
                Arguments.of(Money.from("1000"), Result.of(List.of(Rank.from(5))),"500.0"),
                Arguments.of(Money.from("1000"), Result.of(List.of(Rank.from(4))),"5000.0"),
                Arguments.of(Money.from("1000"), Result.of(List.of(Rank.from(3))),"150000.0"),
                Arguments.of(Money.from("1000"), Result.of(List.of(Rank.from(2))),"3000000.0"),
                Arguments.of(Money.from("1000"), Result.of(List.of(Rank.from(1))),"200000000.0")
        );
    }

    @DisplayName("로또 구매 금액이 비어있으면 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @Test
    void createMoneyByEmptyInput() {
        //given
        String userInput = "";
        //when
        //then
        assertThatThrownBy(() -> Money.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyConstants.EMPTY_MONEY_MSG);
    }

    @DisplayName("로또 구매 금액에 숫자 외 다른 문자가 포함될 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1 "," 1"," 1 ","1 2","1a","1a2","a1b","1가나","가2나","가나1","abc","가나다","a가b나c"})
    void createMoneyWithNotOnlyDigitsButAlsoChar(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> Money.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyConstants.CHARACTER_IN_MONEY_MSG);
    }

    @DisplayName("로또 구매 금액이 1000으로 나눠 떨어지지 않는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1","12","123","1234","0001","0011","0101","10001","1000000001","100300"})
    void createMoneyWithRemainder(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> Money.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyConstants.REMAINDER_IN_MONEY_MSG);
    }

    @DisplayName("로또 구매 금액이 정수 범위를 넘는 경우 이유를 나타내는 메세지를 포함한 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"21474836478","12345678910","1234567891011","1234567891011121314"})
    void createMoneyWithInvalidRange(String userInput) {
        //given
        //when
        //then
        assertThatThrownBy(() -> Money.from(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoneyConstants.INVALID_MONEY_MSG);
    }

    @DisplayName("로또로 얻은 수익에 대한 수익률을 계산한다")
    @ParameterizedTest
    @MethodSource("provideMoneyAndResultAndRateAnswer")
    void calculateProfitRateByResult(Money money, Result result, String rateAnswer) {
        //given
        //when
        assertThat(money.calculateProfitRate(result)).isEqualTo(rateAnswer);
    }
}
