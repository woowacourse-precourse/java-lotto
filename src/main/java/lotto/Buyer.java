package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Buyer {

    private List<Lotto> lottos = new ArrayList<>();

    public int inputBuyLottoMoney() {
        System.out.println("구입금액을 입력해 주세요");
        String inputBuyMoney = Console.readLine();


        Error.validateInputIsNotNum(inputBuyMoney);

        int buyMoney = Integer.parseInt(inputBuyMoney);

        Error.validateBuyMoneyDivided1000(buyMoney);

        return buyMoney;
    }

    public int calculateLotteryNum(int buyNum) {
        return buyNum / 1000;
    }

    public void setLottos(int lottoCnt) {
        LotteryMachine lotteryMachine = new LotteryMachine();

        for (int index = 0; index < lottoCnt; index++) {
            Lotto newLotto = new Lotto(lotteryMachine.makeLottoNum());
            Collections.sort(newLotto.getNumbers());
            this.lottos.add(newLotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


}
