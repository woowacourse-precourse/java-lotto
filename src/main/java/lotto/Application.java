package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Integer numberOfLottoes;
        List<Lotto> lottoes;
        List<Integer> winningNumbers;
        Integer bonus;

        System.out.println("구입금액을 입력해 주세요.");
        numberOfLottoes =
                getTheNumberOfLottoesAsMuchThePurchaseAmount(
                        Integer.parseInt(Console.readLine())
                );
        System.out.println(numberOfLottoes + "개를 구매했습니다.");

        lottoes = createLottoes(numberOfLottoes);
        printLottoes(lottoes);

        System.out.println("당첨 번호를 입력해 주세요.");
        winningNumbers = getWinningNumbers(Console.readLine());
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = getBonus(Console.readLine());
    }

    public static Integer getTheNumberOfLottoesAsMuchThePurchaseAmount(Integer purchaseAmount) {
        validateNumber(purchaseAmount);
        validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / 1000;
    }

    public static List<Lotto> createLottoes(Integer numberOfLottoes) {
        List<Lotto> lottoes = new ArrayList<>();

        for (int i = 0; i < numberOfLottoes; i++) {
            lottoes.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoes;
    }

    public static List<Integer> parseIntegerList(String numberText) {
        return Arrays.stream(numberText.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> getWinningNumbers(String numberText) {
        List<Integer> winningNumbers = parseIntegerList(numberText);

        validateSize(winningNumbers);
        validateNumbers(winningNumbers);
        validateRanges(winningNumbers);
        validateDuplicatedNumber(winningNumbers);

        return winningNumbers;
    }

    public static Integer getBonus(String numberText) {
        List<Integer> bonus = parseIntegerList(numberText);

        validateBonus(bonus);
        validateNumbers(bonus);
        validateRanges(bonus);

        return bonus.get(0);
    }

    public static void printLottoes(List<Lotto> lottoes){
        for (int i = 0; i < lottoes.size(); i++) {
            lottoes.get(i).display();
        }
    }

    public static void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액이 1000의 배수가 아닙니다.");
        }
    }

    public static void validateNumber(Integer number) {
        if (number > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] Integer.MAX_VALUE 보다 큰 값을 입력할 수 없습니다.");
        }
        if (number < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("[ERROR] Integer.MIN_VALUE 보다 작은 값을 입력할 수 없습니다.");
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateNumber(numbers.get(i));
        }
    }

    public static void validateRange(Integer number) {
        if (number > 45) {
            throw new IllegalArgumentException("[ERROR] 45보다 큰 수를 입력할 수 없습니다.");
        }
        if (number < 1) {
            throw new IllegalArgumentException("[ERROR] 1보다 작은 수를 입력할 수 없습니다.");
        }
    }

    public static void validateRanges(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateRange(numbers.get(i));
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 보다 많이 입력할 수 없습니다.");
        }
        if (numbers.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 보다 적게 입력할 수 없습니다.");
        }
    }

    public static void validateBonus(List<Integer> numbers) {
        if (numbers.size() > 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 1개 보다 많이 입력할 수 없습니다.");
        }
        if (numbers.size() < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력하지 않았습니다.");
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호는 허용되지 않습니다.");
        }
    }
}
