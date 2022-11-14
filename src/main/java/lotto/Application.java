package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        Wallet wallet = new Wallet();

        // 구입금액 입력
        wallet.setMoney(Console.readLine());

        // 로또판매점에서 내 지갑으로 로또를 판매
        wallet.buyLottos( lottoStore.sellLottos(wallet.getMoney()) );
        wallet.showMyLottos();

        lottoStore.setWinNumbers(Console.readLine());
        lottoStore.setBonusNumber(Console.readLine());

        for (Lotto lotto : wallet.getMyLottos()) {
            wallet.addReward(lottoStore.calcLottoReward(lotto));
        }

        wallet.showStatistics();
    }
}
