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

    public boolean checkForBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
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
    enum PrizeMoney {
        WIN(2000000000),
        SECOND(30000000),
        THIRD(1500000),
        FOURTH(50000),
        FIFTH(5000);
        private final int prize;
        PrizeMoney(int prize) { this.prize = prize; }
        public int getValue() { return prize; }

    }

    private static List<Lotto> purchasedLottos;
    private static int[] winningCounts = new int[5];

    public static void proceedSystem() {
        PrintedGuidance.requestPayment();
        purchaseLotto(UserInput.requestPayment());

        PrintedGuidance.requestWinningNumber();
        Lotto winningNumber = new Lotto(UserInput.requestWinningLottoNumber());
        PrintedGuidance.requestBonusNumber();
        int bonusNumber = UserInput.requestBonusNumber();

        checkWinningStatus(winningNumber,bonusNumber);

    }

    public static void purchaseLotto(int paymentMoney) {
        validatePayment(paymentMoney);

        purchasedLottos = new ArrayList<>();
        int purchasedLottoCount = paymentMoney/1000;
        PrintedGuidance.guideLottoPurchaseCount(purchasedLottoCount);
        for (int i = 0; i < purchasedLottoCount; i++) {
            purchasedLottos.add(makeLotto());
        }
        for (Lotto lotto : purchasedLottos) {
            lotto.printLottoNumber();
        }
    }

    private static Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static void checkWinningStatus(Lotto winningNumber, int bonusNumber) {
        validateBonusNumber(winningNumber,bonusNumber);

        for (Lotto lotto : purchasedLottos) {
            winningCounts[lotto.checkWinning(winningNumber)]++;

        }





    }

    private static void validatePayment(int paymentMoney) {
        if (paymentMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원단위로 구매가 가능합니다." +
                    "지불 금액을 다시확인해 주세요.");
        }
    }
    private static void validateBonusNumber(Lotto winningNumber, int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자입니다.");
        }
        if(winningNumber.checkForBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함되지 않아야 합니다.");
        }
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

class PrintedGuidance {

    private final static String REQUEST_PAYMENT = "구입금액을 입력해 주세요.";
    private final static String REQUEST_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String GUIDE_LOTTO_COUNT = "개를 구매했습니다.";

    public static void requestPayment() {
        System.out.println(REQUEST_PAYMENT);
    }
    public static void requestWinningNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
    }
    public static void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }
    public static void guideLottoPurchaseCount(int count) {
        System.out.println(count + GUIDE_LOTTO_COUNT);
    }

    public static void printResult(int three, int four, int five, int five_b, int six, int totalRate) {
        System.out.println("3개 일치 (5,000원) - " + three + "개");
        System.out.println("4개 일치 (50,000원) - " + four + "개");
        System.out.println("5개 일치 (150,000원) - " + five + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + five_b + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + six + "개");
        System.out.println("총 수익률은 " + totalRate + "%입니다.");
    }
}



