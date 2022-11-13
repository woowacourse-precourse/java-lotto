package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private static final String ERROR = "[ERROR] ";
    private static final String INVALID_WINNING_NUMBER_LENGTH_ERROR = "당첨 번호는 6개의 숫자만 입력 가능합니다.";
    private static final String INVALID_LOTTO_NUMBERS = "당첨 번호는 정수만 입력 가능합니다.";
    private static final String WINNING_LOTTO = "당첨 번호를 입력해주세요.";
    private static final String NEGATIVE_PRICE_ERROR = "음수인 금액은 입력할 수 없습니다.";
    private static final String NOT_INTEGER_ERROR = "정수가 아닌 문자열이 입력되었습니다.";


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    // 우승 숫자 입력받기
    public static List<Integer> inputLotto(List<Integer> lotto){
        System.out.println(WINNING_LOTTO);
        String num = Console.readLine();
        String [] inputNum = num.split(",");
        Validator.validateWinningNumberInput(inputNum); // 6자리인지 확인
        try {
            for (int i = 0; i < inputNum.length; i++) {
                lotto.add(Integer.parseInt(inputNum[i]));
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }

        return lotto;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(ERROR + INVALID_WINNING_NUMBER_LENGTH_ERROR);
        }

    }

}