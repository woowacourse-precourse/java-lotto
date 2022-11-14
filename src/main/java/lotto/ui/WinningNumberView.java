package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumberView implements View{

    private String winningNumbers;

    @Override
    public void makeView() {
        print();
        getInput();
    }

    private void print() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void getInput() {
        winningNumbers = Console.readLine();
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }
}
