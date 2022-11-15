package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {

    public void printPurchaseAmountQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printMatchLottoNumberQuestion(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printBonusNumberQuestion(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public String getUserInput() {
        return Console.readLine();
    }

}
