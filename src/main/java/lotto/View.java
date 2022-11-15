package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class View {

    public void printUncheckedLotto (List<List<Integer>> uncheckedLottos) {
        for (List<Integer> lotto: uncheckedLottos) {
            System.out.println(lotto);
        }
    }

    public int inputBonusNumber () {
        String tempBonusNumber;

        System.out.println("보너스 번호를 입력해주세요.");
        tempBonusNumber = Console.readLine();
        isRealNumber(tempBonusNumber);

        return Integer.parseInt(tempBonusNumber);
    }

    public int inputMoney () {
        String tempMoney;

        System.out.println("구입 금액을 입력해주세요.");
        tempMoney = Console.readLine();
        isRealNumber(tempMoney);

        return Integer.parseInt(tempMoney);
    }

    public  List<Integer> inputLottoNumber () {
        String tempLottoNumber;

        System.out.println("당첨 번호를 입력해주세요.");
        tempLottoNumber = Console.readLine();
        isRealLottoNumber(tempLottoNumber);

        return splitLottoNumber(tempLottoNumber);
    }

    private List<Integer> splitLottoNumber (String tempLottoNumber) {
        List<Integer> lottoNumber = new ArrayList<>();

        for(String element: tempLottoNumber.split(",")) {
            lottoNumber.add(Integer.parseInt(element));
        }

        return lottoNumber;
    }

    private void isRealNumber (String inputStatement) {
        for (char element: inputStatement.toCharArray()) {
            if (element < 49 || element > 57) throw new IllegalArgumentException();
        }
    }

    private void isRealLottoNumber (String lottoNumber) {
        String mergedNumber = String.join(lottoNumber);

        for (char element: mergedNumber.toCharArray()) {
            if (element < 49 || element > 57) throw new IllegalArgumentException();
        }
    }
}
