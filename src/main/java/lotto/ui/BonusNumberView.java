package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberView implements View{

    private String bonusNumber;

    @Override
    public void makeView() {
        print();
        getInput();
    }

    private void print() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private void getInput() {
        bonusNumber = Console.readLine();
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
