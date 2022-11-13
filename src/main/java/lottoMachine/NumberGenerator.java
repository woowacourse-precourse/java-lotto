package lottoMachine;

import static lottoMachine.enums.Numbers.LOTTO_NUMBER_START;
import static lottoMachine.enums.Numbers.LOTTO_NUMBER_END;
import static lottoMachine.enums.Numbers.WINNING_NUMBER_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NumberGenerator {

    private NumberGenerator() {
    }

    public static List<Integer> createRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_START.getValue(), LOTTO_NUMBER_END.getValue(),
                WINNING_NUMBER_SIZE.getValue());
    }
}
