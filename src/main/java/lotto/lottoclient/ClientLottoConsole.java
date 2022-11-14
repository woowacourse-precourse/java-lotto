package lotto.lottoclient;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.exception.ErrorResponse.BAD_INPUT_STRING;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ClientLottoConsole implements LottoConsole {

    @Override
    public List<Integer> inputAnswerNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String answerNumber = Console.readLine();
        try {
            return getAnswerNumbers(answerNumber);
        } catch (Exception exception) {
            throw BAD_INPUT_STRING.exception();
        }
    }

    private List<Integer> getAnswerNumbers(String answerNumber) {
        String[] numbers = answerNumber.split(",");
        if (isNotVerifiedInputNumbers(numbers)) {
            throw BAD_INPUT_STRING.exception();
        }
        List<Integer> answerNumbers = new ArrayList<>();
        for (String number : numbers) {
            answerNumbers.add(Integer.parseInt(number));
        }
        return answerNumbers;
    }

    private static boolean isNotVerifiedInputNumbers(String[] numbers) {
        return numbers.length != LOTTO_NUMBER_COUNT.getValue();
    }

    @Override
    public Integer inputAnswerBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception exception) {
            throw BAD_INPUT_STRING.exception();
        }
    }
}
