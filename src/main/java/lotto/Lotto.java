package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private WinningStatus winningStatus = WinningStatus.FAILED;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void printNumbers() {
        System.out.print("[");
        for (int i = 0; i < 6; i++) {
            System.out.print(numbers.get(i));
            if (i != 5) System.out.print(", ");
        }
        System.out.println("]");
    }

    public void setWinningStatus(List<Integer> winningNumbers, Integer bonusNumber) {
        int matchCount = 0;
        boolean bonusMatchFlag = false;
        for(Integer winningNumber : winningNumbers) {
            if(numbers.contains(winningNumber)) matchCount++;
        }
        if(numbers.contains(bonusNumber)) bonusMatchFlag = true;
        if(matchCount == 3) winningStatus = WinningStatus.THREE_MATCH;
        if(matchCount == 4) winningStatus = WinningStatus.FOUR_MATCH;
        if(matchCount == 5 && !bonusMatchFlag) winningStatus = WinningStatus.FIVE_MATCH;
        if(matchCount == 5 && bonusMatchFlag) winningStatus = WinningStatus.FIVE_MATCH_BONUS_MATCH;
        if(matchCount == 6) winningStatus = WinningStatus.SIX_MATCH;
    }

    public WinningStatus getWinningStatus() {
        return this.winningStatus;
    }
}
