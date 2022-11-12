package constant;

public enum Text {
    ERROR("[ERROR] ")
    ;

    final String content;

    Text(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
