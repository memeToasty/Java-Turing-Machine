import java.util.ArrayList;
import java.util.Arrays;

public class TuringMachine {
    String[] machineStates;
    TapeSymbol[] tapeSymbols;

    TapeSymbol[] inputSymbols;

    String initialState;
    String[] finalStates;

    StateTable stateTable;
    //TODO: Refactor
    ArrayList<TapeSymbol> tape = new ArrayList<>(Arrays.asList(
            new TapeSymbol(),
            new TapeSymbol(),
            new TapeSymbol(),
            new TapeSymbol(),
            new TapeSymbol(),
            new TapeSymbol()
    ));

    public TuringMachine(String[] machineStates, TapeSymbol[] tapeSymbols, TapeSymbol[] inputSymbols, String initialState, String[] finalStates, StateTable stateTable) {
        this.machineStates = machineStates;
        this.tapeSymbols = tapeSymbols;
        this.inputSymbols = inputSymbols;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.stateTable = stateTable;
    }

    public TuringMachine(String[] machineStates, TapeSymbol[] tapeSymbols, String[] finalStates) {
        this.machineStates = machineStates;
        this.tapeSymbols = tapeSymbols;
        this.initialState = machineStates[0];
        this.finalStates = finalStates;
        this.inputSymbols = new TapeSymbol[] {};

        setStateTable(machineStates, tapeSymbols);
    }

    private void setStateTable(String[] machineStates, TapeSymbol[] tapeSymbols) {
        this.stateTable = new StateTable(tapeSymbols, machineStates);
    }

    //TODO: Implement isValid() method
    public boolean isValid() {
        return true;
    }

    @Override
    public String toString() {
        String retString = "";

        retString += String.format("M = %s\n", Arrays.toString(this.machineStates));
        retString += String.format("Γ = %s\n", Arrays.toString(this.tapeSymbols));
        retString += "b = □\n";
        retString += String.format("Σ = %s\n", Arrays.toString(this.inputSymbols));
        retString += String.format("q_0 = %s\n", this.initialState);
        retString += String.format("q_f = %s\n", Arrays.toString(this.finalStates));
        retString += "--------\n";
        retString += this.stateTable;
        retString += "--------\n";
        retString += tape.toString();

        return retString;
    }
}
