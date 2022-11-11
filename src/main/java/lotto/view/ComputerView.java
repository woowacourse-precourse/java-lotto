package lotto.view;

public class ComputerView {

    private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    public String getNumbers(){
        return "";
    }

    public String getBonusNumber(){
        return "";
    }

    private void inquireNumbers(){
        System.out.println(REQUEST_WINNING_NUMBERS);
    }

    private String scanNumbers(){
        return "";
    }

    private void inquireBonusNumber(){

    }

    private String scanBonusNumber(){
        return "";
    }
}
