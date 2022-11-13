package lotto;

import camp.nextstep.edu.missionutils.Console;

public enum UserInputUi {
  ENTERCOST("구입금액을 입력해 주세요."),
  ENTERWINNINGNUMBER("당첨 번호를 입력해 주세요."),
  ENTERBONNUSNUMBER("보너스 번호를 입력해 주세요.");

  private final String inputStatement;

  UserInputUi(String inputStatement){
    this.inputStatement = inputStatement;
  }

  public String getAnswer(){
    System.out.println(inputStatement);
    return Console.readLine();
  }
}
