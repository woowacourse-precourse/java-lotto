package lotto;

public enum RegValue {
  NUMBER_REG("^[0-9]+$"),
  LOTTO_NUMBER_REG("^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$");

  private String reg;

  RegValue(String reg) {
    this.reg = reg;
  }

  public String getReg() {
    return reg;
  }

}
