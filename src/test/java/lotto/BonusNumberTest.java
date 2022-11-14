package lotto;

import lotto.model.BonusNumber;
import lotto.view.OutputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {

    List<Integer> winningNumber = new ArrayList(List.of("1,2,3,4,5,6"));
    static OutputView outputView;
    static OutputStream outputStream;

    @BeforeAll
    static void setup() {

        outputView = new OutputView();
    }

    void initOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }


    @DisplayName("보너스 번호가 당첨 번호와 중복된 숫자면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicatedNumber() {
        initOutputStream();
        BonusNumber bonusNumber = new BonusNumber("1", winningNumber);
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("보너스 번호의 값이 45보다 큰 값이면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverLimit() {
        initOutputStream();
        BonusNumber bonusNumber = new BonusNumber("46", winningNumber);
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("보너스 번호의 값이 1보다 작은 값이면 예외가 발생한다.")
    @Test
    void createBonusNumberByUnderLimit() {
        initOutputStream();
        BonusNumber bonusNumber = new BonusNumber("0", winningNumber);
        assertThat(outputStream.toString()).contains("[ERROR]");
    }

    @DisplayName("보너스 번호에 규격 이외의 값이 들어가면 예외가 발생한다.")
    @Test
    void createBonusNumberByInvalidValue() {
        initOutputStream();
        BonusNumber bonusNumber = new BonusNumber("이상한값", winningNumber);
        assertThat(outputStream.toString()).contains("[ERROR]");
    }
}
