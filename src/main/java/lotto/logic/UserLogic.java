package lotto.logic;

import lotto.domain.Lotto;
import lotto.domain.User;

import java.util.List;

public class UserLogic {
    private static UserLogic userLogic = new UserLogic();

    private UserLogic() {
    }

    public static UserLogic getInstance() {
        return userLogic;
    }
    public User makeUser(Integer money) {
        return new User(money);
    }

    public List<Lotto> userLottos(User user) {
        return user.getLottos();
    }

    public Integer userLottoCounts(User user) {
        return user.getLottoCount();
    }

    public void addLotto(User user, Lotto lotto) {
        user.addLotto(lotto);
    }

    public void increasePrize(User user, Integer prize){
        user.increasePrize(prize);
    }

    public double userYield(User user) {
        return user.getYield();
    }
}
