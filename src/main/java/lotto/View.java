package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class View {
    static int money;
    static int bonusNumber;
    List<Integer> lottoNumber = new ArrayList<>();

    public void ui () {
        inputMoney();
        inputLottoNumber();
    }

    private void inputMoney () {
        String tempMoney;

        System.out.println("구입 금액을 입력해주세요.");
        tempMoney = Console.readLine();
        isRealNumber(tempMoney);

        money =  Integer.parseInt(tempMoney);
    }

    private void inputLottoNumber () {
        String tempLottoNumber;

        System.out.println("당첨 번호를 입력해주세요.");
        tempLottoNumber = Console.readLine();
        isRealLottoNumber(tempLottoNumber);
        splitLottoNumber(tempLottoNumber);
    }

    private void splitLottoNumber (String tempLottoNumber) {

        for(String element: tempLottoNumber.split(",")) {
            lottoNumber.add(Integer.parseInt(element));
        }
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
