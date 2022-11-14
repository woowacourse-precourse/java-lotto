package lotto.ExceptionChecker;

public class IntegerChecker {
    private final int number;

    public IntegerChecker(String input) {
        validate(input);
        this.number = Integer.parseInt(input);
    }

    public int numberReturn(){
        return number;
    }

    private void validate(String input){
        try {
            Integer.parseInt(input);//에러가 발생할 수 있는 코드

        } catch (Exception NumberFormatException) {
            System.out.println("[ERROR] 숫자를 입력해주세요. ");//에러시 수행

            throw new IllegalArgumentException(); //최상위 클래스가 아니라면 무조건 던져주자
        }

    }


}
