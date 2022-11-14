package Utils;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    // 사용자 입력 받기
    public String getUserInput() {
        String userInput = Console.readLine();

        return userInput;
    }

    // 사용자 입력이 숫자인지 유효성 검사
    private void validateInputIsNum(String userInput) {
        try {
            int StringToInt = Integer.parseInt(userInput);
        } catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }

    }


}
