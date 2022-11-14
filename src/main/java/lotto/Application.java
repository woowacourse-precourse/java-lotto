package lotto;

public class Application {
  public static void main(String[] args) {
    User user = new User();
    user.setLottos();
    LottoAnswer lottoAnswer = new LottoAnswer();
    user.printResult(lottoAnswer);
  }
}
