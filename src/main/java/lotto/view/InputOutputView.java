package lotto.view;

import lotto.domain.MoneyEnumClass;
import lotto.service.BuyLotto;
import lotto.service.WinningMoney;

import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputOutputView {
    private int fifth;
    private int fourth;
    private int third;
    private int second;
    private int first;

    public int buyMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(readLine());
    }

    public void buyFin(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void myLottos(List<List<Integer>> lottos) {
        for (int idx = 0; idx < lottos.size(); idx++) {
            System.out.println(lottos.get(idx).toString());
        }
        System.out.println();
    }

    public String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public int getBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요");
        return Integer.parseInt(readLine());
    }

    public void saveResult(List<Integer> grades) {
        MoneyEnumClass moneyEnumClass = new MoneyEnumClass();
        moneyEnumClass.setResult(MoneyEnumClass.MoneyEnum.FIFTH, "3개 일치 (5,000원) - ");
        moneyEnumClass.setResult(MoneyEnumClass.MoneyEnum.FOURTH, "4개 일치 (50,000원) - ");
        moneyEnumClass.setResult(MoneyEnumClass.MoneyEnum.THIRD, "5개 일치 (1,500,000원) - ");
        moneyEnumClass.setResult(MoneyEnumClass.MoneyEnum.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        moneyEnumClass.setResult(MoneyEnumClass.MoneyEnum.FIRST, "6개 일치 (20,000,000,000원) - ");
        printResult(grades, moneyEnumClass);
    }
    public void setNum(List<Integer> grades) {
        fifth = Collections.frequency(grades, 3);
        fourth = Collections.frequency(grades, 4);
        third = Collections.frequency(grades, 5);
        second = Collections.frequency(grades, 6);
        first = Collections.frequency(grades, 7);
    }

    public void printResult(List<Integer> grades, MoneyEnumClass moneyEnumClass) {
        setNum(grades);
        System.out.print(moneyEnumClass.getResult(MoneyEnumClass.MoneyEnum.FIFTH));
        System.out.println(fifth + "개");
        System.out.print(moneyEnumClass.getResult(MoneyEnumClass.MoneyEnum.FOURTH));
        System.out.println(fourth + "개");
        System.out.print(moneyEnumClass.getResult(MoneyEnumClass.MoneyEnum.THIRD));
        System.out.println(third + "개");
        System.out.print(moneyEnumClass.getResult(MoneyEnumClass.MoneyEnum.SECOND));
        System.out.println(second + "개");
        System.out.print(moneyEnumClass.getResult(MoneyEnumClass.MoneyEnum.FIRST));
        System.out.println(first + "개");
    }

    public void totalYield(double yeild) {
        System.out.println("총 수익률은 " + yeild + "%입니다.");
    }
}
