package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameStarter gameStarter = new GameStarter();
        gameStarter.gameStart();

    }
}
