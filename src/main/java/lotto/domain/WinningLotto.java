package lotto.domain;

public class WinningLotto {
    private Lotto winningLottoNumber;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.winningLottoNumber = lotto;
        if(winningLottoNumber.contain(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호를 입력할 수 없습니다.");
        }
        this.bonusNumber = bonusNumber.getNumber();
    }

    public Lotto getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}