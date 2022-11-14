package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GenerateLottoTest {
    GenerateLotto generateLotto;
    private static final int UNIT = 1000;
    static Stream<Arguments> LottoTickets() {
        return Stream.of(
                Arguments.arguments(1000, 1),
                Arguments.arguments(5000, 5),
                Arguments.arguments(47000, 47)
        );
    }

    @ParameterizedTest(name="입력 금액만큼의 로또 발행 확인")
    @MethodSource("LottoTickets")
    void setLottoTest(int input, int size) {
        generateLotto = new GenerateLotto();
        List<Lotto> newLotto = generateLotto.setLotto(input/UNIT);
        assertEquals(newLotto.size(), size);
    }
}