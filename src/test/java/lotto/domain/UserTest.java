package lotto.domain;

import lotto.service.InputService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class UserTest {

    User user;

    InputService inputService = new InputService();

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DisplayName("입력한 금액이 정상적으로 저장이 된다.")
    class userExceptionTest {
        @ParameterizedTest
        @MethodSource("data")
        void case1(String inputData, int money) {
            inputService.setMoneyToUser(inputData);
            user = inputService.getUser();
            Assertions.assertThat(user.getMoney()).isEqualTo(money);
        }

        Stream<Arguments> data() {
            return Stream.of(
                    Arguments.of("1000", 1000),
                    Arguments.of("100000", 100000),
                    Arguments.of("523000", 523000)
            );
        }
    }
}
