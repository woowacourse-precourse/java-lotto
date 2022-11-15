package lotto;

public class Application {
    public static void main(String[] args) {
        Input input=new Input();
        MyLottoNumber myLottoNumber=new MyLottoNumber(input.getMoney());
        myLottoNumber.CountMyLottoNumber();
        input.enterNumbers();
        Lotto lotto=new Lotto(input.getNumbers());
        input.enterBonusNumber();
        Check check=new Check(lotto.getNumbers(), input.getBonusNumber(), input.getMoney());
        check.LottoResult(myLottoNumber.getNumbers());
        check.print();
        check.printPercent();
    }
}
