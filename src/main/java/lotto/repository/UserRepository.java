package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.ArrayList;

public class UserRepository {

    private User user = new User();



    public void setUserLotties(ArrayList<Lotto> lotties) {
        this.user.setLotties(lotties);
    }

    public void setUserNumberOfLotties(int numbers) {
        this.user.setTotalNumberOflotties(numbers);
    }

    public void setUserPurchaseMoney(int money){
        this.user.setPurchaseMoney(money);
    }

    public void setUserPrizeMoney(int prizeMoney){
        this.user.setPrizeMoney(prizeMoney);
    }

    public void setUserWinningNumbers(Lotto winningNumbers){
        this.user.setWinningNumbers(winningNumbers);
    }

    public void setUserBonusNumber(int bonusNumber){
        this.user.setBonusNumber(bonusNumber);
    }

    public void setUserNumberOfWinningTypes(ArrayList<Integer> numberOfWinningTypes) {
        this.user.setNumberOfWinningTypes(numberOfWinningTypes);
    }

    public User getUser() {
        return this.user;
    }

}
