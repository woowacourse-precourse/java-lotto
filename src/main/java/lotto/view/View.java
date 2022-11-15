package lotto.view;

public interface View {
    String requestMoney();
    void printLottoCount(int count);
    void printLotto();
    String requestWinningNumbers();
    String requestBonusNumber();
    void printResult();
}
