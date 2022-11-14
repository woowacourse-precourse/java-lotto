package lotto;

public class Application { // 패키지 분리
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RunLotto test = new RunLotto();
        try {
            test.test1();
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
