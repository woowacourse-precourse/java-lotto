package lotto.model.machine;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import lotto.Application;
import lotto.io.Output;
import lotto.io.OutputConsole;
import lotto.model.Money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TicketMachineTest extends NsTest {

    @Nested
    @DisplayName("TicketMachine Class")
    class TicketMachineKoTest {

        @Nested
        @TestInstance(Lifecycle.PER_CLASS)
        @DisplayName("showAllTickets method has")
        class DescribeShowAllTickets {

            @DisplayName("valid input of")
            @ParameterizedTest(name = "{1}")
            @MethodSource("validParameters")
            void showAllTickets(String input, String message, Long count) {
                assertSimpleTest(() -> {

                    Output output = new OutputConsole();
                    TicketMachine ticketMachine = new TicketMachine(new Money(input));
                    ticketMachine.generateTickets();
                    ticketMachine.showAllTickets(output);

                    assertThat(output()).contains(count+"개를 구매했습니다.");

                });

            }

            Stream<Arguments> validParameters() throws Throwable {
                return Stream.of(
                    Arguments.of("0", "0", 0L),
                    Arguments.of("3000", "3000", 3L),
                    Arguments.of("6000", "6000", 6L),
                    Arguments.of("9000", "9000", 9L),
                    Arguments.of("12000", "12000", 12L)
                );
            }
        }
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
