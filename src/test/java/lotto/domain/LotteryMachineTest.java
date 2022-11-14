package lotto.domain;

import lotto.inputValidators.NumberValidator;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {

    private static final User user = new User();
    private static final LotteryMachine lotteryMachine = new LotteryMachine();

    @BeforeEach
    void beforeEach() {
        List<Lotto> lotteries = new ArrayList<>();
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 8)));
        lotteries.add(new Lotto(List.of(1, 2, 9, 4, 5, 8)));
        user.setLotteries(lotteries);
    }

    @AfterEach
    void afterEach() {
        user.setLotteries(null);
    }

    @Test
    public void generateUniqueNumbers() {

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

    @Test
    public void CompileStatisticsTest() {
        lotteryMachine.setWinningLotto(new Lotto(List.of(1,2,3,4,5,6)));
        lotteryMachine.setBonusNumber(7);
        lotteryMachine.showResult(user);
        assertThat(user.getWinningLotteryCounts().get(Result.SIX_NUMBERS_MATCH)).isEqualTo(2);
        assertThat(user.getWinningLotteryCounts().get(Result.FIVE_NUMBERS_AND_BONUS_NUMBER_MATCH)).isEqualTo(1);
        assertThat(user.getWinningLotteryCounts().get(Result.FIVE_NUMBERS_MATCH)).isEqualTo(1);
        assertThat(user.getWinningLotteryCounts().get(Result.FOUR_NUMBERS_MATCH)).isEqualTo(1);

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

    private void winningNumbersCountTest(String[] winningNumbersInput) {
        NumberValidator.validateWinningNumbers(winningNumbersInput);
    }

    private void winningNumbersInvalidTest(String[] winningNumbersInput) {
        NumberValidator.validateWinningNumbers(winningNumbersInput);
    }

    private void bonusNumberTest(String bonusNumberInput, List<Integer> winningNumbers) {
        NumberValidator.validateBonusNumber(bonusNumberInput, winningNumbers);
    }
}
