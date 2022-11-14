package lotto;

public class WinningLotto{
    private Lotto majorNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto majorNumbers, int bonusNumber) {
        this.majorNumbers = majorNumbers;

        validateUniqueBonusNumber(majorNumbers, bonusNumber);
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean hasMajorNumber(int number){
        return majorNumbers.hasNumber(number);
    }
    public boolean hasBonusNumber(int number){
        return bonusNumber == number;
    }

    private void validateUniqueBonusNumber(Lotto majorNumbers, int bonusNumber){
        if(majorNumbers.hasNumber(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복될 수 없습니다.");
        }
    }
    private void validateRange(int bonusNumber){
        if(bonusNumber < 0 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복될 수 없습니다.");
        }
    }
}
