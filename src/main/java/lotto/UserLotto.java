package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class UserLotto {

  private final int money;
  private final List<List<Integer>> randomNumber = new ArrayList<>();

  public UserLotto(String money) {
    validateMoney(money);
    this.money = Integer.parseInt(money);
    System.out.println(this.money/ 1000 + "개를 구매했습니다.");

    // 유저 로또 구입
    userRandomNumber(this.money);
  }

  public int getMoney() {
    return money;
  }

  List<List<Integer>> getRandomNumber() {
    return randomNumber;
  }

  //머니 객체생성 및 예외처리
  private void validateMoney(String money) {
    nullCheck(money);
    checkDigit(money);
    notZeroOrCheckUnit(money);
  }

  private void nullCheck(String money){
    if(money.equals("")){
      System.out.println("[ERROR] 값을 입력해주세요");
      throw new IllegalArgumentException();
    }
  }

  private void checkDigit(String money) {
    for (int i = 0; i < money.length(); i++) {
      if (!Character.isDigit(money.charAt(i))) {
        System.out.println("[ERROR] 숫자만 입력 가능합니다.");
        //throw new IllegalArgumentException();
        throw new NoSuchElementException();
      }
    }
  }

  private void notZeroOrCheckUnit(String money) {
    if (Integer.parseInt(money) == 0 || Integer.parseInt(money) % 1000 != 0) {
      System.out.println("[ERROR] 1,000원 단위로 구매 가능합니다");
      throw new IllegalArgumentException();
    }
  }

  //랜덤넘버를 정렬하여 입력 및 객체생성
  private void userRandomNumber(int money) {
    List<Integer> tmp;
    for (int i = 0; i < money / 1000; i++) {
      tmp = Randoms.pickUniqueNumbersInRange(1, 45, 6)
          .stream().sorted().collect(Collectors.toList());
      System.out.println(tmp);

      randomNumber.add(tmp);
    }
  }
}