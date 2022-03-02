public class StateTable {
    TapeSymbol[] tapeStates;
    String[] machineStates;

    //first dimension is machineStates | second Dimension is tapeStates
    Instruction[][] instructions;

    public StateTable() {
        this.tapeStates = new TapeSymbol[] {};
        this.machineStates = new String[] {};
    }

    public StateTable(TapeSymbol[] tapeStates, String[] machineStates, Instruction[][] instructions) {
        this.tapeStates = tapeStates;
        this.machineStates = machineStates;
        this.instructions = instructions;

        if (instructions.length != machineStates.length || instructions[0].length != tapeStates.length) {
            System.err.println("Dimensions do not add up");
        }
    }

    public StateTable(TapeSymbol[] tapeStates, String[] machineStates) {
        this.tapeStates = tapeStates;
        this.machineStates = machineStates;

        this.instructions = new Instruction[machineStates.length][tapeStates.length];
        fillInstructionSet();
    }

    private void fillInstructionSet() {
        for (int i = 0; i < instructions.length; i++) {
            for (int j = 0; j < instructions[0].length; j++) {
                instructions[i][j] = new Instruction(machineStates[0], tapeStates[j], true);
            }
        }
    }

    private int getLongestName(String[] stringArray) {
        int longest = 0;
        for (String s : stringArray) {
            if (s.length() > longest) { longest = s.length(); }
        }
        return longest;
    }

    private String generateNCharString(char c, int n) {
        return String.valueOf(c).repeat(n);
    }

    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();

        // Table Header
        retString.append(generateNCharString(' ', getLongestName(machineStates))).append(" | ");
        for (int j = 0; j < tapeStates.length; j++) {
            TapeSymbol tapeState = tapeStates[j];
            int longestInstructionName = 0;

            for (int i = 0; i < instructions.length; i++) {
                if (instructions[i][j].toString().length() > longestInstructionName) {
                    longestInstructionName = instructions[i][j].toString().length();
                }
            }
            int n = longestInstructionName / 2 + tapeState.toString().length() / 2;
            retString.append(generateNCharString(' ', n));
            retString.append(tapeState);
            retString.append(generateNCharString(' ', n));

            retString.append(" | ");
        }

        retString.append('\n').append(generateNCharString('-', retString.length())).append('\n');

        for (int i = 0; i < instructions.length; i++) {
            retString.append(machineStates[i]).append(" | ");
            for (int j = 0; j < instructions[0].length; j++) {
                retString.append(instructions[i][j].toString()).append(" | ");
            }
            retString.append('\n');
        }
        return retString.toString();
    }
}
