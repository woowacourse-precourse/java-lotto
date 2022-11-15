package lotto;

public class WinningNumber {

    public final static int REPEAT_INITIAL_VALUE = 0;

    private final Lotto lottoNumber;
    private final BonusNumber bonusNumber;

    public WinningNumber(Lotto lottoNumber, BonusNumber bonusNumber) {
        this.lottoNumber = lottoNumber;
        this.bonusNumber = validateBonusNumberDuplicate(lottoNumber, bonusNumber);
    }

    public Ranking calculateRanking(Lotto lottoNumbers) {
        int matchCount = this.lottoNumber.calculateMatchCount(lottoNumbers);
        return Ranking.findOfRanking(matchCount, lottoNumbers.contains(bonusNumber.getBonusNumber()));
    }

    private BonusNumber validateBonusNumberDuplicate(Lotto winningNumber, BonusNumber bonusNumber) {
        if (winningNumber.getNumbers().contains((bonusNumber.getBonusNumber()))) {
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 숫자가 당첨 번호와 중복입니다.");
        }
        return bonusNumber;
    }

}