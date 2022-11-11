package lotto.domain;

public class LotteryMachine {//로또 추첨기계
    private Lotto winningLotto;
    private int bonusNumber;
    public LotteryMachine(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto,bonusNumber);
        this.winningLotto=winningLotto;
        this.bonusNumber=bonusNumber;
    }
    public Lotto getWinningLotto() {
        return winningLotto;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto winningLotto,int bonusNumber){
        if(winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스번호는 6개의 로또 번호와 다른 숫자여야 합니다.");
        }
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException("[ERROR] 보너스번호는 1-45사이의 숫자여야 합니다.");
        }
    }
}
