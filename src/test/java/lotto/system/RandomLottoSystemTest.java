package lotto.system;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "30000:30", "100000:100", "9999000:9999"}, delimiterString = ":")
    void 사용자가_금액을_입력하면_입력한_금액만큼_랜덤한_로또를_만들어냅니다(final String moneyInput, final String countInput) {
        var fakeIoSystem = new IoSystemFake(moneyInput);
        var randomLottoSystem = new RandomLottoSystem(fakeIoSystem);

        randomLottoSystem.generateLottoBundle();

        var actual = outputStreamCaptor.toString().split("\n");
        var expected = new String[]{"구입금액을 입력해 주세요.", countInput + "개를 구매했습니다."};
        Assertions.assertThat(actual).contains(expected);
    }
}