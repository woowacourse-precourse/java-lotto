package lotto.view;

public class LottoNumberInputView extends View {
    private String response;

    @Override
    public void show() {
        printLine("당첨 번호를 입력해 주세요.");
        printLine("1부터 45까지의 중복되지 않는 6개의 숫자를 입력해 주세요.");

        this.response = readLine("ex) 1,2,3,4,5,6");
    }

    @Override
    public String getResponse() {
        return response;
    }
}
