package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validator;

import java.util.ArrayList;
import java.util.List;

public class UserInput implements Input {
    @Override
    public void readInput() {
        //    구매 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        Validator.validateModIsZero(Integer.parseInt(purchasePrice));
        Integer purchaseAmount = Integer.parseInt(purchasePrice) / 1000;
        System.out.println(purchaseAmount + "개를 구매했습니다." + "\n");
        //    구매 로또 번호 출력

        //    당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String prizeInput = Console.readLine();
        String[] prizeString = prizeInput.split(",");
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String str : prizeString) {
            Integer i = Integer.parseInt(str);
            prizeNumbers.add(i);
        }
        Validator.validateOutOfBound(prizeNumbers);
        //    보너스 번호 입력
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
    }

}
