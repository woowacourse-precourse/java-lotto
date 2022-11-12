package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public WinningStatistic produceWinningStatistic(LottoTicket ticket){
        Set<Integer> answerNumSet=new HashSet<>(numbers);
        List<Integer> ticketNums=ticket.getNumbers();
        int numOfCorrectLottoNum=0;
        boolean bonusNumCorrect=false;
        if(answerNumSet.contains(ticket.getBonusNum())){
            bonusNumCorrect=true;
        }
        for (int number :ticket.getNumbers()){
            if(answerNumSet.contains(number)){
                numOfCorrectLottoNum+=1;
                answerNumSet.remove(number);
            }
        }
        return WinningStatistic.getInstance(numOfCorrectLottoNum,bonusNumCorrect);
    }
}
