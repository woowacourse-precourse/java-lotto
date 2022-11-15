package lotto;

public class Application {
  public static void main(String[] args) {
    User user = new User();
    if (!user.setUser())
      return ;
    LottoAnswer lottoAnswer = new LottoAnswer();
    user.printResult(lottoAnswer);
  }
}
