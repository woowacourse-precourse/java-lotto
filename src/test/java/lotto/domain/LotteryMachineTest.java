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
        String userInput = "3000";
        InputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);

        user.setLotteries(lotteryMachine);
        List<Lotto> userLotteries = user.getLotteries();
        for (int i = 0; i < user.getNumOfLotteries(); ++i) {
            Lotto lotto = userLotteries.get(i);
            assertThat(hasUniqueNumbers(lotto)).isTrue();
            System.out.println(lotto.getNumbers());
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
