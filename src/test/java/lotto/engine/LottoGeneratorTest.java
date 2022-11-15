package lotto.engine;

import java.util.List;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {
    private static final int AMOUNT_UNIT = 1_000;
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "금액을 입력하세요";
    private static final String NOT_DIGIT_ERROR_MESSAGE = "금액은 숫자로 입력하세요.";
    private static final String DIVIDE_UNIT_ERROR_MESSAGE = "금액은 1,000원 단위로 입력하세요.";
    private static final String AMOUNT_RANGE_ERROR_MESSAGE = "금액은 100,000원 이하 1000원 이상으로 입력하세요.";

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator(new NextstepNumberGenerator());
    }

    @Nested
    @DisplayName("createLottos 메서드는")
    class DescribeCreateLottos {
        @ParameterizedTest
        @ValueSource(ints = {0, -2_147_483_648})
        @DisplayName("1보다 작은 숫자가 인자로 들어오면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenReceiveLowThanOne(int count) {
            Assertions.assertThatThrownBy(() -> lottoGenerator.createLottos(count))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 3, 5})
        @DisplayName("0보다 큰 숫자가 인자로 들어오면 해당 개수만큼의 Lotto리스트를 반환한다.")
        void returnLottosWhenReceiveBiggerThanZero(int count) {
            List<Lotto> actual = lottoGenerator.createLottos(count);

            Assertions.assertThat(actual.size()).isEqualTo(count);
        }
    }

    @Nested
    @DisplayName("parseToLottoCount 메서드는")
    class DescribeParseToLottoCount {
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("null혹은 빈문자열을 인자로 받으면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenReceiveNullAndEmptySource(String purchasePrice) {
            Assertions.assertThatThrownBy(() -> lottoGenerator.parseToLottoCount(purchasePrice))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(EMPTY_INPUT_ERROR_MESSAGE);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1000j", "abcde"})
        @DisplayName("숫자가 아닌 문자가 포함된 문자열을 인자로 받으면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenReceiveNotDigitString(String purchasePrice) {
            Assertions.assertThatThrownBy(() -> lottoGenerator.parseToLottoCount(purchasePrice))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_DIGIT_ERROR_MESSAGE);
        }

        @ParameterizedTest
        @ValueSource(strings = {"999", "100001", "99999999999999999"})
        @DisplayName("1000원 미만, 10만원 초과의 금액 문자열을 인자로 받으면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenReceiveBiggerAmountLimit(String purchasePrice) {
            Assertions.assertThatThrownBy(() -> lottoGenerator.parseToLottoCount(purchasePrice))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(AMOUNT_RANGE_ERROR_MESSAGE);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1234", "9999"})
        @DisplayName("1000원으로 나누어 떨어지지 않는 금액 문자열을 인자로 받으면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenReceiveNotValidAmountUnit(String purchasePrice) {
            Assertions.assertThatThrownBy(() -> lottoGenerator.parseToLottoCount(purchasePrice))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DIVIDE_UNIT_ERROR_MESSAGE);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1000", "100000", "8000"})
        @DisplayName("1000원으로 나누어 떨어지는 10만원 이하의 금액을 입력으로 받으면 생성되는 로또의 개수를 반환한다.")
        void itReturnCountLottoWhenReceiveValidAmount(String purchasePrice) {
            int expected = Integer.parseInt(purchasePrice) / AMOUNT_UNIT;
            int actual = lottoGenerator.parseToLottoCount(purchasePrice);

            Assertions.assertThat(actual).isEqualTo(expected);
        }
    }
}