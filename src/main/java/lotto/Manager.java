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

    private Lotto lotto;
    private int bonusNumber;
    private int[] reward = {5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};


    public void requestMoneyStatementPrint() {
        System.out.println(requestMoneyStatement);
    }

    public int inputMoney() {
        int money;
        String inputMoneyString = Console.readLine();
        try {
            money = Integer.parseInt(inputMoneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NOT_INTEGER);
        }
        return money;
    }

    public List<Integer> generator() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }
    public void generateLotto() {
        requestLottoNumberStatementPrint();
        List<Integer> lottoNumbers = inputLottoNumber();
        Lotto lotto = new Lotto(lottoNumbers);
        requestBonusNumberStatementPrint();
        bonusNumber = inputBonusNumber();

    }

    public void requestLottoNumberStatementPrint() {
        System.out.println(requestLottoNumberStatement);
    }

    public List<Integer> inputLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        String lottoNumber = Console.readLine();
        String[] number = lottoNumber.split(",");
        for (String num : number) {
            try {
                lottoNumbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NOT_INTEGER);
            }
        }
        return lottoNumbers;
    }
    public void requestBonusNumberStatementPrint() {
        System.out.println(requestBonusNumberStatement);
    }

    public int inputBonusNumber() {
        String inputNumber = Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NOT_INTEGER);
        }
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE_OUT);
        }
        return bonusNumber;
    }
    public int[] compareNumber(List<List<Integer>> purchaseNumbers) {
        int [] result = new int[]{0, 0, 0, 0, 0};
        List<Integer> winningNumber = lotto.getNumbers();
        for(List<Integer> numbers : purchaseNumbers) {
            int numberOfSame = countSameNumber(numbers, winningNumber);
            if(numberOfSame == 3) {
                result[0]++;
            }
            if(numberOfSame == 4) {
                result[1]++;
            }
            if(numberOfSame == 5 && !numbers.contains(bonusNumber)) {
                result[2]++;
            }
            if(numberOfSame == 5 && numbers.contains(bonusNumber)) {
                result[3]++;
            }
            if(numberOfSame == 6) {
                result[4]++;
            }
        }
        return result;
    }
    public int countSameNumber(List<Integer> from, List<Integer> to) {
        int count = 0;
        for(Integer num: from) {
            if(to.contains(num)) {
                count++;
            }
        }
        return count;
    }
    public double calculateYield(int money, int[] result) {
        int winningSum = 0;
        for(int i = 0; i<result.length; i++) {
            winningSum += result[i] * reward[i];
        }
        double yield = Math.round((double)winningSum / money * 100 * 100) / 100.0;
        return yield;
    }


}
