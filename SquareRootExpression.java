public class SquareRootExpression extends FunctionExpression{

    protected Expression value;
    protected Expression result;
    
    SquareRootExpression(Expression value){
        this.value = value;
    }
    
    @Override
    Object getValue() {
        result = execute();
        if(result instanceof DoubleLiteral)
            return (double) result.getValue();      //In this method we assign the result of the execute method to a variable and return it.
        else
            return (int) result.getValue();
    }

    @Override
    Expression execute() {      //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
        
        if(!(value.getValue() instanceof Number))
            throw new IllegalArgumentException("Values must be numbers!");
        
        if(value.getValue() instanceof Double){
            if((double) value.getValue() < 0)
                throw new ArithmeticException("You cannot apply square root to negative numbers!"); 
        }
        else
            if((int) value.getValue() < 0)
                throw new ArithmeticException("You cannot apply negative numbers to square root expression!"); 
        
        if(value.getValue() instanceof Double)
            return new DoubleLiteral(Math.sqrt((double) value.getValue()));
        else if(value.getValue() instanceof Integer)
            return new IntegerLiteral((int) Math.sqrt((int) value.getValue()));
        else
            return new IntegerLiteral(0);
    } 
    
    @Override
    public String toString(){
        return "sqrt( " + value.stringValue() + " )";
    }

}
