package lotto;

import java.util.List;

import lotto.domain.Buyer;
import lotto.domain.Judgment;
import lotto.ui.UserInterFace;

public class Application {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.\n";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.\n";
    
    public static void main(String[] args) {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void start() {
        UserInterFace userInterFace = new UserInterFace();
        userInterFace.print(INPUT_MONEY_MESSAGE);
        int inputMoney = userInterFace.inputInteger();
        Buyer buyer = new Buyer();
        buyer.setMoney(inputMoney);
        Judgment judgment = new Judgment();
        int lottoCount = judgment.countLottos(inputMoney);
        buyer.buyLottos(lottoCount);
        userInterFace.printLottos(buyer.getLottos());
        userInterFace.print(INPUT_WINNING_NUMBERS_MESSAGE);
        List<Integer> winningNumbers = userInterFace.inputWinningNumbers();
        int bonus = userInterFace.inputValidBonus(winningNumbers);
        userInterFace.printResult(buyer, winningNumbers, bonus);
    }
}