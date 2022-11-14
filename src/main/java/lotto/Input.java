package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static int inputMoney(){
        String moneyInput = Console.readLine();
        ValidationCheck.checkValidMoneyInput(moneyInput);
        return Integer.parseInt(moneyInput);
    }

    public static List<Integer> inputWinningNumbers(){
        String winningNumbers = Console.readLine();

        ValidationCheck.checkDigitAndComma(winningNumbers);
        ValidationCheck.checkOverlapAndSize(winningNumbers);
        ValidationCheck.isBetweenCertainNumbers(winningNumbers, 1, 45);

        return convertToLottoFormat(winningNumbers);
    }

    /**
     * csv 형태의 로또번호를 List<Integer>형태로 정리하여 반환한다.
     * @param winningNumbers 로또 1등 당첨 번호(보너스 번호 제외)
     * @return List<Integer>형태로 정리된 당첨 번호
     */
    private static List<Integer> convertToLottoFormat(String winningNumbers) {
        List<Integer> winningLotto = new ArrayList<>();
        String[] targets = winningNumbers.split(",");
        for (String num: targets){
            Integer current = Integer.valueOf(num);
            winningLotto.add(current);
        }
        return winningLotto;
    }

    public static List<Integer> inputBonusNumber(List<Integer> winningNumbers){
        String bonusNumber = Console.readLine();

        ValidationCheck.isDigit(bonusNumber);
        ValidationCheck.isBetweenCertainNumbers(bonusNumber, 1, 45);
        ValidationCheck.isNotOverlap(bonusNumber, winningNumbers);

        winningNumbers.add(Integer.valueOf(bonusNumber));
        return winningNumbers;
    }
}
