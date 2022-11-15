package lotto;

public enum ErrorMessage {
    INVALID_COST("[ERROR]1000원 단위로 입력해주세요"),INVALID_LIST_TYPE("[ERROR]올바른 리스트 형식이 아닙니다."),INVALID_INT_RANGE("[ERROR]로또 범위에 맞게 숫자를 입력해주세요."),
    INVALID_BONUS_TYPE("[ERROR]올바른 보너스 번호를 입력해주세요."),INVALID_LIST_SIZE("[ERROR]6개의 로또번호를 입력해주세요"),INVALID_LIST_DUPLICATE("[ERROR]중복되지 않은 6개의 로또번호를 입력해주세요");

    private String desc;
    ErrorMessage( String desc){
        this.desc = desc;
    }

    public String getDesc(){
        System.out.println(desc);
        return desc;
    }
}
