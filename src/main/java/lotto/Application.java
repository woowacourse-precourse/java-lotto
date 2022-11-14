package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;
import java.util.EnumMap;

public class Application {
    enum NumberType { WINNING, BONUS, NONE };
    enum Places { FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE };

    static NumberType[] numberType = new NumberType[46];
    static public Map<Places, Integer> noOfLottoWinAt = new EnumMap<>(Places.class);
    static public Map<Places, Long> prizesAt = new EnumMap<>(Places.class);

    static List<List<Integer>> purchasedLottos = new ArrayList<>();
    static int noOfLottos;
    static Lotto winningNumbers;

    public static void initializeNumberType() {
        for (int number = 1; number <= 45; number++)
            numberType[number] = NumberType.NONE;
    }

    public static void initializeNoOfLottoWinAt() {
        for (Places place: Places.values())
            noOfLottoWinAt.put(place, 0);
    }

    public static void initializePrizesAtPlaces() {
        prizesAt.put(Places.FIFTH, 5_000L);
        prizesAt.put(Places.FOURTH, 50_000L);
        prizesAt.put(Places.THIRD, 1_500_000L);
        prizesAt.put(Places.SECOND, 30_000_000L);
        prizesAt.put(Places.FIRST, 2_000_000_000L);
        prizesAt.put(Places.NONE, 0L);
    }

    public static void guidePurchasePriceFormat() {
        System.out.println("구매 금액(원 단위)을 1000의 배수로 입력해 주세요(최대 20억원).");
    }

    public static void isVoidInput(String numberInput) {
        if (numberInput.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 문자를 입력하십시오.");
        }
    }

    public static boolean isNumber(char charAtIndex) { return (charAtIndex >= '0' && charAtIndex <= '9'); }

    public static void isInputNumber(String numberInput) {
        int inputLength = numberInput.length();
        for (int index = 0; index < inputLength; index++) {
            char charAtIndex = numberInput.charAt(index);
            if (isNumber(charAtIndex)) continue;
            throw new IllegalArgumentException("[ERROR] 숫자 외 다른 문자는 입력이 불가합니다.");
        }
    }

    public static void isInputLengthExceeds18(String numberInput) {
        if (numberInput.length() > 18)
            throw new IllegalArgumentException("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    public static void isLargerThan2billion(Long purchasePrice) {
        if (purchasePrice > 2_000_000_000)
            throw new IllegalArgumentException("[ERROR] 20억원보다 큰 금액으로 복권을 구매할 수 없습니다.");
    }

    public static void isDividedBy1000(Long purchasePrice) {
        if (purchasePrice % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
    }

    public static void isNonZero(Long purchasePrice) {
        if (purchasePrice == 0)
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 값을 입력해 주세요.");
    }

    public static void getNoOfLotto() {
        guidePurchasePriceFormat();
        String purchasePriceInput = Console.readLine();

        isVoidInput(purchasePriceInput);
        isInputNumber(purchasePriceInput);
        isInputLengthExceeds18(purchasePriceInput);

        long purchasePrice = Long.parseLong(purchasePriceInput);
        isLargerThan2billion(purchasePrice);
        isDividedBy1000(purchasePrice);
        isNonZero(purchasePrice);

        noOfLottos = (int)(purchasePrice / 1000);
    }

    public static void printNoOfPurchasedLottos() { System.out.printf("\n%d개를 구매했습니다.\n", noOfLottos); }

    public static void generateLottoNumbers() {
        for (int no = 0; no < noOfLottos; no++) {
            List<Integer> pickedNumbers =
                    new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(pickedNumbers);
            purchasedLottos.add(pickedNumbers);
        }
    }

    public static void printLottoNumbers() {
        for(List<Integer> lotto: purchasedLottos)
            System.out.println(lotto);
    }

    public static void purchaseLottos() {
        getNoOfLotto();
        printNoOfPurchasedLottos();
        generateLottoNumbers();
        printLottoNumbers();
    }

    public static void guideWinningNumberFormat() {
        System.out.println("\n1이상 45이하의 당첨 번호 6개를 쉼표로 구분해 입력해주세요.");
    }

    public static boolean isComma(char charAtIndex) { return charAtIndex == ','; }

    public static void isInputCommaAndNumber(String numberInput) {
        int inputLength = numberInput.length();
        for (int index = 0; index < inputLength; index++) {
            char charAtIndex = numberInput.charAt(index);
            if (isComma(charAtIndex)) continue;
            if (isNumber(charAtIndex)) continue;
            throw new IllegalArgumentException("[ERROR] 쉼표와 숫자 외 다른 문자는 입력이 불가합니다.");
        }
    }

    public static List<Integer> parseNumbers(String[] splitNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numberInString : splitNumbers) {
            int numberInInteger = Integer.parseInt(numberInString);
            winningNumbers.add(numberInInteger);
        }
        return winningNumbers;
    }

    public static void isNoOfDigitsExceeds9(String splitNumber) {
        if (splitNumber.length() > 9)
            throw new IllegalArgumentException("[ERROR] 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    public static void getWinningNumbers() {
        guideWinningNumberFormat();
        String winningNumberInput = Console.readLine();

        isVoidInput(winningNumberInput);
        isInputCommaAndNumber(winningNumberInput);

        String[] splitNumbers = winningNumberInput.split(",");
        for (String splitNumber : splitNumbers)
            isNoOfDigitsExceeds9(splitNumber);

        List<Integer> splitNumbersAsInteger = parseNumbers(splitNumbers);
        winningNumbers = new Lotto(splitNumbersAsInteger);
    }

    public static void guideBonusNumberFormat() {
        System.out.println("\n당첨 번호가 아닌 1이상 45이하의 숫자를 보너스 번호로 입력해 주세요.");
    }

    public static void checkRange(int number) {
        if (number > 45 || number < 1)
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    public static void isDuplicatedWithWinningNumbers(int number) {
        if (numberType[number] == NumberType.WINNING)
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 아닌 다른 번호를 입력하십시오.");
    }

    public static void getBonusNumber() {
        guideBonusNumberFormat();
        String bonusNumberInput = Console.readLine();

        isVoidInput(bonusNumberInput);
        isInputNumber(bonusNumberInput);
        isNoOfDigitsExceeds9(bonusNumberInput);

        int bonusNumber = Integer.parseInt(bonusNumberInput);
        checkRange(bonusNumber);
        isDuplicatedWithWinningNumbers(bonusNumber);
        numberType[bonusNumber] = NumberType.BONUS;
    }

    public static Places compareResult(int countWinningNumbers, boolean isBonusNumber) {
        if(countWinningNumbers < 3) return Places.NONE;
        if(countWinningNumbers == 6) return Places.FIRST;
        if(countWinningNumbers == 4) return Places.FOURTH;
        if(countWinningNumbers == 3) return Places.FIFTH;
        if(isBonusNumber) return Places.SECOND;
        return Places.THIRD;
    }

    public static Places countNumberTypes(List<Integer> numbers) {
        int countWinningNumbers = 0;
        boolean isBonusNumber = false;
        for (int number : numbers) {
            if(numberType[number] == NumberType.WINNING)
                countWinningNumbers++;
            if(numberType[number] == NumberType.BONUS)
                isBonusNumber = true;
        }
        return compareResult(countWinningNumbers, isBonusNumber);
    }

    public static void getComparisonResult() {
        for (List<Integer> numbers :  purchasedLottos) {
            Places result = countNumberTypes(numbers);
            int count = noOfLottoWinAt.get(result);
            noOfLottoWinAt.put(result, count + 1);
        }
    }

    public static void printLottoResults() {
        System.out.println("\n당첨 내역");
        System.out.println("--------");
        System.out.printf("3개 일치 (5,000원) - %d개\n",
                noOfLottoWinAt.get(Places.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n",
                noOfLottoWinAt.get(Places.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",
                noOfLottoWinAt.get(Places.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",
                noOfLottoWinAt.get(Places.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",
                noOfLottoWinAt.get(Places.FIRST));
    }

    public static long sumWinningPrizes() {
        long totalWinningPrizes = 0;
        for (Places place: Places.values())
            totalWinningPrizes += (long)noOfLottoWinAt.get(place) * prizesAt.get(place);
        return totalWinningPrizes;
    }

    public static double getEarningsRate() {
        long totalWinningPrizes = sumWinningPrizes();
        return (double)(totalWinningPrizes / 1000) / noOfLottos * 100;
    }

    public static void printEarningsRate() {
        double earningsRate = getEarningsRate();
        System.out.printf("총 수익률은 %.1f%%입니다.", earningsRate);
    }

    public static void main(String[] args) {
        try {
            initializeNumberType();
            initializeNoOfLottoWinAt();
            initializePrizesAtPlaces();

            purchaseLottos();
            getWinningNumbers();
            getBonusNumber();

            getComparisonResult();
            printLottoResults();
            printEarningsRate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}