package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validator;

public class UserInput implements Input {
    @Override
    public void readInput() {
        System.out.println("구입금액을 입력해 주세요.");
        //    구매 금액 입력
        String purchasePrice = Console.readLine();
        int purchaseAmount = Validator.validateModIsZero(Integer.parseInt(purchasePrice));
        System.out.println(purchaseAmount + "개를 구매했습니다.");

        //    당첨 번호 입력
        System.out.println();
        //    보너스 번호 입력
    }

}
