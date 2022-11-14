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
class AnswerLottoSystemTest {
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
    @CsvSource(value = {"1,2,3,4,5,6:7"}, delimiterString = ":")
    void 정답_로또_시스템이_정상적으로_메시지를_출력합니다(final String lottoInput, final String bonusNumberInput) {

        var fakeIoSystem = new IoSystemFake(lottoInput, bonusNumberInput);
        var answerLottoSystem = new AnswerLottoSystem(fakeIoSystem);

        answerLottoSystem.generateAnswerLotto();

        var actual = outputStreamCaptor.toString().split("\n");
        var expected = new String[]{"당첨 번호를 입력해 주세요.",
                "보너스 번호를 입력해 주세요."};
        Assertions.assertThat(actual).contains(expected);
    }

}