package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidation(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int lottoRanking(List<Integer> winningNumber, Integer bonusNumber){
        int winningNumberCount = howManyWinningNumbers(winningNumber);
        boolean haveBonusNum = haveBonusNumber(bonusNumber);

        if(winningNumberCount == 6) return 1;
        if((winningNumberCount == 5) && haveBonusNum ) return 2;
        if(winningNumberCount == 5) return 3;
        if(winningNumberCount == 4) return 4;
        if(winningNumberCount == 3) return 5;

        return 0;
    }
    private int howManyWinningNumbers(List<Integer> winningNumber){
        int winningNumberCount = 0;

        for(int i = 0 ; i < winningNumber.size() ; i++)
            if(numbers.contains(winningNumber.get(i)))
                winningNumberCount++;

        return winningNumberCount;
    }
    private boolean haveBonusNumber(Integer bonusNumber){
        if(numbers.contains(bonusNumber))
            return true;

        return false;
    }
    public void printSortedLottoNumbers(){
        List<Integer> sortedNumbers = new ArrayList<>();

        sortedNumbers.addAll(this.numbers);
        sortedNumbers.sort(Comparator.naturalOrder());

        System.out.println(sortedNumbers);
    }
    private void duplicateValidation(List<Integer> numbers) {
        Set<Integer> duplicationCheck = new HashSet<>(numbers);
        if ( duplicationCheck.size() != numbers.size() )
            throw new IllegalArgumentException("[ERROR] 로또 번호 6개는 서로 다른 숫자이어야 합니다.");
    }
}
