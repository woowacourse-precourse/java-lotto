package lotto;

public class LottoWinningNumber {

    private final Lotto winningNumber;
    private final LottoBonusNumber lottoBonusNumber;

    public LottoWinningNumber(Lotto winningNumbers, LottoBonusNumber lottoBonusNumber) {
        this.winningNumber = winningNumbers;
        this.lottoBonusNumber = validateBonusNumberInWinningNumbers(lottoBonusNumber);
    }

    public int compareLottoNumbers(Lotto lottoNumber) {
        return this.winningNumber.repeatLottoNumberCheck(lottoNumber);
    }

    public boolean findBonusNumber() {
        return winningNumber.isBonusNumber(lottoBonusNumber);
    }

    public LottoBonusNumber validateBonusNumberInWinningNumbers(LottoBonusNumber lottoBonusNumber) {
        if (this.winningNumber.isBonusNumber(lottoBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨번호에 존재합니다.");
        }
        return lottoBonusNumber;
    }

}
