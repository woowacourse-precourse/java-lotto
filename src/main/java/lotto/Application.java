package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Application {
  static Lotto lotto; //로또번호
  static LottoBonus lottoBonus; // 로또 보너스 번호
  static UserLotto userLotto; //구매자에 관한 정보. 구입한 금액 및 랜덤 로또번호
  static LottoResult lottoResult;

  // 로또 진행
  public static void main(String[] args) {
    userBuyLotto();
    createLotto();
    compare();
  }

  //구입금액 입력 및 금액만큼 로또번호 생성
  public static void userBuyLotto() {
    System.out.println("구입금액을 입력해 주세요.");
      userLotto = new UserLotto(readLine());
  }

  public static void createLotto() {
    try {
      System.out.println("당첨 번호를 입력해 주세요.");
      lotto = new Lotto(Arrays.stream(readLine().split(","))
          .mapToInt(Integer::parseInt)
          .boxed()
          .collect(Collectors.toList()));

      System.out.println("보너스 번호를 입력해 주세요");
      lottoBonus = new LottoBonus(Integer.parseInt(readLine()), lotto.getNumbers());
    } catch (IllegalArgumentException e) {
      System.out.println("[ERROR] 숫자만 입력해주세요");
      throw new IllegalArgumentException();
    }
  }
}
