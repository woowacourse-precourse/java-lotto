package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        final String ER = "[ERROR]";

        try {
            LottoGame game = new LottoGame();
            game.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
