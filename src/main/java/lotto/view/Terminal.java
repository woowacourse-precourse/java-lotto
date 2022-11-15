package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Terminal implements View {
    @Override
    public String requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    @Override
    public void printLottoCount() {

    }

    @Override
    public void printLotto() {

    }

    @Override
    public String requestWinningNumbers() {
        return null;
    }

    @Override
    public String requestBonusNumber() {
        return null;
    }

    @Override
    public void printResult() {

    }
}
