package lotto;

import lotto.util.InputUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.Constant.*;
import static lotto.util.InputUtil.*;

public class Player {

    private Lotto winningNumber;
    private List<Lotto> lottos;
    private int bonusNumber;

    public int putMoneyforLotto(String money){
        int totalPayment = InputUtil.stringToInt(money);
        checkDivideBy1000(totalPayment);
        return (int)totalPayment/1000;
    }
    public void checkDivideBy1000(int totalPayment) {
        if(totalPayment % 1000 !=0){
            throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_BY1000);
        }
    }

    private void isInDuplicateInWinning(int number) {
        if (this.winningNumber.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_BONUS);
        }
    }

    private void isInRange(int number){
        if(number<1 || number>45){
            throw new IllegalArgumentException(ERROR_MESSAGE+ERROR_BOUNDARY);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setWinningNumber(List<Integer> numbers){
        this.winningNumber = new Lotto(numbers);
    }

    public void setLottos(int tiket){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<tiket; i++){
            lottos.add(new Lotto(Lotto.createRandomLotto()));
        }
        this.lottos = lottos;
    }
    public void setBonusNumber(int number){
        isInDuplicateInWinning(number);
        isInRange(number);
        this.bonusNumber = number;
    }
}
