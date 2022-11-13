package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

public class LottoMachine {
    private static final String INPUT_NUMBER_SIZE_ERROR_MESSAGE = "필요한 번호 개수만큼 입력하지 않았습니다.";
    public List<Integer> draw(int length) {
        if(length > 0) {
            List<String> inputs = inputNumber(length);
        }
        return List.of();
    }

    private List<String> inputNumber(int length) {
        List<String> inputs = Arrays.asList(Console.readLine().split(","));
        inputs = inputs.stream().filter(s -> !s.isBlank()).collect(Collectors.toList());

        if(inputs.size() != length){
            Logger.log(INPUT_NUMBER_SIZE_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }

        return inputs;
    }

    private List<Integer> formatStringToNumber(List<String> numbers) {
        return null;
    }

    private void checkNumericString(String number) {
    }

    private void checkAlreadyExistedNumber(List<Integer> numbers, int number) {
    }

    public List<Integer> publish() {
        return null;
    }
}
