public class ModExpression extends ArithmeticExpression {

    protected Expression value1;
    protected Expression value2;
    protected Expression result;
    
    ModExpression(Expression value1, Expression value2){
        this.value1 = value1;
        this.value2 = value2;
    }
    
    
    
    @Override
    Object getValue() {
        result = execute();
        if(result instanceof DoubleLiteral)     //In this method we assign the result of the execute method to a variable and return it.
            return (double) result.getValue();
        else
            return (int) result.getValue();
    }

    @Override
    Expression execute() {
        if(!(value1.getValue() instanceof Number))
            throw new IllegalArgumentException("Values must be numbers!");
        
        if(value1.getValue() instanceof Double){            //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
            if(value2.getValue() instanceof Double)
                return new DoubleLiteral((double) value1.getValue() % (double) value2.getValue());
            else
                return new DoubleLiteral((double) value1.getValue() % (int) value2.getValue());
        }
        else{
            if(value2.getValue() instanceof Double)
                return new DoubleLiteral((int) value1.getValue() % (double) value2.getValue());
            else
                return new IntegerLiteral((int) value1.getValue() % (int) value2.getValue());
            
        }
    }
    
    @Override
    public String toString(){
        return value1.stringValue() + " % " + value2.stringValue();
    }

}
