package lotto.view;

public enum OutputString {
    TICKET_QUANTITY_MESSAGE("%s개를 구매했습니다.");

    private final String content;

    OutputString(String content){
        this.content = content;
    }

    public String print(int num){
        return String.format(content, num);
    }

    public String print(){
        return content;
    }

}
