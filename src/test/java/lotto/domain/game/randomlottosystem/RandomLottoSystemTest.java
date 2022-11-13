package lotto.domain.game.randomlottosystem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.system.IoSystem;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomLottoSystemTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 사용자가_금액을_입력하면_입력한_금액만큼_랜덤한_로또를_만들어냅니다() {
        var numbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7)
        );
        var randomLottoSystem = new RandomLottoSystem(new IoSystem());
        randomLottoSystem.generateLottoBundle(numbers);

        var actual = outputStreamCaptor.toString();

        var expected = "2개를 구매했습니다.\n"
                + "[1, 2, 3, 4, 5, 6]\n"
                + "[2, 3, 4, 5, 6, 7]\n";
        Assertions.assertThat(actual).isEqualTo(expected);

    }
}