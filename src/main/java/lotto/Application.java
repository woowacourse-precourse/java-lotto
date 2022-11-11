package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        int price = validatePrice(chatbot.askPrice());
        List<List<Integer>> userNumber = setUserNumber(price / 1000);
        chatbot.printUserNumber(userNumber);
        Lotto lotto=new Lotto(chatbot.askLottoNumber());
        int bonus = validateLottoBonus(chatbot.askLottoBonus());
        List<Integer> result=compareNumbers(userNumber,lotto,bonus);
        float rate=calculateRate(price,result);
        chatbot.printResult(rate,result);
    }

    public static int validatePrice(String price) {
        return 0;
    }

    public static List<List<Integer>> setUserNumber(int amount) {
        List<List<Integer>> userNumber = new ArrayList();

        return userNumber;
    }

    public static int validateLottoBonus(String price) {
        return 0;
    }

    public static List<Integer> compareNumbers(List<List<Integer>> userNumber, Lotto lotto, int bonus){
        List<Integer> result=new ArrayList();

        return result;
    }

    public static float calculateRate(int price, List<Integer> result){
        return 0f;
    }

}
