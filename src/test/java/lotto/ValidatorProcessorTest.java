package lotto;

import lotto.domain.enummodel.LottoEnum;
import lotto.domain.enummodel.PriceEnum;
import lotto.domain.processor.ValidatorProcessor;
import lotto.domain.processor.ValidatorProcessorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorProcessorTest {

    private ValidatorProcessor validatorProcessor;

    @TestFactory
    @DisplayName("ValidatorProcessor validateMoney Test")
    Stream<DynamicTest> ValidatorProcessorValidateMoneyTest() {
        validatorProcessor = new ValidatorProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("금액이 나눠떨어지는 경우 통과", () -> {
                    final Integer money = 1000;
                    validatorProcessor.validateMoney(money, PriceEnum.LOTTO_PRICE);
                }),
                DynamicTest.dynamicTest("금액이 나눠떨어지지 않는경우 예외를 던져준다.", () -> {
                    final Integer money = 500;

                    assertThatThrownBy(() -> validatorProcessor.validateMoney(money, PriceEnum.LOTTO_PRICE))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("금액 단위를 일치시켜야 합니다.");
                }),
                DynamicTest.dynamicTest("금액이 나눠떨어지지 않는경우 예외를 던져준다.", () -> {
                    final Integer money = 1500;

                    assertThatThrownBy(() -> validatorProcessor.validateMoney(money, PriceEnum.LOTTO_PRICE))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("금액 단위를 일치시켜야 합니다.");
                })
        );
    }

    @TestFactory
    @DisplayName("validateAndParseLottoNumberInput Test")
    Stream<DynamicTest> validateAndParseLottoNumberInputTest() {
        validatorProcessor = new ValidatorProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("입력값이 유요한경우 통과", () -> {
                    final String input = "1,2,3,4,5,6";
                    List<Integer> result = validatorProcessor.validateAndParseLottoNumberInput(input);

                    assertThat(result.size()).isEqualTo(LottoEnum.LOTTO.getSize());
                }),
                DynamicTest.dynamicTest("입력이 잘못된 경우 예외를 던져준다.", () -> {
                    final String input = "1,2,3,4,5,r";

                    assertThatThrownBy(() -> validatorProcessor.validateAndParseLottoNumberInput(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("잘못된 입력값 입니다.");
                })
        );
    }

    @TestFactory
    @DisplayName("ValidatorProcessor validateLottoSize Test")
    Stream<DynamicTest> ValidatorProcessorValidateLottoSizeTest() {
        validatorProcessor = new ValidatorProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("입력 길이가 일치하는 경우 통과", () -> {
                    final Integer size = 6;

                    validatorProcessor.validateLottoSize(size, LottoEnum.LOTTO);
                }),
                DynamicTest.dynamicTest("입력이 다른경우 예외를 던져준다.", () -> {
                    final Integer size = 5;

                    assertThatThrownBy(() -> validatorProcessor.validateLottoSize(size, LottoEnum.LOTTO))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력 길이가 다릅니다.");
                }),
                DynamicTest.dynamicTest("입력이 다른경우 예외를 던져준다.", () -> {
                    final Integer size = 7;

                    assertThatThrownBy(() -> validatorProcessor.validateLottoSize(size, LottoEnum.LOTTO))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력 길이가 다릅니다.");
                })
        );
    }

    @TestFactory
    @DisplayName("ValidatorProcessor validateLottoNumber Test")
    Stream<DynamicTest> validateLottoNumberTest() {
        validatorProcessor = new ValidatorProcessorImpl();

        return Stream.of(
                DynamicTest.dynamicTest("알맞은 번호 목록을 가지고있는경우 통과한다.", () -> {
                    final List<Integer> numberList = List.of(1,2,3,4,5,45);

                    validatorProcessor.validateLottoNumber(numberList, LottoEnum.LOTTO);
                }),
                DynamicTest.dynamicTest("번호 목록에 범위가 더 큰 숫자가 들어있는경우 예외를 던져준다", () -> {
                    final List<Integer> numberList = List.of(-1,2,3,4,5,6);

                    assertThatThrownBy(() -> validatorProcessor.validateLottoNumber(numberList, LottoEnum.LOTTO))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력 숫자의 범위가 다릅니다.");
                }),
                DynamicTest.dynamicTest("번호 목록에 범위가 더 작은 숫자가 들어있는경우 예외를 던져준다", () -> {
                    final List<Integer> numberList = List.of(1,2,3,4,5,46);

                    assertThatThrownBy(() -> validatorProcessor.validateLottoNumber(numberList, LottoEnum.LOTTO))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("입력 숫자의 범위가 다릅니다.");
                })
        );
    }
}
