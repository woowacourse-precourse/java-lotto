package lotto.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.data.Lotto;
import lotto.data.Rank;

public class House {
    private final Lotto win;
    public House(String winnerNumbers, int bonus) {
        List<Integer> numbersInput = convertWinnerNumber(winnerNumbers);
        win = new Lotto(numbersInput, bonus);
    }

    private List<Integer> convertWinnerNumber(String winnerNumbers){
        try{
            String[] splitByComma = winnerNumbers.split(",");
            Stream<String> streamOfStr = Arrays.stream(splitByComma);
            Stream<Integer> streamOfInt = streamOfStr.map(Integer::parseInt);
            return streamOfInt.collect(Collectors.toList());
        }catch (Error e){
            throw new IllegalArgumentException();
        }
    }

    private void printResultOf(User user){
        int[] statistic = new int[Rank.values().length];
        int amount = 0;
        for(Lotto ticket:user.tickets){
            Rank result = win.checkRankOf(ticket);
            amount += result.getMoney();
            statistic[result.getRank()-1]++;
        }

        for(int i = 0; i < statistic.length; i++){

        }
    }
}
