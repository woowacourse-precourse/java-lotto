package lotto;

public class LotteryMachine {
    private Lotto winningLotto;
    private int bonusNumber;
    LotteryMachine(Lotto winningLotto,int bonusNumber) {
        validate(winningLotto,bonusNumber);
        this.winningLotto=winningLotto;
        this.bonusNumber=bonusNumber;
    }
    private void validate(Lotto winningLotto,int bonusNumber){
        if(winningLotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스번호는 6개의 로또 번호와 다른 숫자입니다.");
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
