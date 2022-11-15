package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class Parser {
    private static final int PURCHASE_UNIT = 1000;
    private static final String ERROR_MESSAGE = "[ERROR]";

    public Parser() {//TODO: 생성자 부분도 수정하기 - 각 객체의 프로퍼티를 담을 수 있는 방안?
    }

    public Lotto getLotto() {
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(",")) {
            validateNumber(number);
            numbers.add(Integer.parseInt(number));//TODO: valid number 인지 확인
        }
        Lotto lotto = new Lotto(numbers);
        return (lotto);
    }

    public Bonus getBonus(Lotto lotto) {
        String number = Console.readLine();
        validateNumber(number);
        Bonus bonus = new Bonus(Integer.parseInt(number), lotto);//TODO: 좀 더 깔끔한 방식이 있을까?
        return (bonus);
    }

    public int getCount() {
        String amount;
        while (true){
            amount = Console.readLine();
            try{
                validateAmount(amount);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(ERROR_MESSAGE+"구입금액을 잘못 입력했습니다.");
            }
        }
        int count =  Integer.parseInt(amount) / PURCHASE_UNIT;
        return count;
    }

    private void validateNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (i == 0 && (number.charAt(i) == '0' || !Character.isDigit(number.charAt(i)))) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            if (i != 0 && !Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
        }
    }

    private void validateAmount(String amount) {
        validateNumber(amount);
        if (Integer.parseInt(amount) % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
