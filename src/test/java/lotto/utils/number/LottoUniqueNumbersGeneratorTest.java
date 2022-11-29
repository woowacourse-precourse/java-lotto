package lotto.utils.number;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.consts.LottoConst;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

class LottoUniqueNumbersGeneratorTest {

    private final LottoNumbersGenerator generator = new LottoUniqueNumbersGenerator(
            LottoConst.MIN_NUMBER_VALUE,
            LottoConst.MAX_NUMBER_VALUE);

    @Nested
    @DisplayName("generate 메소드는")
    class DescribeGenerateMethodTest {

        @Nested
        @DisplayName("생성해야 할 size를 전달하면")
        class ContextWithSizeTest {

            @RepeatedTest(10)
            @DisplayName("size만큼의 중복되지 않은 랜덤 숫자를 반환한다")
            void it_returns_uniqueRandomNumbers() {
                List<Integer> uniqueNumbers = generator.generate(LottoConst.NUMBER_SIZE);

                assertThat(uniqueNumbers)
                        .allSatisfy(number -> uniqueNumberTest(uniqueNumbers, number));
            }

            private void uniqueNumberTest(List<Integer> uniqueNumbers, int number) {
                assertThat(number)
                        .isGreaterThanOrEqualTo(LottoConst.MIN_NUMBER_VALUE)
                        .isLessThanOrEqualTo(LottoConst.MAX_NUMBER_VALUE);

                assertThat(uniqueNumbers)
                        .containsOnlyOnce(number);
            }
        }
    }
}