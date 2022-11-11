package lotto;

public class Problem {

    Problem(){
        printInputGuide();
    }

    void printInputGuide(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    void startProblem(){
        User input=new User();
        input.inputMoney();
        input.setLottoQuantity();
        input.printLottoQunantity();
    }
}
