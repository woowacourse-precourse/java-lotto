package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Buyer {

    private List<Lotto> lottos = new ArrayList<>();

    public String inputBuyLottoMoney() {
        System.out.println("구입금액을 입력해 주세요");
        return Console.readLine();
    }

    public int validateBuyLottoMoney(String inputBuyMoney) {

        Error.validateInputIsNotNum(inputBuyMoney);

        int buyMoney = Integer.parseInt(inputBuyMoney);

        Error.validateBuyMoneyDivided1000(buyMoney);

        return buyMoney;
    }

    public int calculateLotteryNum(int buyNum) {
        int cnt = buyNum / 1000;
        System.out.println(cnt+"개를 구매했습니다.");

        return cnt;
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

    public void printBuyLotto() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().stream().sorted().collect(Collectors.toList()));
        }
    }


}
