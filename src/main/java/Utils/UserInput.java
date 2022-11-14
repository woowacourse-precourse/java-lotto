package Utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

    // 사용자 입력 받기
    public String getUserInput() {
        String userInput = Console.readLine();

        return userInput;
    }

    // 사용자 입력이 숫자인지 유효성 검사
    private void validateInputIsNum(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    // 사용자 입력금액이 1000으로 나눠 떨어지는지 유효성 검사
    private void validateInputMoney(String userInput) {
        int userInputMoney = Integer.parseInt(userInput);

        if (userInputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로만 입력해주세요.");
        }
    }

    // 입력되는 당첨번호가 형식에 맞는지 유효성 검사
    private void validateInputLottoNumbers(String userInput) {
        String lottoNumbersPattern = "^(\\d,\\d,\\d,\\d,\\d,\\d)$";
        Pattern pattern = Pattern.compile(lottoNumbersPattern);
        Matcher matcher = pattern.matcher(userInput);

        if(!matcher.matches()){
            throw new IllegalArgumentException("[ERROR] 형식에 맞게 입력해주세요. 번호는 쉼표(,)를 기준으로 구분합니다.");
        }
    }

}
