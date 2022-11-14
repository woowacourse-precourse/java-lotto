package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        String userInput = user.input();
        int parseInput = user.checkInput(userInput);
        if(parseInput == 0) {
            return;
        }
    }
}
