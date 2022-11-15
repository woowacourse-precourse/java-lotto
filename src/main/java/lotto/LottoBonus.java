package lotto;

import java.util.List;

public class LottoBonus {

  private final Integer bonusNumber;

  public LottoBonus(Integer bonusNumber, List<Integer> lottoNumbers) {
    validateBonusNumber(bonusNumber, lottoNumbers);

    this.bonusNumber = bonusNumber;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }

  private void validateBonusNumber(Integer bonusNumber, List<Integer> lottoNumbers) {
    isRangeValidation(bonusNumber);
    containsLottoNumberValidation(bonusNumber, lottoNumbers);
  }

  private void isRangeValidation(Integer bonusNumber) {
    //1 ~ 45 사이의 숫자가 아닐 시
    if (bonusNumber < 1 || bonusNumber > 45) {
      System.out.println("[ERROR] 1부터 45 사이의 숫자여야 합니다.");
      throw new IllegalArgumentException();
    }
  }

  private void containsLottoNumberValidation(Integer bonusNumber, List<Integer> lottoNumbers) {
    //당첨번호에 같은 수가 있을 시
    if (lottoNumbers.contains(bonusNumber)) {
      System.out.println("[ERROR] 당첨번호와 중복되는 값입니다");
      throw new IllegalArgumentException();
    }
  }
}
