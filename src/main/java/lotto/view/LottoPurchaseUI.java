package lotto.view;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchaseUI {
    public String takePurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountInput = readLine();
        System.out.println();
        return purchaseAmountInput;
    }

    public void showLottoNumbers(List<List<Integer>> userLottos){
        System.out.println(String.format("%d개를 구매했습니다.", userLottos.size()));
        userLottos.forEach(System.out::println);
        System.out.println();
    }
}
