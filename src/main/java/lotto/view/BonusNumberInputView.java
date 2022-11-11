package lotto.view;

public class BonusNumberInputView extends View {
    private String response;

    @Override
    public void show() {
        printLine("보너스 번호를 입력해 주세요.");
        printLine("1부터 45까지의 숫자 1개를 입력해 주세요.");

        this.response = readLine("ex) 42");
    }

    @Override
    public String getResponse() {
        return response;
    }
}
