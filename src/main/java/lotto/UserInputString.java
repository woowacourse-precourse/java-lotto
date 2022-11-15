package lotto;
import camp.nextstep.edu.missionutils.Console;

// 사용자로부터 입출력을 위한 출력문 상수들과 입력 메소드를 가지고 있는 UserInputString enum 클래스 구현
public enum UserInputString {
    ENTERPURCHASEAMOUNT("구입금액을 입력해 주세요."),
    ENTERWINNINGNUMBER("당첨 번호를 입력해 주세요."),
    ENTERBONNUSNUMBER("보너스 번호를 입력해 주세요.");

    private final String inputStatement;
    UserInputString(String inputStatement){
        this.inputStatement = inputStatement;
    }
    public String getString(){
        System.out.println(inputStatement);
        return Console.readLine();
    }
}
