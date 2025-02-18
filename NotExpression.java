public class NotExpression extends UnaryLogicalExpression{
    protected Expression bool;
    protected Expression result;
    
    NotExpression(Expression bool){
        this.bool = bool;
    }
    
    @Override
    Object getValue() {
        result = execute();
        return (boolean) result.getValue();     //In this method we assign the result of the execute method to a variable and return it.
    }

    @Override
    Expression execute() {
        
        if(!(bool.getValue() instanceof Boolean))
            throw new IllegalArgumentException("Expressions must be boolean!");
        
        if((boolean) bool.getValue())                   //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
            return new BooleanLiteral(false);
        else
            return new BooleanLiteral(true);
    }
    @Override
    public String toString(){
        return "!" + bool.stringValue();
    }
}
