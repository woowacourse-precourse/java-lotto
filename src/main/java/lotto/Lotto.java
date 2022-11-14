package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.w3c.dom.ls.LSOutput;

public class Lotto {
    private final List<Integer> numbers;
    private static final String ERROR = "[ERROR] ";
    private static final String INVALID_WINNING_NUMBER_LENGTH_ERROR = "당첨 번호는 6개의 숫자만 입력 가능합니다.";
    private static final String INVALID_LOTTO_NUMBERS = "당첨 번호는 정수만 입력 가능합니다.";
    private static final String WINNING_LOTTO = "당첨 번호를 입력해주세요.";
    private static final String NEGATIVE_PRICE_ERROR = "음수인 금액은 입력할 수 없습니다.";
    private static final String PUT_BONUS_NUMBER = "보너스 번호를 입력해주세요";
    public static int bonusNum;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    // 우승 숫자 입력받기
    public static List<Integer> inputLotto(List<Integer> lotto) {
        System.out.println(WINNING_LOTTO);
        String num = Console.readLine();
        String[] inputNum = num.split(",");
        try {
            for (int i = 0; i < inputNum.length; i++) {
                lotto.add(Integer.parseInt(inputNum[i]));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + INVALID_LOTTO_NUMBERS);
        }
        Validator.validateWinningNumberInput(inputNum); // 6자리인지 확인

        return lotto;
    }


    // 보너스 번호 입력받기
    public static int bonusNum() {
        System.out.println(PUT_BONUS_NUMBER);
        String bonus = Console.readLine();
        try {
            bonusNum = Integer.parseInt(bonus);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS);
        }

        return bonusNum;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR + INVALID_WINNING_NUMBER_LENGTH_ERROR);
        }
        if (validateDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 중복되지 않아야 합니다.");
        }
        if (validateRange(numbers)) {
            throw new IllegalArgumentException(ERROR + "로또 번호는 1부터 45 사이의 숫자입니다.");
        }

    }

    // 로또 중복 확인
    static boolean validateDuplicate(List<Integer> numbers) {
        for (int a : numbers) {
            if (numbers.indexOf(a) != numbers.lastIndexOf(a)) {
                return true;
            }
        }
        return false;
    }


    // 1부터 45까지의 수
    static boolean validateRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45){
                return true;
            }
        }

        return false;
    }

}