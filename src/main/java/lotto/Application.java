package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            Lotto.game();
        }
        catch (Exception e){
            System.out.println("[ERROR]가 발생하였습니다.");
        }

    }
}
