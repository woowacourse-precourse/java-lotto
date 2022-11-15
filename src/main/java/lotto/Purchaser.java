package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Purchaser {
    private int purchaseSum;
    private int purchaseCount;
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 1000원 단위로 입력해 주세요.");
        return Console.readLine();
    }
    public int changeInt(String number) {
        purchaseSum = Integer.parseInt(number);
        return purchaseSum;
    }

    public int dividePurchaseSum() {
        purchaseSum = changeInt(inputPurchaseAmount());
        if (purchaseCount / 1000 >= 1)
            purchaseCount = purchaseSum / 1000;
        else if (!(purchaseCount / 1000 >= 1))
            System.out.println("[ERROR] 구매 금액을 최소 1000원이상 입력해주세요.");
        else if (!(purchaseCount % 1000 == 0)) {
            System.out.println("[ERROR] 구매금액을 1000원 단위로 입력해주세요.");
        }
        return purchaseCount;
    }

    public String inputLottoNum() {
        System.out.println("당첨 번호 6개를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public List userNum() {
        List<String> list = Arrays.asList(inputLottoNum().split(","));
        return list;
    }
}