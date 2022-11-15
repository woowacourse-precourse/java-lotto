package lotto;

import java.util.List;

public class Output {

    public void userBuyLottoNumbers(List<Lotto> userLottoNumbers){
        int amount = userLottoNumbers.size();
        System.out.println(amount + "개를 구매했습니다.");

        for(Lotto lotto : userLottoNumbers){
            System.out.println(lotto.getNumbers().toString());
        }
    }
}
