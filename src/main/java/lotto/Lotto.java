package lotto;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLotto(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    public int checkWinning(Lotto winningLotto){
        int winningCount = 0;
        for (int number : numbers) {
            if (winningLotto.numbers.contains(number)) {
                winningCount++;
            }
        }
        return winningCount;
    }

    public void printLottoNumber() {
        System.out.println(numbers);
    }



    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자입니다.");
        }
    }
    private void validateLotto(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
            if (countSameNumber(numbers,number) > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }
    }
    private static void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자입니다.");
        }
    }

    private int countSameNumber(List<Integer> numbers, int standardNumber) {
        int count = 0;
        for (int number : numbers) {
            if (number == standardNumber) {
                count++;
            }
        }
        return count;
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers){
        List<Integer> sortedNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            sortedNumbers.add(number);
        }
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }
}




class LottoSystem {

    private static List<Lotto> lottos;

    public static void purchaseLotto(int paymentMoney) {
        if (paymentMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원단위로 구매가 가능합니다." +
                    "지불 금액을 다시확인해 주세요.");
        }

        lottos = new ArrayList<>();
        int purchasedLottoCount = paymentMoney/1000;
        for (int i = 0; i < purchasedLottoCount; i++) {
            lottos.add(makeLotto());
        }
    }

    private static Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }


}

class UserInput {

    static public int requestPayment() {
        String userInput = Console.readLine();
        isNumeric(userInput);

        return Integer.parseInt(userInput);
    }

    static public List<Integer> requestWinningLottoNumber() {
        String userInput = Console.readLine();
        String[] splitUserInput = userInput.split(",");
        List<Integer> numbers = new ArrayList<Integer>();

        for (String number : splitUserInput) {
            isNumeric(number);
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }

    static public int requestBonusNumber() {
        String userInput = Console.readLine();
        isNumeric(userInput);

        return Integer.parseInt(userInput);
    }

    private static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 내용이 숫자가 아닙니다.");
        }
    }
}




