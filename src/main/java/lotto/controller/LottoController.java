package lotto.controller;

import com.sun.security.jgss.GSSUtil;
import lotto.domain.LuckyNumber;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LottoController {

    LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        try {
            int money = lottoService.getMoney();
            lottoService.buyLotto(money);
            LuckyNumber luckyNumber = lottoService.pickLuckyNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
