package lotto.ui;

import lotto.exception.UIException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    static private List<Integer> lottoNumber;
    UIException uiException = new UIException();

    public Integer GetMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();

        try {
            uiException.notNumberException(money);
            uiException.notMultipleOf1000Exception(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return Integer.parseInt(money);
    }


    public List<Integer> GetLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lotto = readLine();

        List<String> lottoNumberString = new ArrayList<>(Arrays.asList(lotto.split(",")));
        lottoNumber = new ArrayList<>();
        try {
            uiException.CheckLottoLength(lottoNumberString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        for (String element : lottoNumberString) {
            try {
                uiException.notNumberException(element);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }

            lottoNumber.add(Integer.parseInt(element));
        }

        try {
            uiException.overBoundaryException(lottoNumber);
            uiException.duplicateNumberException(lottoNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return lottoNumber;

    }

    public Integer GetBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        try {
            uiException.BonusNumberException(lottoNumber, bonusNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return bonusNumber;
    }


}
