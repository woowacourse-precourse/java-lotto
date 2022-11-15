package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Stream;

class WinningLottoTest {
    OutputStream out = new ByteArrayOutputStream();
    InputStream in = System.in;

    @BeforeEach
    private final void init() {
        System.setOut(new PrintStream(out));
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("정답 로또로 채점할 때")
    class Grade {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 정답_로또로_다른_로또를_채점할_때를_테스트한다(String source, Lotto target, int expected) {
            ByteArrayInputStream in = new ByteArrayInputStream(source.getBytes());
            System.setIn(in);
            WinningLotto winningLotto = new WinningLotto();

            assertThat(winningLotto.grade(target)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of("1,2,3,4,5,6", new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
                    Arguments.of("1,2,3,4,5,6", new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), 3),
                    Arguments.of("1,2,3,4,5,6", new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)), 0)
                    );
        }
    }

}