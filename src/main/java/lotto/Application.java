package lotto;

public class Application {
    public static void main(String[] args) {

        Buyer buyer = new Buyer();
        int buyMoney = buyer.inputBuyLottoMoney();
        int cnt = buyer.calculateLotteryNum(buyMoney);
        buyer.setLottos(cnt);
        buyer.printBuyLotto();

        LotteryMachine lotteryMachine = new LotteryMachine();
        lotteryMachine.makeWinningLottoNum();
        lotteryMachine.makeBonusNum(lotteryMachine.getLotto().getNumbers());

        int[] lottoResult = lotteryMachine.calculateLottoResult(buyer);
        lotteryMachine.printResult(lottoResult);
        lotteryMachine.printRateOfReturn(lottoResult, buyMoney);
    }
}
