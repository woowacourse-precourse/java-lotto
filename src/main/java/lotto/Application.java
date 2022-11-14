package lotto;

import lotto.domain.LottoChecker;
import lotto.domain.Seller;
import lotto.lottoclient.ClientLottoConsole;
import lotto.lottogenerator.LottoRandomGenerator;

public class Application {

    public static void main(String[] args) {
        Seller seller = new Seller(new LottoRandomGenerator());
        LottoChecker lottoChecker = new LottoChecker(new ClientLottoConsole());
        LottoRunner lottoRunner = new LottoRunner(lottoChecker, seller);

        lottoRunner.run();
    }
}
