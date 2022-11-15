package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.constant.Rank;
import lotto.domain.Buyer;
import lotto.domain.Judgment;
import lotto.domain.Referee;

public class UserInterFace {
    private static final String NOT_A_INTEGER_ERROR_MESSAGE = "[ERROR] 정수를 입력해야 합니다.";
    private static final String DUPLICATE_BONUS_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복됩니다.";
    
    private final Judgment judgment;
    private final Referee referee;
    
    public UserInterFace() {
        this.judgment = new Judgment();
        this.referee = new Referee();
    }
    
    public int inputInteger() {
        try {
            String input = Console.readLine();
            int result = Integer.valueOf(input);
            return result;
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(NOT_A_INTEGER_ERROR_MESSAGE);
        }
    }
    
    public void printLottos(List<List<Integer>> lottos) {
        print(lottos.size() + "개를 구매했습니다.\n");

        for (int index = 0; index < lottos.size(); index++) {
            List<Integer> lotto = lottos.get(index);
            print(lotto.toString() + "\n");
        }
        
        print("\n");
    }
    
    public void print(String text) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException error) {
            error.printStackTrace();
        }

    }
    
    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        Judgment judgment = new Judgment();
        judgment.check5Commas(input);
        List<String> dividedInput = Arrays.asList(input.split(","));
        List<Integer> numbers = judgment.changeToInteger(dividedInput);
        judgment.checkSize(numbers, 6);
        judgment.checkNumbersRange(numbers, 1, 45);
        return numbers;
    }
    
    public int inputValidBonus(List<Integer> winningNumbers) {
        Judgment judgment = new Judgment();
        int input = inputInteger();
        judgment.checkRange(input, 1, 45);
        
        for (int index = 0; index < winningNumbers.size(); index++) {
            if (winningNumbers.get(index).equals(input)) {
                throw new IllegalArgumentException(DUPLICATE_BONUS_ERROR_MESSAGE);
            }
        }
        
        return input;
    }

    public void printResult(Buyer buyer, List<Integer> winningNumbers, int bonus) {
        print("당첨 통계\n---\n");
        List<Integer> prizes = Arrays.asList(0, 0, 0, 0, 0, 0);
        
        for (int index = 0; index < buyer.getLottos().size(); index++) {
            int winningCount = judgment.correctCount(winningNumbers, buyer.getLottos().get(index));
            boolean hasBonus = judgment.hasBonus(bonus, buyer.getLottos().get(index));
            Rank rank = referee.getLottoRank(winningCount, hasBonus);
            Integer newPrize = prizes.get(rank.ordinal()) + rank.getPrize();
            prizes.set(rank.ordinal(), newPrize);
        }
        
        printPrize(prizes);
        printProfit(buyer.getMoney(), prizes);
    }

    public void printPrize(List<Integer> prizes) {
        Rank[] ranks = Rank.values();
        
        for (int index = prizes.size() - 2; 0 <= index; index--) {
            String bonusText = "";
            
            if (index == 1) {
                bonusText = ", 보너스 볼 일치";
            }
            
            print(ranks[index].getCorrect() + "개 일치"+ bonusText + " (" + ranks[index].getPrizeWon() + ") - "
                    + prizes.get(index) / ranks[index].getPrize() + "개\n");
        }
        
        print("\n");
    }
    
    public void printProfit(double originalMoney, List<Integer> prizes) {
        double resultMoney = 0;
        
        for (int index = 0; index < prizes.size(); index++) {
            resultMoney += prizes.get(index);
        }
        
        double profit = Math.round((resultMoney / originalMoney) * 10) * 10 * 100;
        print("총 수익률은 " + profit + "%입니다.");
    }
    
}
