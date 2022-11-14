package lotto;

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

    public Lotto getWinningLottoNumber(){
        return WinningLottoNumber;
    }

    public BonusNumber getBonusNumber(){
        return bonusNumber;
    }
}
