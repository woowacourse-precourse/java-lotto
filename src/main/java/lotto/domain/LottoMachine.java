package lotto.domain;

import static lotto.Config.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

public class LottoMachine {
    private static final String INPUT_NUMBER_SIZE_ERROR_MESSAGE = "필요한 번호 개수만큼 입력하지 않았습니다.";
    private static final String NUMERIC_STRING_ERROR_MESSAGE = "숫자 리스트 혹은 숫자 형식으로 입력해 주세요.";
    private static final String ALREADY_EXISTED_NUMBER_ERROR_MESSAGE = "번호가 중복되어 입력되었습니다.";

    public void draw(List<Integer> wins, List<Integer> bonuses) {
        List<Integer> numbers = new ArrayList<>();

        System.out.println("\n당첨 번호를 입력해 주세요.");
        draw(wins, numbers, LOTTO_LENGTH);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        draw(bonuses, numbers, BONUS_LOTTO_LENGTH);
    }

    private void draw(List<Integer> numbers, List<Integer> totalNumbers, int length) {
        if(length > 0) {
            List<String> inputs = inputNumber(length);
            formatStringToNumber(inputs).stream().forEach(number -> {
                checkAlreadyExistedNumber(totalNumbers, number);
                totalNumbers.add(number);
                numbers.add(number);
            });
        }
    }

    private List<String> inputNumber(int length) {
        List<String> inputs = Arrays.asList(Console.readLine().split(","));
        inputs = inputs.stream().filter(s -> !s.isBlank()).map(s -> s.trim()).collect(Collectors.toList());

        if(inputs.size() != length){
            Logger.log(INPUT_NUMBER_SIZE_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }

        return inputs;
    }

    private List<Integer> formatStringToNumber(List<String> inputs) {
        return inputs.stream().map(input -> {
            checkNumericString(input);
            return Integer.parseInt(input);
        }).collect(Collectors.toList());
    }

    private void checkNumericString(String number) {
        if(!number.chars().allMatch(Character::isDigit)){
            Logger.log(NUMERIC_STRING_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private void checkAlreadyExistedNumber(List<Integer> numbers, int number) {
        if(numbers.contains(number)){
            Logger.log(ALREADY_EXISTED_NUMBER_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> publish() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START_NUMBER, LOTTO_RANGE_END_NUMBER, LOTTO_LENGTH);
    }
}
