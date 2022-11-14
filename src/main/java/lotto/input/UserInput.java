package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.validate.Validator;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    public Integer getBounsNumber() {
        //    보너스 번호 입력
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusValue = Console.readLine();
        Integer bounusNumber = Integer.parseInt(bonusValue);
        Validator.validateOutOfBound(bounusNumber);
        return bounusNumber;
    }

    public Lotto getPrizeNumber() {
        //    당첨 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        String prizeInput = Console.readLine();
        String[] prizeString = prizeInput.split(",");
        List<Integer> prizeNumbers = new ArrayList<>();
        for (String str : prizeString) {
            Integer value = Integer.parseInt(str);
            prizeNumbers.add(value);
        }
        return  new Lotto(prizeNumbers);
    }

    public Integer getPurchasePrice() {
        //    구매 금액 입력
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        Validator.validateContainString(purchasePrice);
        Validator.validateModIsZero(Integer.parseInt(purchasePrice));
        Integer purchaseAmount = Integer.parseInt(purchasePrice) / 1000;
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        return purchaseAmount;
    }
}