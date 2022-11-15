package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame.start();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
