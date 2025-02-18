public class ConditionalExpression extends Expression {
    protected Expression value1;
    protected Expression value2;
    protected ConditionalOperator operator;
    protected Expression result;
    
    ConditionalExpression(Expression value1, Expression value2, ConditionalOperator operator ){
        this.value1 = value1;
        this.value2 = value2;
        this.operator = operator;
    }
    
    @Override
    Object getValue() {
        result = execute();
        return (boolean) result.getValue();         //In this method we assign the result of the execute method to a variable and return it.
    }

    @Override
    Expression execute() {

        if (!operator.toString().equals("==")){
            if((value1.getValue() instanceof String) || (value2.getValue() instanceof String))
                throw new IllegalArgumentException("You cannot apply String value to this method!");
        }

        switch(operator.toString()){
            case "==": 
                if((int) value1.getValue() == (int) value2.getValue())      //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
                    return new BooleanLiteral(true);
                else
                    return new BooleanLiteral(false);
            case "!=":
                if((int) value1.getValue() != (int) value2.getValue())
                    return new BooleanLiteral(true);
                else
                    return new BooleanLiteral(false);
            case "<":
                if((int) value1.getValue() < (int) value2.getValue())
                    return new BooleanLiteral(true);
                else
                    return new BooleanLiteral(false);
            case "<=": 
                if((int) value1.getValue() <= (int) value2.getValue())
                    return new BooleanLiteral(true);
                else
                    return new BooleanLiteral(false);
            case ">":
                if((int)value1.getValue() > (int) value2.getValue())
                    return new BooleanLiteral(true);
                else
                    return new BooleanLiteral(false);
            case ">=":
                if((int) value1.getValue() >= (int) value2.getValue())
                    return new BooleanLiteral(true);
                else
                    return new BooleanLiteral(false);
                
        }
        return new IntegerLiteral(0);
        
    }
    
    @Override
    public String toString(){
        return value1.toString() + " " + operator.toString() + " " + value2.toString();
    }

}
