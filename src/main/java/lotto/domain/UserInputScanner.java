package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputScanner {
    public Integer askPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = readLine();

        Validator validator = new Validator();

        try {
            validator.validateUserInput(userInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return Integer.parseInt(userInput);
    }
    public List<Integer> askWinningLottoNumber() {
        List<Integer> userSelectLottoNums = askWinningSixNumber();
        if (userSelectLottoNums == null) {
            return null;
        }

        Integer bonusNumber = askBonusOneNumber(userSelectLottoNums);
        if (bonusNumber == null) {
            return null;
        }

        userSelectLottoNums.add(bonusNumber);
        return userSelectLottoNums;
    }

    private List<Integer> askWinningSixNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = readLine();
        Validator validator = new Validator();

        try {
            List<Integer> winningNums = convertUserInputToNumbers(userInput);
            return validator.validateWinningSixNumber(winningNums);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private List<Integer> convertUserInputToNumbers(String userInput) {
        List<Integer> nums = new ArrayList<>();

        try {
            String[] strUserNums = userInput.split(",");

            for (String strUserNum : strUserNums) {
                nums.add(Integer.parseInt(strUserNum));
            }
            return nums;
        }catch (NumberFormatException  e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요");
        }catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자 와 쉼표를 사용하여 입력해야 합니다.");
        }
    }

    private Integer askBonusOneNumber(List<Integer> userSelectLottoNums) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = readLine();
        Validator validator = new Validator();

        try {
            List<Integer> bonusNum = convertUserInputToNumbers(userInput);
            return validator.validateBonusNumber(userSelectLottoNums,bonusNum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
