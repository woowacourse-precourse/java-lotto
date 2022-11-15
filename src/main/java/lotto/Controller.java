package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.UI.Text;
import lotto.UI.View;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Controller {
    private Game game;
    private User user;
    private View view;

    public Controller(Game game, User user, View view){
        this.game = game;
        this.user = user;
        this.view = view;
    }


    public void setBudget(){
        view.print(Text.BUDGET_INPUT);
        String budgetInput = Console.readLine();
        user.setBudget(toInteger(budgetInput));

    }

    private Integer toInteger(String budgetInput){
        try {
            return Integer.parseInt(budgetInput);
        }
        catch (Exception exception){
            throw new IllegalArgumentException();
        }
    }

    public void setWinningNumbers(){
        view.print(Text.WINNING_NUMBER_INPUT);
        String winningNumbersInput = Console.readLine();
        game.setWinningNumbers(toIntegerList(split(winningNumbersInput)));
    }

    private String[] split(String string){
        try{
            return string.split(",");
        }
        catch (Exception exception){
            throw new IllegalArgumentException();
        }
    }


    private List<Integer> toIntegerList(String[] splitInput) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for (String string : splitInput) {
                winningNumbers.add(Integer.parseInt(string));
            }
            return winningNumbers;
        }
        catch (Exception exception){
            throw new IllegalArgumentException();
        }
    }

    public void setBonus(){
        view.print(Text.BONUS_NUMBER_INPUT);
        String bonusNumberInput = Console.readLine();
        game.setBonus(toInteger(bonusNumberInput));
    }

    public void buyLotto(){
        Integer howMany = user.getBudget()/ Game.price;
        view.printBuyLotto(howMany);
    }

    private void viewLottos(){
        for (Lotto lotto : user.getLottos()) {
            List<Integer> numbers = lotto.getNumbers();
            numbers.sort(Comparator.naturalOrder());
            view.print(numbers);
        }
    }

    public void computeStatistics(){
        user.confirmWinning(game.getWinningNumbers(), game.getBonus());
    }

    public void showStatistics(){
        view.print(Text.WINNING_STATISTICS_TITLE);

        for (Rank rank : user.getWinningCount().keySet()){
            if (rank != Rank.NONE) {
                view.printWinningStatisticsDetail(rank.getMatchedCount(), format(rank.getAmount()), user.getWinningCount().get(rank));
            }
        }

        view.printProfitRate(user.getProfitRate());
    }

    private String format(Integer amount){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String formattedAmount = decimalFormat.format(amount);
        return formattedAmount;
    }



}
