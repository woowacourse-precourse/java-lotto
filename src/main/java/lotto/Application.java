package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            Gambler person = createGambler();
            List<Integer> winningNumbs = createWinningLottoNumbs();
            Output.printAll(person);
            showEarningStatistic(person, winningNumbs);
        }catch (Exception e){
            System.out.println("[ERROR] : " + e.getMessage());
        }
    }

    private static void showEarningStatistic(Gambler person, List<Integer> winningNums) {
        List<Integer> placeResult = person.checkAllLotto(winningNums);
        double earningRate = Output.getEarningRate(placeResult, person);
        Output.printStatistic(placeResult, earningRate);
    }

    private static List<Integer> createWinningLottoNumbs() {
        System.out.println(Guidance.INPUT_WINNING_NUMBERS.guide);
        List<Integer> winningNumbs = Input.inputWinningNumbers();

        System.out.println(Guidance.INPUT_BONUS_NUMBER.guide);
        winningNumbs = Input.inputBonusNumber(winningNumbs);
        return winningNumbs;
    }

    private static Gambler createGambler() {
        System.out.println(Guidance.INPUT_BUYING_AMOUNT.guide);
        int money = Input.inputMoney();
        Gambler person = new Gambler(money);
        person.buyingLotto();
        return person;
    }
}
