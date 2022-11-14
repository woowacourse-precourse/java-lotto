package lotto;

import camp.nextstep.edu.missionutils.Console;

public class GameManager {
  public void lottoGameStart() {
    System.out.println("구입금액을 입력해 주세요.");
    int buyAmount = Integer.parseInt(Console.readLine());
    int buyCount = buyAmount/1000;
    System.out.println("\n" + buyCount + "개를 구매했습니다.");
  }
}
