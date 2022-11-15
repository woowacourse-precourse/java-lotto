package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

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
        Lotto lotto;
        try {
            lotto = new Lotto(numbers);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        lotto = new Lotto(numbers);
        return (lotto);
    }

    public Bonus getBonus(Lotto lotto) {
        String number;
        while (true){
            number = Console.readLine();
            try {
                validateNumber(number);
                break;
            } catch (IllegalArgumentException e){
                System.err.println(ERROR_MESSAGE+"보너스 번호를 잘못 입력했습니다.");
                System.exit(0);
            }

        }
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
                System.exit(0);
            }
        }
        int count =  Integer.parseInt(amount) / PURCHASE_UNIT;
        return count;
    }

    private void validateNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (i == 0 && (number.charAt(i) == '0' || !Character.isDigit(number.charAt(i)))) {
                throw new IllegalArgumentException();
            }
            if (i != 0 && !Character.isDigit(number.charAt(i))) {
                throw new IllegalArgumentException();
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
