package lotto;

import lotto.domain.LottoService;
import lotto.model.BuyingLottoList;
import lotto.view.LottoBuyView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoBuyView lottoServiceView = new LottoBuyView();
        LottoService lottoService = new LottoService();

        int numberOfLotto = lottoServiceView.buyLotto();
        BuyingLottoList buyingLottoList = new BuyingLottoList(lottoService.generateLottoList(numberOfLotto));

    }
}
