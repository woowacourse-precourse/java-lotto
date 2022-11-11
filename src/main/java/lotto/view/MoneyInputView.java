package lotto.view;

public class MoneyInputView extends View {
    private String money;

    @Override
    public void show() {
        printLine("구입 금액을 입력해 주세요.");
        printLine("구입 금액은 숫자만 입력할 수 있으며 1000원 단위로 구매할 수 있어요.");

        this.money = readLine("ex) 8000");
    }

    @Override
    public String getResponse() {
        return this.money;
    }
}
