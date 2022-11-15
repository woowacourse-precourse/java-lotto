package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController game = new GameController();

        game.buyLotto();
        game.drawLotto();
        game.getResult();

        /*boolean a_true = true;
        boolean b_true = true;
        boolean b_false = false;

        if(a_true == b_false){
            System.out.println("ddd");
        }*/

    }
}
