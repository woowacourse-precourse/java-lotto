package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domian.statistics.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class LottoView {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int THOUSAND_WON = 1000;
    private static final int ZERO = 0;
    private static final int LOTTO_SIZE = 6;

    final String REGEX_1 = "^[0-9]*?";
    final String REGEX_2 = "^[0-9,]*?";

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        validateMoney(money);
        return Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        checkOnlyNumber(money);

        if (Integer.parseInt(money) % THOUSAND_WON != ZERO) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private void checkOnlyNumber(String money) {
        if (!money.matches(REGEX_1)) {
            System.out.println("[ERROR] 형식에 맞는 값을 입력해야 합니다.");
            throw new NoSuchElementException();
        }
    }

    public List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        checkOnlyNumberAndComma(winningNumber);
        List<Integer> numbers = Arrays.stream(winningNumber.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        validateWinningNumber(numbers);
        return numbers;
    }

    private void checkOnlyNumberAndComma(String winningNumber) {
        if (!winningNumber.matches(REGEX_2)) {
            System.out.println("[ERROR] 형식에 맞는 값을 입력해야 합니다.");
            throw new NoSuchElementException();
        }
    }

    private void validateWinningNumber(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호의 개수가 6개가 아닙니다.");
        }

        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호에 중복값이 존재합니다.");
        }

        for (int number : numbers) {
            if (validateNumberRange(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    public int getBonusNumber(List<Integer> numbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        checkOnlyNumber(inputBonusNumber);
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        validateBonusNumber(numbers, bonusNumber);
        return bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복돼선 안 됩니다.");
        }

        if (validateNumberRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private boolean validateNumberRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    public void printStatisticsPhrase() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printRateOfReturn(double profit) {
        System.out.println("총 수익률은 " + profit + "%입니다.");
    }

    public void printNumberOfEachGrade(String phrase, int countGrade) {
        System.out.println(phrase + countGrade + '개');
    }

    public void printLottosNumbers(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }
}
