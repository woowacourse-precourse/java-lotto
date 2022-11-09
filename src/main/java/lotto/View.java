package lotto;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void ui () {
        inputMoney();
        Lotto lotto = new Lotto(inputLottoNumber());
    }

    private int inputMoney () {
        String money;

        System.out.println("구입 금액을 입력해주세요.");
        money = Console.readLine();
        isRealNumber(money);

        return Integer.parseInt(money);
    }

    private List<Integer> inputLottoNumber () {
        String tempLottoNumber;
        List<Integer> lottoNumber;

        System.out.println("당첨 번호를 입력해주세요.");
        tempLottoNumber = Console.readLine();
        isRealLottoNumber(tempLottoNumber);
        lottoNumber = splitLottoNumber(tempLottoNumber);

        return lottoNumber;
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
