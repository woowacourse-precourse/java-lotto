package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningLottoNumber {
    private final Lotto WinningLottoNumber;
    private final BonusNumber bonusNumber;

    public WinningLottoNumber(Lotto winningLottoNumber, BonusNumber bonus) {
        validation(winningLottoNumber, bonus);
        WinningLottoNumber = winningLottoNumber;
        bonusNumber = bonus;
    }

    private void validation(Lotto winningLottoNumber, BonusNumber bonus){
        List<Integer> numbers = winningLottoNumber.getNumbers();
        for(int num : numbers){
            if(num == bonus.getBonusNumber()){
                throw new IllegalArgumentException("[ERROR] 당첨번호와 보너스번호는 중복될 수 없습니다.");
            }
        }
    }

    public Integer correctCountCalculation(Lotto userLottoNumber){
        Integer count = 0;
        List<Integer> numbers = this.WinningLottoNumber.getNumbers();
        for(Integer number : numbers){
            if(userLottoNumber.getNumbers().stream().anyMatch(number::equals)){
                count++;
            }
        }
        return count;
    }

    public Integer bonusCountCalculation(Lotto userLottoNumber){
        Integer count = 0;
        if(userLottoNumber.getNumbers().stream().anyMatch(this.bonusNumber.getBonusNumber()::equals)){
            count++;
        }
        return count;
    }

    public Lotto getWinningLottoNumber(){
        return WinningLottoNumber;
    }

    public BonusNumber getBonusNumber(){
        return bonusNumber;
    }
}
