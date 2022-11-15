package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.ui.*;

public class Application {
    public static void main(String[] args) {
        // 초기화
        InitSetting init = new InitSetting();
        init.setInput();
        //init.setException();

        try{
            init.setMoney(Integer.parseInt(Console.readLine()));
            MoneyException moneyException = new MoneyException(init.getMoney());
        }catch(IllegalArgumentException e){
            System.out.println("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
            return;
        };

        try {
            MoneyException moneyException = new MoneyException(init.getMoney());
            init.setMoney(init.getMoney() / (moneyException.result()));
        } catch (ArithmeticException e) {
            System.out.println("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
            return;
        }
        init.setCount(init.getMoney()/1000);
        SetRandomSixNumber setRandomSixNumber = new SetRandomSixNumber();
        init.setLottoNumbers(setRandomSixNumber.randomNumber(init.getMoney(), init.getLottoNumbers()));

        // 사용자 입력
        User user = new User();
        user.setUserNumbers();
        user.setLotto(user.getNumberSplit());

        // 사용자 수와 로또의 수 비교
        Setcompare setcompare = new Setcompare(init.getCount(), user.getNumberSplit(), init.getLottoNumbers());

        // 보너스 번호, 당첨 내역 구하기
        SetBonusNumber bonus = new SetBonusNumber(init.getCount(), init.getLottoNumbers(), init.getBonusCheck(), setcompare.getCompare());

        // 당첨 내역 출력
        WinningPrint winningPrint = new WinningPrint(bonus.getArrCount());

        // 수익률
        long winningSum = winningPrint.priceSum();
        double revenue = (winningSum / (double) init.getMoney()) * 100.0;
        System.out.println("총 수익률은 " + Math.round(revenue * 10) / 10.0 + "%입니다.");
    }
}
