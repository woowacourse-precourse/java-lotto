package lotto;

import java.util.Arrays;
import java.util.List;
public enum LottoType {

  //맞는숫자 갯수, 보너스넘버 보유여부, 당첨금, 중복당첨 count를 위한 index
  SIX_SAME(6, false, 2000000000, 0),
  FIVE_SAME_AND_BONUS(5, true, 30000000, 1),
  FIVE_SAME(5, false, 1500000, 2),
  FOUR_SAME(4, false, 50000, 3),
  THREE_SAME(3, false, 5000, 4);

  private final int sameNumberCount;
  private final boolean isSameBonus;
  private final long money;
  private final int index;


  LottoType(int sameNumberCount, boolean isSameBonus, long money, int index) {
    this.sameNumberCount = sameNumberCount;   //맞는 번호갯수
    this.isSameBonus = isSameBonus;           //보너스 넘버, 존재 시 True
    this.money = money;                       //구매금액
    this.index = index;                       //중복당첨 count를 위한 index 생성
  }

  public int getSameNumberCount() {
    return sameNumberCount;
  }

  public boolean isSameBonus() {
    return isSameBonus;
  }

  public long getMoney() {
    return money;
  }

  public int getIndex() {
    return index;
  }


  public static LottoType calc(List<Integer> lottoNumber, int bonusNumber, List<Integer> userNumber) {
    
    //초기화
    int sameCount = 0;
    boolean isBonus = false;
    
    //로또번호 및 보너스번호 확인
    for (int num : userNumber) {
      if (lottoNumber.contains(num)) {
        sameCount++;
      }
      if (bonusNumber == num) {
        isBonus = true;
      }
    }
    return of(sameCount, isBonus);
  }

  //2등을 제외한 보너스넘버 사용 제외처리
  public static LottoType of(int sameCount, boolean isBonus) {
    return Arrays.stream(values())
        .filter(v -> (sameCount != 5 && sameCount == v.sameNumberCount) ||
            (sameCount == v.sameNumberCount && isBonus == v.isSameBonus))
        .findFirst().orElse(null);
  }
}
