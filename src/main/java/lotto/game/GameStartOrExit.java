package lotto.game;

public class GameStartOrExit {

    public static void gameStart() {
        try {
            GamePlay.play();
        } catch (Exception ignore) {
            System.out.println("[ERROR]" + ignore.getMessage());
        }
    }

}
