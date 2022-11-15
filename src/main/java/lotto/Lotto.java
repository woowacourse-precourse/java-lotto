package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        checkDuplication(numbers);

        for (Integer number : numbers) {
            checkNumberRange(number);
        }
    }

    public static void validatePayment(String payment) {

        checkIfTheInputIsInteger(payment);

        if (Integer.parseInt(payment) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 떨어지는 숫자를 입력해주세요.");
        }

    }

    private void checkNumberRange(int n) {
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplication(List<Integer> lottoNumbers) {
        HashSet<Integer> hashSet = new HashSet<>(lottoNumbers);

        if (hashSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static List<List<Integer>> generateLottoNumber(int theNumberOfLotto) {
        List<List<Integer>> generatedLottoNumber = new ArrayList<>();
        for (int i = 0; i < theNumberOfLotto; i++) {
            generatedLottoNumber.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return generatedLottoNumber;
    }

    public int checkNumberMatch(int target, int inputNumber) {
        if (target == inputNumber) {
            return 1;
        }
        return 0;
    }

    public int getIndividualLottoScore(List<Integer> lotto, int bonus) {
        int matchCount = 0;

        for (int i = 0; i < 6; i++) {
            if (numbers.contains(lotto.get(i))) {
                matchCount += 1;
            }
//            matchCount += checkNumberMatch(numbers.get(i), lotto.get(i));
        }

        if (matchCount < 3) {
            matchCount = -1;
        }

        if (matchCount == 5 && lotto.contains(bonus)) {
            matchCount = 7;
        }

        return matchCount;
    }

    public List<Integer> calculateLottoResult(List<List<Integer>> generatedLottoNumber, int bonus) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0)); // 3, 4, 5, 6, 5 + b

        for (List<Integer> lotto : generatedLottoNumber) {
            int index = getIndividualLottoScore(lotto, bonus) - 3;
            if (index < 0) {
                continue;
            }
            result.set(index, result.get(index) + 1);
        }

        return result;
    }

    public String calculateYield(List<Integer> result, int totalPayment) {
        List<Integer> prizeValues = new ArrayList<>(List.of(5000, 50000, 1500000, 2000000000, 30000000));
        int totalPrize = 0;

        for (int i = 0; i < 5; i++) {
            totalPrize += prizeValues.get(i) * result.get(i);
        }
        return String.format("%.1f", (double) totalPrize / totalPayment * 100);
    }

    public static int inputTotalPayment() {
        String payment = Console.readLine();
        validatePayment(payment);
        return Integer.parseInt(payment);
    }

    public static int inputBonusNumber() {
        String bonus = Console.readLine();
        return Integer.parseInt(bonus);
    }

    public static List<Integer> inputLottoNumber(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        List<Integer> winningLottoNumber = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String currentDigit = st.nextToken();

            checkIfTheInputIsInteger(currentDigit);

            winningLottoNumber.add(Integer.parseInt(currentDigit));

        }

        return winningLottoNumber;
    }

    public static void checkIfTheInputIsInteger(String digit) {
        if (!digit.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public static void showLottoPaymentReceipt(int totalPayment, List<List<Integer>> generatedLotto) {
        String receipt = "";

        receipt += String.format("%d개를 구매했습니다.\n", totalPayment);

        for (List<Integer> lotto : generatedLotto) {
            receipt = receipt.concat(lotto.toString() + '\n');
        }
        System.out.println(receipt);
    }

    public void showTotalWinningResult(List<Integer> result, String yield) {
        String report = "당첨 통계\n---\n";
        report += String.format("3개 일치 (5,000원) - %d개\n", result.get(0));
        report += String.format("4개 일치 (50,000원) - %d개\n", result.get(1));
        report += String.format("5개 일치 (1,500,000원) - %d개\n", result.get(2));
        report += String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(4));
        report += String.format("6개 일치 (2,000,000,000원) - %d개\n", result.get(3));
        report += "총 수익률은 "+ yield + "%입니다.";
        System.out.println(report);
    }
}
