package lotto.views;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Constant;
import lotto.utils.GameMessage;
import lotto.validation.InputValidation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Input {

    private final InputValidation inputValidation;
    private final Output output;

    public Input() {
        inputValidation = new InputValidation();
        output = new Output();
    }

    public String getUserMoney() {
        output.printGetLottoPrice();

        String question = Console.readLine();

        return question;
    }

    public List<Integer> getWinningNumber() {
        output.printGetWinningNumbers();

        String answer = Console.readLine();
        inputValidation.checkNumber(answer, Constant.REGEX_WINNING_NUMBER_INPUT);
        List<Integer> result = convertToList(answer);
        inputValidation.checkNumberSize(result);
        inputValidation.checkDuplicate(result);
        inputValidation.checkNumberInRange(result);
        sortWinningNumber(result);

        return result;
    }

    public List<Integer> convertToList(String numbers) {
        String[] split = numbers.split(Constant.REGEX_WINNING_NUMBER_INPUT);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            result.add(Integer.parseInt(split[i]));
        }

        return result;
    }

    public void sortWinningNumber(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public String getBonusNumber() {
        output.printGetBonusNumber();

        String answer = Console.readLine();

        return answer;
    }
}
