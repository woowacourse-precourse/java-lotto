package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Constant;
import lotto.constant.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceInput {

    public static List<Integer> getLottoNumbers(){

        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER, Constant.LOTTO_SIZE)
        );

        List<Integer> sortedLottoNumbers = sortLottoNumbers(numbers);
        return sortedLottoNumbers;
    }

    private static List<Integer> sortLottoNumbers(List<Integer> numbers){
        Collections.sort(numbers);
        return numbers;
    }

    public static String getInputWinningNumbers() {

        String inputWinningNumbers = Console.readLine();

        if (Validator.isEmpty(inputWinningNumbers)){
            Message.printInputErrorEmpty();
            throw new IllegalArgumentException();
        }

        return inputWinningNumbers;
    }
}
