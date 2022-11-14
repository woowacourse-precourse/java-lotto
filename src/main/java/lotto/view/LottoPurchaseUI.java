package lotto.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchaseUI {
    public String takePurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountInput = readLine();
        return purchaseAmountInput;
    }

    public void showLottoNumbers(List<List<Integer>> userLottos){
        userLottos.forEach(System.out::println);
    }
}
