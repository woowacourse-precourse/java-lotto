package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.UI.Text;
import lotto.UI.View;
import lotto.domain.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private final Game game;
    private final User user;
    private final View view;

    public Controller(Game game, User user, View view){
        this.game = game;
        this.user = user;
        this.view = view;
    }

    public void run(){
        try {
            setBudget();
            buyLotto();
            showLottos();
            setWinningNumbers();
            setBonus();
            computeStatistics();
            showStatistics();
        }
        catch (IllegalArgumentException exception){
            view.printErrorMessage(exception.getMessage());
        }
    }


    public void setBudget(){
        view.print(Text.BUDGET_INPUT);
        String budgetInput = Console.readLine();
        Integer integer = toInteger(budgetInput);
        user.setBudget(integer);

    }

    private Integer toInteger(String budgetInput){
        try {
            return Integer.parseInt(budgetInput);
        }
        catch (Exception exception){
            throw new IllegalArgumentException("[ERROR] 이 입력은 정수여야 합니다.");
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
            throw new IllegalArgumentException(
                    "[ERROR] 이 입력은 ','로 구분되는 정수들의 나열이어야 합니다."
            );
        }
    }


    private List<Integer> toIntegerList(String[] splitInput) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for (String string : splitInput) {
                winningNumbers.add(Integer.parseInt(string.trim()));
            }
            return winningNumbers;
        }
        catch (Exception exception){
            throw new IllegalArgumentException(
                    "[ERROR] 이 입력은 ','로 구분되는 정수들의 나열이어야 합니다."
            );
        }
    }

    public void setBonus(){
        view.print(Text.BONUS_NUMBER_INPUT);
        String bonusNumberInput = Console.readLine();
        game.setBonus(toInteger(bonusNumberInput));
    }

    public void buyLotto(){
        Integer howMany = user.getBudget()/ Constants.PRICE.getValue();
        user.buyLotto(howMany);
        view.printBuyLotto(howMany);
    }

    public void showLottos(){
        for (Lotto lotto : user.getLottos()) {
            List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
            numbers.sort(Comparator.naturalOrder());
            view.print(numbers);
        }
    }

    public void computeStatistics(){
        user.confirmWinning(game.getWinningNumbers(), game.getBonus());
    }

    public void showStatistics(){
        view.print(Text.STATISTICS_TITLE);

        for (Rank rank : Rank.asSortedList()){
            view.printStatisticsDetail(selectFormatByRank(rank), rank.getMatchedCount(), format(rank.getAmount()), user.getWinningCount().get(rank));
        }

        view.printProfitRate(user.getProfitRate());
    }

    private String format(Integer amount){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return  decimalFormat.format(amount);
    }

    private Text selectFormatByRank(Rank rank){
        if (rank == Rank.NONE) return Text.NONE;
        if (rank.getBonusCount() != 0) return Text.STATISTICS_DETAIL_WITH_BONUS;
        return Text.STATISTICS_DETAIL_WITHOUT_BONUS;
    }



}
