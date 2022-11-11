package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Status status = new Status();
            Request request = new Request();

            status.setStatus("request money");
            request.printRequestMessageByStatus(status.getStatus());
            request.requestUserInput();
            request.validateByStatus(status.getStatus());

            UserBet userBet = new UserBet(request.getUserInput());

            status.setStatus("request winning numbers");
            request.printRequestMessageByStatus(status.getStatus());
            request.requestUserInput();
            request.validateByStatus(status.getStatus());

            Lotto lotto = new Lotto(request.getWinningNumbers());

            status.setStatus("request bonus number");
            request.printRequestMessageByStatus(status.getStatus());
            request.requestUserInput();
            request.validateByStatus(status.getStatus());

            BonusNumber bonusNumber = new BonusNumber(request.getUserInput());

            Compare compare = new Compare();
            compare.compareNumbers(userBet.getMyLottos(), lotto.getWinningNumbers(), bonusNumber.getBonusNumber());
            compare.sumWinnings();
            compare.figureYield(userBet.getBettingMoney());
            compare.printResult();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
