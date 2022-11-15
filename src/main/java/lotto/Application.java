package lotto;

public class Application {
    public static void main(String[] args) {

        try {
            Buyer buyer = new Buyer();
            int buyMoney = buyer.validateBuyLottoMoney(buyer.inputBuyLottoMoney());
            int cnt = buyer.calculateLotteryNum(buyMoney);
            buyer.setLottos(cnt);
            buyer.printBuyLotto();

            LotteryMachine lotteryMachine = new LotteryMachine();
            lotteryMachine.makeWinningLottoNum(lotteryMachine.inputWiningLottoNum());
            lotteryMachine.makeBonusNum(lotteryMachine.getLotto().getNumbers(), lotteryMachine.inputBonusNum());

            int[] lottoResult = lotteryMachine.calculateLottoResult(buyer);
            lotteryMachine.printResult(lottoResult);
            lotteryMachine.printRateOfReturn(lotteryMachine.calculateRateOfReturn(lottoResult, buyMoney));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
