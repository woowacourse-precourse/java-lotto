package lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        /*
            To do : 추첨 번호 통지
         */
        input.enterNumbers();
        Lotto lotto = new Lotto(input.getNumbers());
    }
}
