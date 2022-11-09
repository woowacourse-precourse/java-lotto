package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Error;
import lotto.service.LottoService;

public class Gamecontroller {
    private final LottoService service = new LottoService();
    public void start() {
        welcome();
        String in = input();
        service.buy(in);
    }

    private void welcome() {
        System.out.println(Error.WELCOME.getMsg());
    }
    private String input() {
        return Console.readLine();
    }
}
