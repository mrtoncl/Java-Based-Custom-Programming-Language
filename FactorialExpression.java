public class FactorialExpression extends FunctionExpression {

    protected Expression value;
    protected Expression result;

    FactorialExpression(Expression value) {
        this.value = value;
        
    }
    
    
    @Override
    Object getValue() {
        result = execute();     //In this method we assign the result of the execute method to a variable and return it.
        return result;
    }

    @Override
    Expression execute() {
        if (!(value.getValue() instanceof Integer)) {
            throw new IllegalArgumentException("Factorial can only be applied to integers.");
        }
        
        int intValue = (int) value.getValue();      //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
        if (intValue < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative integers.");
        }

        int factorialResult = factorial(intValue);
        return new IntegerLiteral(factorialResult);
    }
    
    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;                   //Method of the function
        }
        return n * factorial(n - 1);
    }
    
    
    @Override
    public String toString(){
        return value.stringValue() + "!";
    }

}
