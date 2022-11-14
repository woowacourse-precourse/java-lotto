package lotto;

public class PrizeLotto {
    Lotto prizeLotto;
    int bonusNumber;

    public PrizeLotto(Lotto prizeLotto) {
        this.prizeLotto = prizeLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Lotto getPrizeLotto() {
        return prizeLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
