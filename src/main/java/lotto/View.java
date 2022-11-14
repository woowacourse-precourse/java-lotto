package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner scanner;

    public Exception exception=new Exception();
    public LottoMaker lottoMaker= new LottoMaker();

    public View(Scanner scanner) {
        this.scanner = scanner;;
    }

    public int requestMoney(){
        int inputMoney = StringtoIntegerInput(Console.readLine());
        if(exception.isNumeric(inputMoney)&&exception.divThousandOfMoney(inputMoney)
        &&exception.lessThanThousand(inputMoney)){

            return inputMoney;
        }
        throw new IllegalArgumentException("ERROR");
    }

    public List<Integer> requestLottoNumber(){

        String inputNumber = Console.readLine();
        System.out.println(inputNumber);
        return lottoMaker.splitNumber(inputNumber);

    }

    public int requestBonusLottoNumber(){
        int inputNumber = StringtoIntegerInput(Console.readLine());
        if(exception.lottoValidator(inputNumber))return inputNumber;
        throw new IllegalArgumentException("ERROR");
    }

    public int StringtoIntegerInput(String input){
        return Integer.parseInt(input);
    }
}
