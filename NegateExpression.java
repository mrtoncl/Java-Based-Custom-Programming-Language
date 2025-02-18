public class NegateExpression extends ArithmeticExpression{

    protected Expression value;
    protected Expression result;
    
    NegateExpression(Expression value){
        this.value = value;
    }

    @Override
    Object getValue() {
        result = execute();
        if(result instanceof DoubleLiteral)
            return (double) result.getValue();          //In this method we assign the result of the execute method to a variable and return it.
        else            
            return (int) result.getValue();
    }

    @Override
    Expression execute() {
        if((value.getValue() instanceof String))
            throw new IllegalArgumentException("You cannot apply String value to this method!");

        if(value.getValue() instanceof Double)                           //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
            return new DoubleLiteral((double) value.getValue() * (-1));
        else
            return new IntegerLiteral((int) value.getValue() * (-1));
    }
    
    @Override
    public String toString(){
        return "-" + value.toString();
    }
}
