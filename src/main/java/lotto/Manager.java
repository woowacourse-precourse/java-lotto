package lotto;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {
    static final String requestMoneyStatement = "구입금액을 입력해 주세요.";
    static final String requestLottoNumberStatement = "당첨 번호를 입력해 주세요.";
    static final String requestBonusNumberStatement = "보너스 번호를 입력해 주세요.";

    private Lotto lotto;
    private int bonusNumber;


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
    public int inputBonusNumber() {
        String inputbonusNumber = Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(inputbonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_IS_NOT_INTEGER);
        }
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_RANGE_OUT);
        }
        return bonusNumber;
    }


}
