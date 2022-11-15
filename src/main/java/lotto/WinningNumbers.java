package lotto;

public class WinningNumbers {
    private final Lotto WinningNumber;
    private final int BonusNumber;
    private static final String ERROR_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DISTINCT_BONUS = "[ERROR] 보너스 번호는 당첨 번호와 겹치지 않아햐 합니다.";

    public WinningNumbers(Lotto winningNumber, int bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.WinningNumber = winningNumber;
        this.BonusNumber = bonusNumber;
    }
    private void validate(Lotto winningNumber, int bonusNumber){
        if (bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException(ERROR_RANGE);
        }
        if (winningNumber.getNumbers().stream().anyMatch(number -> number.equals(bonusNumber))){
            throw new IllegalArgumentException(ERROR_DISTINCT_BONUS);
        }
    }

    public Rank match(Lotto lotto, int bonusNumber){
        int count = (int) lotto.getNumbers().stream()
                .filter(i -> WinningNumber.getNumbers().contains(i)).count();
        boolean isBonus = lotto.getNumbers().stream().anyMatch(i -> i==bonusNumber);

        return Rank.value(count, isBonus);
    }
    int getBonusNumber(){
        return this.BonusNumber;
    }

}
