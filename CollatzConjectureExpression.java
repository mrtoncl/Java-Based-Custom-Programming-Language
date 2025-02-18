public class CollatzConjectureExpression extends FunctionExpression{

    protected Expression value;
    protected Expression length;
    protected Expression result;
    
    CollatzConjectureExpression(Expression value, Expression length){
        this.length = length;
        this.value = value;
    }
    
    
    @Override
    Object getValue() {
        result = execute();         //In this method we assign the result of the execute method to a variable and return it.
        return result;
    }

    @Override
    Expression execute() {
        if(!(value.getValue() instanceof Integer) || !(length.getValue() instanceof Integer))
            throw new IllegalArgumentException("You cannot apply non-integer value to this method!");
        
        int intValue = (int) value.getValue();
        int intLength = (int) length.getValue();            //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
        
        return new IntegerLiteral(calculateResult(intValue, intLength));
        
    }
    
    private int calculateResult(int value, int length){
        if(length == 0)
            return value;
        else{
            if(value % 2 == 0)
                return calculateResult((value / 2), length - 1);            //Method of the function
            else
                return calculateResult(((3 * value) + 1), length - 1);
        }
    }
}