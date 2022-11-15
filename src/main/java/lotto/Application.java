package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String checkedInput = Console.readLine();

        try {
            Game game = new Game(checkedInput);
            game.play();
        } catch (Exception error) {
            return;
        }

    }
}
