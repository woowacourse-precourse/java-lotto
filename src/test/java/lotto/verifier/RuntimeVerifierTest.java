package lotto.verifier;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;
import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class RuntimeVerifierTest {
    OutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public final void init() {
        System.setOut(new PrintStream(out));
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("checkBonusNumberExistsInWinningLotto 메소드 테스트")
    class CheckBonusNumberExistsInWinningLotto {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 보너스번호가_당첨번호에_포함되는_경우_에러를_발생시키는지_테스트(String winning, String bonus) {
            final byte[] buf = String.join("\n", winning, bonus).getBytes();
            System.setIn(new ByteArrayInputStream(buf));

            WinningLotto winningLotto = new WinningLotto();
            BonusNumber bonusNumber = new BonusNumber();
            RuntimeVerifier runtimeVerifier = new RuntimeVerifier();

            assertThatThrownBy(() ->
                    runtimeVerifier.checkBonusNumberExistsInWinningLotto(bonusNumber, winningLotto))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.BONUS_NUMBER_EXISTS_IN_WINNING_LOTTO);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of("7,8,9,10,11,12", "7"),
                    Arguments.of("4,7,8,9,10,11", "4"),
                    Arguments.of("1,2,7,8,9,10", "10")

            );
        }
    }
}
