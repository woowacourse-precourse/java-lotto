package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        String userInput = user.input();
        int parseInput = user.checkInput(userInput);
        if(parseInput == 0) {
            return;
        }
        List<Integer> answerNum = user.answerInput();
        if(answerNum.contains(0)){
            return;
        }
        int bonusNum= user.bonusInput();
    }
}
