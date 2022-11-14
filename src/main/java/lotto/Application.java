package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchasePrice = 0;
        try {
            purchasePrice = LottoInterface.getPurchasePrice();
        }catch(Exception e){
            return;
        }

        LottoShop lottoShop = new LottoShop(purchasePrice);
        List<Lotto> purchaseLottos = lottoShop.publishLotto();
        LottoInterface.purchasedLottosInformation(purchaseLottos);

        Lotto winningLottoNum = new Lotto(LottoInterface.winningLottoNum());
        int bonus = LottoInterface.getBonusNumber();
        System.out.println("bonus : " + bonus);

        // statistics
        LottoInterface.winningStatistics(purchaseLottos, winningLottoNum, bonus);
        LottoInterface.yield();
    }
}
