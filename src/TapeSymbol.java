public class TapeSymbol {
    int number;
    boolean isBlank;

    public TapeSymbol() {
        isBlank = true;
    }

    public TapeSymbol(int number) {
        this.number = number;
        this.isBlank = false;
    }

    @Override
    public String toString() {
        if (isBlank) return "□";
        return String.format("%d", number);
    }
}
