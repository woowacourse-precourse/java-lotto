package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoConsole {
    static final long MAX_INT = 2147483647;
    static final int MIN_LOTTO_NUM = 1;
    static final int MAX_LOTTO_NUM = 45;
    LottoManager lottoManager = new LottoManager();
    void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = stringToInt(input);

        if (money % 1000 != 0)
            throw new IllegalArgumentException();
        lottoManager.makeLottos(money / 1000);
    }

    void inputNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = validateNumbers(input);
        lottoManager.setWinNumbers(numbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        input = Console.readLine();
        int bonusNumber = validateNumber(input, numbers);
        lottoManager.setBonusNumber(bonusNumber);
    }

    void printLottoNumbers(){

    }

    void printResult(){

    }

    List<Integer> validateNumbers(String input){
        List<Integer> ret = new ArrayList<>();
        String[] strings = input.split(",");

        for (String str : strings){
            int number = validateNumber(str, ret);

            ret.add(number);
        }
        return ret;
    }

    int validateNumber(String input, List<Integer> numbers){
        int number = stringToInt(input);

        if (isOverRange(number)) {
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers, number)){
            throw new IllegalArgumentException();
        }
        return number;
    }

    boolean isOverRange(int number){
        if (number >= MIN_LOTTO_NUM && number <= MAX_LOTTO_NUM){
            return false;
        }
        return true;
    }

    boolean isDuplicate(List<Integer> numbers, int number){
        if (numbers.contains(number)){
            return true;
        }
        return false;
    }

    int stringToInt(String input){
        long val = 0;

        for (int i = 0; i < input.length(); i++){
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')){
                throw new IllegalArgumentException();
            }
            val *= 10;
            val += input.charAt(i) - '0';
            if (val > MAX_INT){
                throw new IllegalArgumentException();
            }
        }
        return (int)val;
    }

}