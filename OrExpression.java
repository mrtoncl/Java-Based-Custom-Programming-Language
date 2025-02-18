public class OrExpression extends BinaryLogicalExpression{

    protected Expression bool1;
    protected Expression bool2;
    protected Expression result;
    
    OrExpression(Expression bool1, Expression bool2){
        this.bool1 = bool1;
        this.bool2 = bool2;
    }

    @Override
    Object getValue() {
        result = execute();
        return (boolean) result.getValue();     //In this method we assign the result of the execute method to a variable and return it.
    }

    @Override
    Expression execute() {
        
        if(!(bool1.getValue() instanceof Boolean) || !(bool2.getValue() instanceof Boolean))
            throw new IllegalArgumentException("Expressions must be boolean!");
        
        if((boolean) bool1.getValue())
            return new BooleanLiteral(true);        //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
        else{
            if((boolean) bool2.getValue())
                return new BooleanLiteral(true);
            else
                return new BooleanLiteral(false);
        }
    }
    @Override
    public String toString(){
        return bool1.stringValue() + " || " + bool2.stringValue();
    }

}
