package controller;

import domain.UserLotto;
import service.UserLottoService;

public class UserLottoController {
    UserLottoService userLottoService = new UserLottoService();

    public UserLotto createUserLotto(int purchaseNumber) {
        return userLottoService.createUserLotto(purchaseNumber);
    }
}