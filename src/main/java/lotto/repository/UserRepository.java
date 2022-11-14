package lotto.repository;

import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.ArrayList;

public class UserRepository {

    private User user = new User();



    public void setUserOwnLotto(Lotto lotto) {
        ArrayList<Lotto> OriginalLotties = new ArrayList<>();
        OriginalLotties.add(lotto);
        this.user.setLotties(OriginalLotties);
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

    public User getUser() {
        return this.user;
    }

}
