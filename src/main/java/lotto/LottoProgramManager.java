package lotto;

import lotto.config.LottoConfig;
import lotto.message.IOMessage;

import java.util.ArrayList;
import java.util.List;

public class LottoProgramManager {
    private List<Lotto> lottoBought;

    public void runProgram() {
        int lottoNum = buyLotto();
        generateLotto(lottoNum);
    }

    private int buyLotto() {
        int price = IOManager.buyLotto();

        if(LottoConfig.LOTTO_PRICE == 0)
            throw new IllegalArgumentException();
        if(price % LottoConfig.LOTTO_PRICE != 0)
            throw new IllegalArgumentException();

        return price / LottoConfig.LOTTO_PRICE;
    }

    private void generateLotto(int lottoNum) {
        lottoBought = new ArrayList<Lotto>();

        for(int lottoIdx = 0; lottoIdx < lottoNum; lottoIdx++) {
            lottoBought.add(new Lotto(Lotto.generateRandomLottoNumbers()));
        }
    }
}
