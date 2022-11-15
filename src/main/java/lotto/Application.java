package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>() {
        };
        User user = new User();
        Message.requestPurchase();
        int lottoCount = user.inputPrice();
        Message.printPurchaseAmount(lottoCount);
        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        lottoGenerator.publishLotto();
        lottoGenerator.printLotto();
        for(Lotto lotto : lottoGenerator.userLotto) {
            result.add(lotto.calcResult(user.inputLottoNumbers(), user.inputBonusNumbers()));
        }
    }
}
