package lotto.shell;

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
            new WinningNumber().buildWinningNumberList();
        }

        // 구입 금액 주입하기
        if (injection.contains("0")) {
            new Amount().buildAmount();
        }

        // 보너스 번호 주입하기
        if (injection.length() <= 2) {
            new BonusNumber().buildBonusNumber();
        }
    }

    // 정수 검별
    @Override
    public void receivedInteger() {

        boolean invalidValue = injection.replaceAll("[^0-9]", "").equals("");

        if (invalidValue) {
            new Exception().invalidException();
        }

    }
}
