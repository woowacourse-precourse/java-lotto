package lotto.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {

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
}
