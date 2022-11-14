package lotto;

public class Program {
    View view = new View();
    ListOfLottos lottoList;
    int numOfLottos;
    public void setup() {
        view.printMoneyInputMsg();
        numOfLottos = view.getMoneyInput();
        view.printNumberOfLottosMsg(numOfLottos);
        lottoList = new ListOfLottos(numOfLottos);
        lottoList.printAllLottos();
    }
}
