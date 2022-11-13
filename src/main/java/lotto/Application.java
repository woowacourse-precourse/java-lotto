package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.EnumMap;

public class Application {
    enum NumberType { WINNING, BONUS, NONE };
    enum Places { FIRST, SECOND, THIRD, FOURTH, FIFTH };

    static NumberType[] numberTypeCheck = new NumberType[46];
    static Map<Places, Integer> noOfLottoIn = new EnumMap<>(Places.class);
    static int noOfLottos;

    public static void guideWinningNumberFormat() { System.out.print("당첨 번호 6개를 쉼표로 구분해 입력해주세요: "); }

    public static void isVoidInput(String numberInput) {
        if (numberInput.length() == 0)
            throw new IllegalArgumentException("문자를 입력하십시오.");
    }

    public static boolean isComma(char charAtIndex) { return charAtIndex == ','; }

    public static boolean isNumber(char charAtIndex) { return (charAtIndex >= '0' && charAtIndex <= '9'); }

    public static void isInputCommaAndNumber(String numberInput) {
        int inputLength = numberInput.length();
        for (int index = 0; index < inputLength; index++) {
            char charAtIndex = numberInput.charAt(index);
            if (isComma(charAtIndex)) continue;
            if (isNumber(charAtIndex)) continue;
            throw new IllegalArgumentException("쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
        }
    }

    public static void hasSixNumbers(String[] winningNumbers) {
        if (winningNumbers.length != 6)
            throw new IllegalArgumentException("당첨 번호는 쉼표로 구분되는 6개의 수로 구성돼야 합니다.");
    }

    public static List<Integer> parseNumbers(String[] splitNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberInString : splitNumbers) {
            int numberInInteger = Integer.parseInt(numberInString);
            winningNumbers.add(numberInInteger);
        }
        return winningNumbers;
    }

    public static void checkRange(List<Integer> numbers) {
        for (int number : numbers)
            if (number > 45 || number < 1)
                throw new IllegalArgumentException("당첨 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    public static void isDuplicated(List<Integer> winningNumbers) {
        boolean[] isWinningNumber = new boolean[46];
        for (int number : winningNumbers) {
            if (isWinningNumber[number])
                throw new IllegalArgumentException("당첨 번호엔 중복된 숫자가 없어야 합니다.");
            isWinningNumber[number] = true;
        }
    }

    public static void checkNumberTypeByIndex(List<Integer> winningNumbers) {
        for (int number = 1; number <= 45; number++)
            numberTypeCheck[number] = NumberType.NONE;
        for (int number : winningNumbers)
            numberTypeCheck[number] = NumberType.WINNING;
    }

    public static void getWinningNumbers() {
        guideWinningNumberFormat();
        String winningNumberInput = Console.readLine();

        isVoidInput(winningNumberInput);
        isInputCommaAndNumber(winningNumberInput);

        String[] splitNumbers = winningNumberInput.split(",");
        hasSixNumbers(splitNumbers);

        List<Integer> winningNumbers = parseNumbers(splitNumbers);
        checkRange(winningNumbers);
        isDuplicated(winningNumbers);
        checkNumberTypeByIndex(winningNumbers);
    }

    public static void guideBonusNumberFormat() {
        System.out.print("당첨 번호가 아닌 1이상 45이하의 숫자를 보너스 번호로 입력해주세요: ");
    }

    public static void isInputNumber(String numberInput) {
        int inputLength = numberInput.length();
        for (int index = 0; index < inputLength; index++) {
            char charAtIndex = numberInput.charAt(index);
            if (isNumber(charAtIndex)) continue;
            throw new IllegalArgumentException("숫자 외 다른 문자는 입력이 불가합니다.");
        }
    }

    public static void isDuplicatedWithWinningNumbers(NumberType[] numberTypeCheck, List<Integer> bonusNumber) {
        int bonus = bonusNumber.get(0);
        if (numberTypeCheck[bonus] == NumberType.WINNING)
            throw new IllegalArgumentException("당첨번호가 아닌 다른 보너스 번호를 입력하십시오.");
    }

    public static void getBonusNumber() {
        guideBonusNumberFormat();
        String bonusNumberInput = Console.readLine();

        isVoidInput(bonusNumberInput);
        isInputNumber(bonusNumberInput);

        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(Integer.parseInt(bonusNumberInput));
        checkRange(bonusNumber);
        isDuplicatedWithWinningNumbers(numberTypeCheck, bonusNumber);
        numberTypeCheck[bonusNumber.get(0)] = NumberType.BONUS;
    }

    public static void guidePurchasePriceFormat() {
        System.out.println("구매 금액(원 단위)을 1000의 배수로 입력해 주세요(최대 20억원)");
    }

    public static void isDividedBy1000(Long purchasePrice) {
        if (purchasePrice % 1000 != 0)
            throw new IllegalArgumentException("금액을 1000원 단위로 입력해주세요.");
    }

    public static void isLargerThan2billion(Long purchasePrice) {
        if (purchasePrice > 2_000_000_000)
            throw new IllegalArgumentException("1등 당첨금보다 더 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    public static void getNoOfLotto() {
        guidePurchasePriceFormat();
        String purchasePriceInput = Console.readLine();

        isVoidInput(purchasePriceInput);
        isInputNumber(purchasePriceInput);

        long purchasePrice = Long.parseLong(purchasePriceInput);
        isDividedBy1000(purchasePrice);
        isLargerThan2billion(purchasePrice);

        noOfLottos = (int)(purchasePrice / 1000);
    }

    public static void printNoOfPurchasedLottos() {
        System.out.printf("%d개를 구매했습니다.\n", noOfLottos);
    }

    public static void generateLottoNumbers() {
        for (int no = 0; no < noOfLottos; no++) {
            List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            new Lotto(pickedNumbers);
        }
    }

    public static void getComparisonResults() {
        // TODO: implement method to compare purchased Lottos and winning & bonus numbers
    }

    public static void printLottoResults() {
        // TODO: implement method to print result of comparison between winning numbers and purchased Lottos
    }

    public static void printEarningsRate() {
        // TODO: implement method to print earnings rate
    }

    public static void main(String[] args) {
        getWinningNumbers();
        getBonusNumber();

        getNoOfLotto();
        printNoOfPurchasedLottos();
        generateLottoNumbers();

        getComparisonResults();
        printLottoResults();
        printEarningsRate();
    }
}