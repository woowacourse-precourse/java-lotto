package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        PlayLotto game = new PlayLotto();
        try {
            game.start();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
