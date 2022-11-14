package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

public class Message {

    public String inputPaymentMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void buyLottoMessage(int lottoAmount){
        System.out.println();
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void lottoDetailMessage(Lotto lotto){
        System.out.println(lotto.getNumbers());
    }

    public String inputWinningNumberMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumberMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
