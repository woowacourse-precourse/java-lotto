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

    public void setUserNumberOfLotties(ArrayList<Integer> numbers) {
        this.user.setWinningNumbers(numbers);
    }



}
