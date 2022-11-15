package lotto.ui;

import lotto.exception.UIException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    static private List<Integer> lottoNumber;
    private final UIException uiException = new UIException();

    public int GetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        uiException.notNumberException(money);
        System.out.println(money);
        uiException.notMultipleOf1000Exception(money);
        return Integer.parseInt(money);
    }


    public List<Integer> GetLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lotto = readLine();

        List<String> lottoNumberString = new ArrayList<>(Arrays.asList(lotto.split(",")));
        lottoNumber = new ArrayList<>();
        uiException.CheckLottoLength(lottoNumberString);
        for (String e : lottoNumberString) {
            uiException.notNumberException(e);
            lottoNumber.add(Integer.parseInt(e));
        }
        uiException.overBoundaryException(lottoNumber);
        uiException.duplicateNumberException(lottoNumber);
        return lottoNumber;

    }

    public int GetBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        uiException.BonusNumberException(lottoNumber, bonusNumber);

        return bonusNumber;
    }



}
