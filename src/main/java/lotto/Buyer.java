package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private List<Lotto> lottos = new ArrayList<>();

    public int inputBuyLottoMoney() {
        System.out.println("구입금액을 입력해 주세요");
        String inputBuyMoney = Console.readLine();

        if(!inputBuyMoney.matches("^[0-9]*$"))
            throw new IllegalArgumentException(Error.INPUT_IS_NOT_NUM.getErrorMsg());

        int buyMoney = Integer.parseInt(inputBuyMoney);

        if (buyMoney % 1000 != 0 || buyMoney == 0)
            throw new IllegalArgumentException(Error.NOT_NUMBER_DIVIDED_1000.getErrorMsg());

        return buyMoney;
    }

    public int calculateLotteryNum(int buyNum) {
        return buyNum / 1000;
    }

    public void setLottos(int lottoCnt) {
        LotteryMachine lotteryMachine = new LotteryMachine();

        for (int index = 0; index < lottoCnt; index++) {
            Lotto newLotto = new Lotto(lotteryMachine.makeLottoNum());

            this.lottos.add(newLotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }


}
