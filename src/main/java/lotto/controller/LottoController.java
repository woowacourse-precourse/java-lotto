package lotto.controller;

import lotto.view.UserInterface;

public class LottoController {
    public void gameStart() throws IllegalArgumentException {
        UserInterface userInterface = new UserInterface();
        System.out.println(userInterface.lottoCount);
    }
}
