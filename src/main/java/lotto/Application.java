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
}