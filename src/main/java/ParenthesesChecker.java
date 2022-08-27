import java.util.Stack;

public class ParenthesesChecker {

    // create a new stack for storing relevant testString input
    private Stack<Character> testInput = new Stack<>();

    public ParenthesesChecker() {
    }

    // create a checkParentheses method
    public boolean checkParentheses(String testString) {

        // if testString empty - return true
        if (testString.isEmpty()) {
            return true;
        }
        // break up testString into an array of individual characters
        char[] testStringSeparated = testString.toCharArray();
        // check if array length is uneven number (i.e., number of brackets is uneven) - return false
        if (testStringSeparated.length % 2 != 0) {
            return false;
        }
        // initiate a for loop to assess each element in new character array
        for (int i = 0; i < testStringSeparated.length; i++) {
            // retrieve an individual character from array
            Character individualCharacter = testStringSeparated[i];
            // if character '('
            if (individualCharacter == '(') {
                // push to stack if stack is empty or top element is '('
                if (testInput.isEmpty() || testInput.peek().equals('(')) {
                    testInput.push(individualCharacter);
                }
                // if character ')' & stack empty - return false
            } else if (individualCharacter == ')' && testInput.empty()) {
                return false;
                // if character ')' & top stack element is '('
            } else if (individualCharacter == ')' && testInput.peek().equals('(')) {
                // push to stack
                testInput.push(individualCharacter);
                // if stack size even number - return true
                if (testInput.size() % 2 == 0) {
                    return true;
                }
                // if character ')' & top stack element is ')'
            } else if (individualCharacter == ')' && testInput.peek().equals(')')) {
                // push to stack
                testInput.push(individualCharacter);
                // if stack size even number - return true
                if (testInput.size() % 2 == 0) {
                    return true;
                }
            }
        }
        // check if stack is empty
        return testInput.isEmpty();
    }
}