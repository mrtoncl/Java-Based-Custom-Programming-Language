public class IfExpression extends Expression{
    protected Expression condition;
    protected Expression ifBody;
    protected Expression elseBody;
    protected Expression result;
    
    IfExpression(Expression condition, Expression ifBody, Expression elseBody){
        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }
    
    @Override
    Object getValue() {
        result = execute();
        if(result.getValue() instanceof String)
            return result.stringValue();
        else if(result.getValue() instanceof Double)                //In this method we assign the result of the execute method to a variable and return it.
            return (double) result.getValue();
        else
            return (int) result.getValue();
    }

    @Override
    Expression execute() {
        if((boolean) condition.getValue())
            return ifBody.execute();
        else
            return elseBody.execute();
    }
    
    @Override
    public String toString(){
        return "if " + "(" + condition.toString() + ") " + "{ " + ifBody.toString() + " }" + " else " + "{ " + elseBody.toString() + " }";
    }

}
