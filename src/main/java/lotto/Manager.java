package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Manager {
    static final String requestMoneyStatement = "구입금액을 입력해 주세요.";
    static final String requestLottoNumberStatement = "당첨 번호를 입력해 주세요.";
    static final String requestBonusNumberStatement = "보너스 번호를 입력해 주세요.";
    private final int[] reward = {0, 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};
    private Lotto lotto;
    private int bonusNumber;

    public Manager() {
        List<Integer> tempLottoNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto = new Lotto(tempLottoNumbers);
        int tempBonusNumber = 7;
        bonusNumber = tempBonusNumber;
    }

    public void requestMoneyStatementPrint() {
        System.out.println(requestMoneyStatement);
    }

    public int inputMoney() throws IllegalArgumentException {
        int money;
        String inputMoneyString = Console.readLine();
        try {
            money = Integer.parseInt(inputMoneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_INTEGER.toString());
        }
        return money;
    }

    public void printAllPurchaseLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> number : lottoNumbers) {
            System.out.println(number);
        }
    }

    public List<Integer> generator() {
        List<Integer> unOrderedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> OrderedNumbers = new ArrayList<>(unOrderedNumbers);
        Collections.sort(OrderedNumbers);
        return OrderedNumbers;
    }

    public void generateLotto() {
        requestLottoNumberStatementPrint();
        List<Integer> lottoNumbers = inputLottoNumber();
        lotto = new Lotto(lottoNumbers);
        requestBonusNumberStatementPrint();
        bonusNumber = inputBonusNumber();
    }

    public void requestLottoNumberStatementPrint() {
        System.out.println(requestLottoNumberStatement);
    }

    public List<Integer> inputLottoNumber() throws IllegalArgumentException {
        List<Integer> lottoNumbers = new ArrayList<>();
        String lottoNumber = Console.readLine();
        lottoNumbers = convertToList(lottoNumber);
        return lottoNumbers;
    }

    public List<Integer> convertToList(String lottoNumber) throws IllegalArgumentException {
        List<Integer> convertedNumbers = new ArrayList<>();
        String[] number = lottoNumber.split(",");
        for (String num : number) {
            try {
                convertedNumbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_INTEGER.toString());
            }
        }
        return convertedNumbers;
    }

    public void requestBonusNumberStatementPrint() {
        System.out.println("\n" + requestBonusNumberStatement);
    }

    public int inputBonusNumber() throws IllegalArgumentException {
        String inputNumber = Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_INTEGER.toString());
        }
        isValidBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public void isValidBonusNumber(int bonusNumber) throws IllegalArgumentException {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_OUT.toString());
        }
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DO_NOT_BE_CONTAINED_LOTTO_NUMBERS.toString());
        }
    }

    public int[] compareNumber(List<List<Integer>> purchaseNumbers) {
        int[] result = new int[]{0, 0, 0, 0, 0, 0};
        List<Integer> winningNumber = lotto.getNumbers();
        for (List<Integer> numbers : purchaseNumbers) {
            int numberOfSame = countSameNumber(numbers, winningNumber);
            result[indexToResult(numberOfSame, numbers)]++;
        }
        return result;
    }

    public int indexToResult(int numberOfSame, List<Integer> numbers) {
        if (numberOfSame == 3) {
            return 1;
        }
        if (numberOfSame == 4) {
            return 2;
        }
        if (numberOfSame == 5 && !numbers.contains(bonusNumber)) {
            return 3;
        }
        if (numberOfSame == 5 && numbers.contains(bonusNumber)) {
            return 4;
        }
        if (numberOfSame == 6) {
            return 5;
        }
        return 0;
    }

    public int countSameNumber(List<Integer> from, List<Integer> to) {
        int count = 0;
        for (Integer num : from) {
            if (to.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public double calculateYield(int money, int[] result) {
        int winningSum = 0;
        for (int i = 0; i < result.length; i++) {
            winningSum += result[i] * reward[i];
        }
        return Math.round((double) winningSum / money * 100 * 100) / 100.0;
    }
}
