package lotto;

public class Exceptions {
    public static void excludeUnderThousand(String readLine){
        getOutExcludingNumbers(readLine);
        if(Integer.parseInt(readLine) % 1000 > 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
    }
    public static void excludeNoLottoNumbers(String readLine){
        getOutExcludingNumbers(readLine);
        if(Integer.parseInt(readLine) < 1 || Integer.parseInt(readLine) > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
    public static void getOutExcludingNumbers(String readLine){
        if (readLine.equals("") && readLine.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백입니다.");
        }
        for (int i = 0; i < readLine.length(); i++) {
            if (!Character.isDigit(readLine.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 0이상의 숫자를 입력해야 합니다.");
            }
        }
    }

}
