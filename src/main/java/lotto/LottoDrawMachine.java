package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoDrawMachine {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private Lotto winningNumbers;
    private final int bonusNumber;

    public LottoDrawMachine() throws IllegalArgumentException {
        winningNumbers = createWinningNumbers();
        bonusNumber = createBonusNumber();
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private Lotto createWinningNumbers() throws IllegalArgumentException {
        printWinningNumbersInputStatement();
        String input = Console.readLine();
        throwExceptionWinningNumbers(input);
        List<String> numbersOfString = Arrays.asList(input.split(","));
        return (new Lotto(convertStringListToIntList(numbersOfString, Integer::parseInt)));
    }

    private void printWinningNumbersInputStatement() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void throwExceptionWinningNumbers(String str) throws IllegalArgumentException {
        areNotDigitOrComma(str);
        existsEmptyValue(str);
    }

    private void areNotDigitOrComma(String str) throws IllegalArgumentException {
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (!Character.isDigit(ch) && !isComma(ch)) {
                throw new IllegalArgumentException("[ERROR]: 당첨 번호는 숫자와 ','만 입력이 가능홥니다.");
            }
        }
    }

    private boolean isComma(char ch) {
        return ch == ',';
    }

    private void existsEmptyValue(String str) throws IllegalArgumentException {
        boolean commaFlag = true;
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (commaFlag && isComma(ch)) {
                throw new IllegalArgumentException("[ERROR]: ',' 사이 빈 공간이 존재합니다.");
            }
            commaFlag = isComma(ch);
        }
    }

    private static <String, Integer> List<Integer>
    convertStringListToIntList(List<String> listOfString,
            Function<String, Integer> function) {
        return listOfString.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    private int createBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validate(input);
        return Integer.parseInt(input);
    }

    private void validate(String str) throws IllegalArgumentException {
        isNotAllDigit(str);
        isEmptyNumber(str);
        Integer number = Integer.parseInt(str);
        isNotRange(number);
        duplicateWinningNumbers(number);
    }

    private void isNotAllDigit(String str) throws IllegalArgumentException {
        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("[ERROR]: 보너스 번호는 1개의 숫자만 입력 가능합니다.");
            }
        }
    }

    private void isEmptyNumber(String str) throws IllegalArgumentException {
        if (str.length() == 0) {
            throw new IllegalArgumentException("[ERROR]: 빈 값은 들어올 수 없습니다.");
        }
    }

    private void isNotRange(Integer number) throws IllegalArgumentException {
        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new IllegalArgumentException("[ERROR]: 숫자의 범위는 1 ~ 45까지여야 합니다.");
        }
    }

    private void duplicateWinningNumbers(Integer number) throws IllegalArgumentException {
        if (winningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException("[ERROR]: 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    public void viewPrizes(List<Lotto> lottos) {
        printWinningStatsStatement();
        int[] rankingCount = compareLottos(lottos);
        int earnedMoney = WinningStats(rankingCount);
        printRateOfReturn(earnedMoney, lottos.size());
    }

    private void printWinningStatsStatement() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private int[] compareLottos(List<Lotto> lottos) {
        int[] result = new int[Division.MAX_VALUE + 2];
        Arrays.fill(result, 0);
        lottos.stream().forEach(lotto ->
                result[compareNumbers(lotto)]++);
        return result;
    }

    private int compareNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        long hits = numbers.stream().filter(old ->
                        winningNumbers.getNumbers().contains(old))
                .count();
        boolean bonusBall = numbers.contains(bonusNumber);
        if ((hits > 5) || (hits == 5 && bonusBall)) {
            hits++;
        }
        return (int) hits;
    }

    private int WinningStats(int[] rankingCount) {
        int earnedMoney = 0;
        for (int idx = Division.MIN_VALUE; idx < rankingCount.length; idx++) {
            Division division = Division.of(idx);
            printRanking(rankingCount[idx], division);
            earnedMoney += division.getPrize() * rankingCount[idx];
        }
        return earnedMoney;
    }

    private void printRanking(int count, Division division) {
        String output = String.valueOf(division.getMatchCount()) + "개 일치";
        if (division == Division.SECOND) {
            output += ", 보너스 볼 일치";
        }
        String prize = new DecimalFormat("###,###").format(division.getPrize());
        output += " (" + prize + "원) - " + String.valueOf(count) + "개";
        System.out.println(output);
    }

    private void printRateOfReturn(int earnedMoney, int lottosSize) {
        Double rateOfReturn;
        rateOfReturn = 100.0;
        if (lottosSize != 0) {
            rateOfReturn = (double) earnedMoney / (double) (lottosSize * 1000) * 100.0;
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
