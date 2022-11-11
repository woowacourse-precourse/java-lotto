package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Request request = new Request();
            request.requestBettingMoney();
            request.validateBettingMoney();
            UserBet userBet = new UserBet(request.getBettingMoney());

            request.requestWinningNumbers();
            request.validateWinningNumbers();
            Lotto lotto = new Lotto(request.getWinningNumbers());

            request.requestBonusNumber();
            request.validateBonusNumber();
            BonusNumber bonusNumber = new BonusNumber(request.getBonusNumber());

            Compare compare = new Compare();
            compare.compareNumbers(userBet.getMyLottos(), lotto.getWinningNumbers(), bonusNumber.getBonusNumber());
            compare.figureYield(userBet.getBettingMoney());
            compare.printResult();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
