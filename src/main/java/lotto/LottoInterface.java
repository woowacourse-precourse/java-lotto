package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class LottoInterface {
    public static int getPurchasePrice(){
        int purchasePrice = 0;
        System.out.println("구입금액을 입력해 주세요.");

        String userInput = Console.readLine();
        if(ErrorCheck.isValidPrice(userInput)){
            purchasePrice = Integer.parseInt(userInput);
        }
        System.out.println(purchasePrice);

        return purchasePrice;
    }

    public static void purchasedLottosInformation(List<Lotto> purchaseLottos){
        System.out.println(purchaseLottos.size() + "개 구매했습니다.");
        for(Lotto lottoNum : purchaseLottos){
            System.out.println(lottoNum.getNumber());
        }
    }
}
