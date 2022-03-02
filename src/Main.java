public class Main {
    public static void main(String[] args) {

        String[] machineStates = new String[] {"q_0", "q_1", "q_F"};
        TapeSymbol[] tapeSymbols = new TapeSymbol[]{ new TapeSymbol(0), new TapeSymbol(1) };
        String[] finalStates =  new String[] {machineStates[machineStates.length - 1]};

        TuringMachine turingMachine = new TuringMachine(
                machineStates,
                tapeSymbols,
                finalStates
        );

        System.out.println(turingMachine);
    }
}
