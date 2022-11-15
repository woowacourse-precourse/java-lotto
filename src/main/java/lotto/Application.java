package lotto;


public class Application {

    public static void main(String[] args) {
        //TODO: 프로그램 구현
        try {
            UserLotto userLotto = new UserLotto();
            userLotto.startGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

