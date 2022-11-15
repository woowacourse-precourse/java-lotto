package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Manager lottoMgr = new Manager();
            lottoMgr.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


    }
}
