package domain.UserLotto;

public class UserLottoController {
    UserLottoService userLottoService = new UserLottoService();

    public UserLotto createUserLotto(int purchaseNumber) {
        return userLottoService.createUserLotto(purchaseNumber);
    }

    public String getUserLottoHistory(UserLotto userLotto) {
        return userLottoService.getUserLottoHistory(userLotto);
    }
}