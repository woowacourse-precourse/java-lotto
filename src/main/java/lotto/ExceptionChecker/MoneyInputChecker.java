package lotto.ExceptionChecker;

public class MoneyInputChecker {

    private final int number;


    public MoneyInputChecker(int moneyInput){
        validateUnit(moneyInput);

        this.number = moneyInput;

    }

    public int moneyReturn(){
        return number;
    }


    public void validateUnit(int inputMoney) {
        try {
            if (inputMoney % 1000 != 0) {
                throw new IllegalArgumentException();
            }

        } catch (Exception IllegalArgumentException) {
            System.out.println("[ERROR] 1000원 단위로 입력해주세요. ");//에러시 수행

            throw IllegalArgumentException; //최상위 클래스가 아니라면 무조건 던져주자
        }
    }
}
