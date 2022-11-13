package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {

    private static final InputValidator inputValidator = new InputValidator();

    @Test
    public void generateUniqueNumbers() {
        User user = new User();
        LotteryMachine lotteryMachine = new LotteryMachine();
//        String userInput = "3000";
//        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
//        System.setIn(inputStream);

        List<Lotto> userLotteries = lotteryMachine.generateLotteries(3);
        assertThat(3).isEqualTo(userLotteries.size());
        for (int i = 0; i < 3; ++i) {
            Lotto lotto = userLotteries.get(i);
            assertThat(hasUniqueNumbers(lotto)).isTrue();
        }
    }

    private boolean hasUniqueNumbers(Lotto lotto) {
        List<Integer> lotteryNumbers = lotto.getNumbers();

        int containCount = 1;
        for (int i = 0; i < lotteryNumbers.size(); ++i) {
            Integer lotteryNumber = lotteryNumbers.get(i);
            long count = lotteryNumbers.stream().filter(number -> lotteryNumber.equals(number)).count();
            if (count != containCount) return false;
        }
        return true;
    }

    @Test
    public void drawLotteries() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            winningNumbersCountTest(new String[]{"1", "2", "3", "4", "5"});
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            winningNumbersInvalidTest(new String[]{"1", "2", "3", "4", "5", "46"});
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            winningNumbersInvalidTest(new String[]{"01", "2", "3", "4", "5", "6"});
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            bonusNumberTest("46", List.of(1, 2, 3, 4, 5, 6));
        });
    }

    private void winningNumbersCountTest(String[] winningNumbersInput) {
        inputValidator.validateWinningNumbers(winningNumbersInput);
    }

    private void winningNumbersInvalidTest(String[] winningNumbersInput) {
        inputValidator.validateWinningNumbers(winningNumbersInput);
    }

    private void bonusNumberTest(String bonusNumberInput, List<Integer> winningNumbers) {
        inputValidator.validateBonusNumber(bonusNumberInput, winningNumbers);
    }
}
