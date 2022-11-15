package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Service service = new Service();
        Output output = new Output();

        try {
            System.out.println(Message.INPUT_MONEY.getMessage());
            int purchaseAmount = service.getPurchaseAmount();

            System.out.println(purchaseAmount + Message.PURCHASE.getMessage());
            List<List<Integer>> lottoNumbers = service.LottoList(purchaseAmount);

            System.out.println(Message.WIN_NUMBER.getMessage());
            List<Integer> winningNumber = service.getWinningNumber();

            System.out.println(Message.BONUS_INPUT.getMessage());
            int bonusNumber = service.getBonusInput();

            Integer[] winStatistics = service.calculatorWinner(lottoNumbers, winningNumber, bonusNumber);
            output.WinnerStatistics(winStatistics, purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
