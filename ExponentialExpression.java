public class ExponentialExpression extends FunctionExpression {

    protected Expression value;
    protected Expression exponent;
    protected Expression result;

    ExponentialExpression(Expression value, Expression exponent) {
        this.exponent = exponent;
        this.value = value;
    }

    @Override
    Object getValue() {
        result = execute();
        return result;          //In this method we assign the result of the execute method to a variable and return it.
    }

    @Override
    Expression execute() {

        if((value.getValue() instanceof String) || exponent.getValue() instanceof String)
            throw new IllegalArgumentException("You cannot apply String value to this method!");

        if (value.getValue() instanceof Double) {
            double result = calculateResult((double) value.getValue(), (int) exponent.getValue());      //Checking the type of values (if any of them is invalid type throwing exception) and executing the expression.
            return new DoubleLiteral(result);           
        } else{
            int intValue = (int) value.getValue();
            double result = calculateResult((double) intValue, (int) exponent.getValue());
            return new DoubleLiteral(result);
    
        }
            
    }

    private double calculateResult(double value, int exponent) {
        if (exponent == 0) {
            return 1.0;
        } else if (exponent > 0) {
            return value * calculateResult(value, exponent - 1);
        } else {
            return 1.0 / calculateResult(value, -exponent);
        }

    }

    @Override
    public String toString() {
        return value.stringValue() + " ^ " + exponent.stringValue();
    }

}
