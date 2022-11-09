package lotto.tool;

public enum InputType {
  PRICE("로또 구입 금액은"),
  WINNER("당첨 번호는"),
  BONNUS("보너스 번호는");
  private final String text;

  InputType(String text) {
    this.text = text;
  }
}
