package lotto.view.type;

public class StringType extends ViewType{

  private final String message;

  public StringType(String message){
    this.message = message;
  }

  public String getString(){
    return message;
  }
}
