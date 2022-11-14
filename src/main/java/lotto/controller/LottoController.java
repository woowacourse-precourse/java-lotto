package lotto.controller;

import lotto.service.UserService;

public class LottoController {

    private UserService userService = new UserService;


    public void inputUserMoney(){
        userService.setPayMent();
    }


}
