package lotto;
//- 사용자
//        - 사용자는 지불한 돈을 저장한다.
//        - 사용자는 뽑은 로또를 객체배열로 저장하고 있다.
//        - 사용자는 뽑은 등수별로 당첨된 로또개수를 배열로 저장하고 있다.

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
  private int ticket;
  private List<Lotto> lottos;

  public User() {
    setTicket();
  }

  public void setTicket() {
    int money;

    System.out.println("구입금액을 입력해 주세요.");
    money = Integer.parseInt(readLine());
    ticket = MathUtils.numberOfLotto(money);
  }



}
