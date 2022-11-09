package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Msg;
import lotto.service.LottoService;

public class Gamecontroller {
    private final LottoService service = new LottoService();
    public void start() {
        welcome();
        String in = input();
        buyLotto(in);

    }

    private void buyLotto(String in) {
        try {
            service.buy(in);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void welcome() {
        System.out.println(Msg.WELCOME.getMsg());
    }
    private String input() {
        return Console.readLine();
    }
}
