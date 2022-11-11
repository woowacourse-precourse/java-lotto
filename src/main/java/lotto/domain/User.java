package lotto.domain;

import lotto.service.LottoGenerator;
import lotto.service.UserIOService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constants.Constants.LOTTO_PRICE;

public class User {
    public UserIOService ioService = new UserIOService();
    public List<Lotto> purchaseLotto;
    public int purchaseMoney;
    public int purchaseLottoNum;

    public void buyLotto() {
        purchaseMoney = ioService.scanPayMoney();
        purchaseLottoNum = purchaseMoney / LOTTO_PRICE;
        purchaseLotto = issueLotto(purchaseLottoNum);
    }

    private List<Lotto> issueLotto(int purchaseLottoNum) {
        LottoGenerator generator = new LottoGenerator();
        List<Lotto> tempGeneratedLotto = new ArrayList<>();
        for (int buy = 0; buy < purchaseLottoNum; buy++) {
            List<Integer> generatedNums = generator.generateRandomNums();
            Collections.sort(generatedNums);
            tempGeneratedLotto.add(new Lotto(generatedNums));
        }
        return tempGeneratedLotto;
    }

    public void printBoughtLotto(){
        System.out.println(ioService.print(purchaseLottoNum,purchaseLotto));
    }

}
