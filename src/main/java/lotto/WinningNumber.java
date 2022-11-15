package lotto;

public class WinningNumber {
    private static String LOTTO_ALREADY_CONTAIN_BONUS_NUMBER = "[ERROR] 번호가 중복되어 보너스 숫자로 선택할 수 없습니다.";

    private Lotto winningNumber;
    private int bonusNumber;

    public WinningNumber(Lotto winningNumber, int bonusNumber) {
        validWinNumsContainsBonusNum();
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
    private void validWinNumsContainsBonusNum(){
        if(winningNumber.contains(bonusNumber)){
            throw new IllegalArgumentException(LOTTO_ALREADY_CONTAIN_BONUS_NUMBER);
        }
    }
}
