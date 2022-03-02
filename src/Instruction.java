public class Instruction {
    TapeSymbol symbol;
    // true = Right | false = left
    boolean moveDirection;
    String nextState;

    public Instruction(String nextState, TapeSymbol symbol, boolean moveDirection ) {
        this.symbol = symbol;
        this.moveDirection = moveDirection;
        this.nextState = nextState;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", nextState, symbol, (moveDirection) ? "R" : "L");
    }
}
