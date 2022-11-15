package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.text.NumberFormat;
import java.util.List;

import java.util.ArrayList;
public class InputView {
    private static final String LOTTO_PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요";
    private static final String LOTTO_PRICE_ERROR_MESSAGE = "[ERROR] 올바른 로또 금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요";

    private static final String USER_NUMBER_INPUT_MESSAGE = "당첨번호를 입력해 주세요.";
    private int ticketMoney;
    private int bonusNumber;
    private ArrayList<Integer> numbers = new ArrayList<>();

    public InputView() {
        //buyLottoTickets();
        pressLottoNumbers();
    }

//    public void buyLottoTickets() {
//        System.out.println(LOTTO_PURCHASE_PRICE_INPUT_MESSAGE);
//        String input = Console.readLine();
//        if(checkLottoTicket(input)) {
//            this.ticketMoney = Integer.parseInt(input);
//        }
//    }
//
//    public boolean checkLottoTicket(String input) {
//        if(input.charAt(0) == '0') {
//            throw new IllegalArgumentException("[ERROR] 구매 금액을 제대로 입력해 주세요.");
//        }
//        for(char c : input.toCharArray()) {
//            if(!Character.isDigit(c)) {
//                throw new IllegalArgumentException("[ERROR] 구매 금액을 제대로 입력해 주세요.");
//            }
//        }
//        int temp = Integer.parseInt(input);
//        if((temp % 1000) != 0) {
//            throw new IllegalArgumentException("[ERROR] 구매 금액은 천원 단위로 입력해야 합니다.");
//        }
//        return true;
//    }

    public String pressLottoNumbers() {
        System.out.println(USER_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        return Console.readLine();

    }

//    public void checkStringToInt(String input) {
//        String[] tempArr = input.split(",", 6);
//        if(tempArr.length!= 6) {
//            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 여야 합니다.");
//        }
//        checkNumbers(tempArr);
//        for(String numbers : tempArr) {
//            this.numbers.add(Integer.parseInt(numbers));
//        }
//    }

    public boolean checkNumbers(String[] tempArr) {
        try {
            for(String s : tempArr) {
                Integer.parseInt(s);
            }
        }catch(Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
        return true;
    }

    public Integer money(String money) {
        MoneyInputWrongMoney(money);
        return Integer.parseInt(money);
    }

    public void MoneyInputWrongMoney(String money) {
        boolean isNumeric = money.chars().allMatch(Character::isDigit);
        if(!isNumeric) {
            System.out.println("[ERROR] 올바른 숫자가 아닙니다.");
            throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
        }
    }

    public String inputMoney() {
        System.out.println(USER_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public List<Integer> getLottoNumbers() {
        return this.numbers;
    }

    public int getTicketMoney() {
        return this.ticketMoney;
    }

    public void pressBonusNumber() {
        System.out.println(WINNING_LOTTO_BONUS_INPUT_MESSAGE);
        String input = Console.readLine();
        if(checkBonusNumber(input)) {
            this.bonusNumber = Integer.parseInt(input);
        }
    }

    public boolean checkBonusNumber(String input) {
        try {
            int temp = Integer.parseInt(input);
            if(temp >= 1 && temp <= 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1이상 45 이하여야 합니다.");
            }
            if(this.numbers.contains(temp)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호가 이미 존재합니다.");
            }
        } catch(Exception e) {
            if(e.equals(NumberFormatException.class)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값이 입력되었습니다.");
            }
            if(e.equals(IllegalArgumentException.class)) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return true;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
