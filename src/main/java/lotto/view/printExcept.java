package lotto.view;

public class printExcept {
    public void printUniqueExc() {
        System.out.println("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }
    public void printSizeExc() {
        System.out.println("[ERROR] 로또 번호는 6개 입력해야 합니다.");
    }
    public void printRangeExc() {
        System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    public void printInputExc() {
        System.out.println("[ERROR] 1000원 단위로 입력해 주세요.");
    }
}
