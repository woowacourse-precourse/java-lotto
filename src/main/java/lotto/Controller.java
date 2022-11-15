package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.UI.Text;
import lotto.UI.View;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.User;

import java.util.ArrayList;
import java.util.List;

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
        view.printMessage(Text.BUDGET_INPUT);
        String budgetInput = Console.readLine();
        validateBudget(budgetInput);
        user.setBudget(Integer.parseInt(budgetInput));

    }

    private void validateBudget(String budgetInput){
        try {
            Integer.parseInt(budgetInput);
        }
        catch (Exception exception){
            throw new IllegalArgumentException();
        }
    }

    public void setWinningNumbers(){
        view.printMessage(Text.WINNING_NUMBER_INPUT);
        String winningNumbersInput = Console.readLine();
        String[] splitInput = winningNumbersInput.split(",");
        validateWinningNumbers(splitInput);
        game.setWinningNumbers(toIntegerList(splitInput));
    }

    private void validateWinningNumbers(String[] splitInput){
        try {
            for (String string : splitInput) {
                Integer.parseInt(string);
            }
        }
        catch (Exception exception){
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> toIntegerList(String[] splitInput){
        List<Integer> winningNumbers = new ArrayList<>();
        for (String string : splitInput){
            winningNumbers.add(Integer.parseInt(string));
        }
        return winningNumbers;
    }










}
