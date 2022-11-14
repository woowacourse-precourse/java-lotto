package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop();
        List<Lotto> lottoList = lottoShop.generateLottoList(lottoShop.buyLotto());

        LottoUser lottoUser = new LottoUser();
        List<List<Integer>> userLottoList = lottoUser.generateUser();

        LottoCalculator lottoCalculator = new LottoCalculator();
        lottoCalculator.checkNumbers(lottoList, userLottoList);
    }
}
