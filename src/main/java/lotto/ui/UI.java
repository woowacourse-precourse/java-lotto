package lotto.ui;

import lotto.exception.UIException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UI {
    static private List<Integer> lottoNumber;
    private final UIException uiException = new UIException();

    public int GetMoney(){
        System.out.println("돈을 입력하세요");
        String money = readLine();
        uiException.notNumberException(money);
        uiException.notMultipleOf1000Exception(money);

        return Integer.parseInt(money);
    }


    public List<Integer> GetLottoNumber(){
        System.out.println("로또 번호를 입력하세요");
        String lotto = readLine();

        List<String> lottoNumberString = new ArrayList<>(Arrays.asList(lotto.split(",")));
        List<Integer> lottoNumberInt = new ArrayList<>();
        uiException.CheckLottoLength(lottoNumberString);
        for(String e: lottoNumberString)
        {
            uiException.notNumberException(e);
            lottoNumberInt.add(Integer.parseInt(e));
        }
        uiException.overBoundaryException(lottoNumberInt);
        uiException.duplicateNumberException(lottoNumberInt);
        return lottoNumberInt;

    }

    public int GetBonusNumber(){
        System.out.println("보너스 번호를 입력하세요");
        int bonus = Integer.parseInt(readLine());
        uiException.BonusNumberException(lottoNumber, bonus);

        return bonus;
    }





}
