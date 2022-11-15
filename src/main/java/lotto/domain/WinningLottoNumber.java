package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumber {
    Lotto lotto;
    private int winNumber;
    private int bonusNumber;

    public WinningLottoNumber(String input) {
        List<Integer> numbers = validate(input);
        this.lotto = new Lotto(numbers);
    }

    public int setBonusNumber(String number){
        return validateBonusNumber(number);
    }
    private List<Integer> validate(String input) {
        List<Integer> numbers = new ArrayList<>();

        for (String s : input.split(",")) {
            int num;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Message.LOTTO_NUMMBER_ERROR.get());
            }
            numbers.add(num);
        }
        return numbers;
    }

    private int validateBonusNumber(String number){
        int bonus = Integer.parseInt(number);
        if (bonus < 1 || bonus > 45) {
            System.out.println(Message.BONUS_NUM_RANGE_ERROR.get());
            throw new IllegalArgumentException();
        }
        if (lotto.getNumbers().contains(bonus)) {
            System.out.println(Message.BONUS_NUM_DUPLICATE_ERROR.get());
            throw new IllegalArgumentException();
        }
        return bonus;
    }
    public Lotto getLotto(){
        return lotto;
    }











}
