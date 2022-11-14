package lotto.controller;

import lotto.service.UserService;

import java.util.List;

public class LottoController {

    private UserService userService = new UserService();


    public void inputUserMoney(){
        userService.setPayMent();
        userService.buyLotto();
    }

    public List<List<Integer>> printLottoNumber(){
        return userService.getUserLottoNumber();
    }

}
