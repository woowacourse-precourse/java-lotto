package lotto;

import lotto.ui.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        try{
            game.gameStart();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
