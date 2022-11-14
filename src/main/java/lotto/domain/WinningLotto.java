package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class WinningLotto extends Lotto {

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers,int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        checkContainsBonusNumber();
    }

    public void checkContainsBonusNumber() {
        if(getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 입력한 보너스 번호가 이미 당첨 번호에 존재합니다.");
        }
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    public LottoGrade getLottoGrade(Lotto lotto) {
        int correct = compareToWinningLotto(lotto);
        boolean bonus = compareToBonusNumber(lotto);
        System.out.println("== " + correct + bonus);
        return LottoGrade.getLottoGrade(correct,bonus);
    }

    public int compareToWinningLotto(Lotto lotto){
        int result = (int) lotto.getNumbers().stream()
                .filter(number -> getNumbers().stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
        return result;
    }

    public boolean compareToBonusNumber(Lotto lotto){
        return lotto.getNumbers().contains(getBonusNumber());
    }
}
