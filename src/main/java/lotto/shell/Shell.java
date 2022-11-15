package lotto.shell;

import static java.lang.Integer.parseInt;


import camp.nextstep.edu.missionutils.Console;

import lotto.abstraction.ShellInterface;

// 사용자 입력 담당 책임
public class Shell implements ShellInterface {

    private String injection;

    public Shell() {
        this.injection = Console.readLine();
    }


    // 입력값 순서대로 주입하기
    @Override
    public void injectInOrder() {

        receivedInteger();

        separateResponsibility();

    }

    // 책임 분리하기
    public void separateResponsibility() {

        // 당첨 번호 주입하기
        if (injection.contains(",")) {
            new WinningNumber().addWinningNumber();
        }

        // 구입 금액 주입하기
        if (injection.contains("0")) {
            addAmount();
        }

        // 보너스 번호 주입하기
        if (injection.length() <= 2) {
            addBonusNumber();
        }

    }

    @Override
    public void receivedInteger() {

        String onlyInteger = injection.replaceAll("[^0-9]", "");

        if (onlyInteger.equals("")) {
            new Exception().invalidException();
        }

    }


    public int addAmount() {
        int amount = parseInt(injection);
        return amount;
    }


    public int addBonusNumber() {

        int bonusNumber = parseInt(injection);
        return bonusNumber;
    }
}
