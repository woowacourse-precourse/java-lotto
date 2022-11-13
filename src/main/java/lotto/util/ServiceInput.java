package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Constant;
import lotto.constant.Message;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<Integer> getWinningNumbers(){

        List<String> splitInputWinningNumbers = getSplitInputWinningNumbers();

        List<Integer> winningNumbers = new ArrayList<>();
        for (int i=0; i<splitInputWinningNumbers.size(); i++){
            winningNumbers.add(Converter.StringToInteger(splitInputWinningNumbers.get(i)));
        }

        // TODO: 예외처리 구현

        return winningNumbers;
    }

    private static String getInputWinningNumbers() {

        String inputWinningNumbers = Console.readLine();

        if (Validator.isEmpty(inputWinningNumbers)){
            Message.printInputErrorEmpty();
            throw new IllegalArgumentException();
        }

        if (Validator.isNotComma(inputWinningNumbers)){
            Message.printInputErrorIsNotComma();
            throw new IllegalArgumentException();
        }

        return inputWinningNumbers;
    }

    private static List<String> getSplitInputWinningNumbers(){

        String inputWinningNumbers = getInputWinningNumbers();
        List<String> splitInputWinningNumbers = Arrays.asList(inputWinningNumbers.split("\\s*,\\s*"));

        if (Validator.isListhasCharacter(splitInputWinningNumbers)){
            Message.printInputErrorHasCharacter();
            throw new IllegalArgumentException();
        }

        return splitInputWinningNumbers;
    }
}
