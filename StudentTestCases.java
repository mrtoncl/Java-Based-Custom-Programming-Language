public class StudentTestCases {

	private StudentTestCases() { }
	
	static void testCase1()
	{
            System.out.println("testCase1()");
            System.out.println("---------------------------");
            
            
            Expression e1 = new IntegerLiteral(5);
            Expression e2 = new IntegerVariable("e2", 7);
            Expression e3 = new IntegerLiteral(-3);
            
            System.out.println(e1 + "! = " + new FactorialExpression(e1).execute());
            try{
                System.out.println(e2 + "! = " + new FactorialExpression(e3).execute());
            }
            catch(Exception e){
                System.out.println(e);
            }
            System.out.println(e2 + "! = " + new FactorialExpression(e2).execute());
            
            
            
            System.out.println();
	}

	static void testCase2()
        {
            
            System.out.println("testCase2()");
            System.out.println("---------------------------");
            
            Expression e1 = new DoubleLiteral(2.5);
            Expression e2 = new IntegerLiteral(3);
            Expression e3 = new IntegerLiteral(2);
            Expression e4 = new DoubleVariable("e4", -3.8);
            Expression e5 = new IntegerVariable("e5", -4);
            Expression e6 = new StringLiteral("Selam");
            
            System.out.println(e1 + " ^ " + e3 + " = " + new ExponentialExpression(e1, e3).getValue() );
            System.out.println(e2 + " ^ " + e3 + " = " + new ExponentialExpression(e2, e3).execute() );
            System.out.println(e4 + " ^ " + e2 + " = " + new ExponentialExpression(e4, e2).execute() );
            try{
                System.out.println(e6 + " ^ " + e2 + " = " + new ExponentialExpression(e6,e2).execute());
            }
            catch(Exception e){
                System.out.println(e);
            }
            System.out.println(e2 + " ^ " + e5 + " = " + new ExponentialExpression(e2, e5).execute() );
            
            
        
            System.out.println();
        }

	static void testCase3()
        {
            System.out.println("testCase3()");
            System.out.println("---------------------------");
            
            Expression e1 = new IntegerLiteral(25);
            Expression e2 = new IntegerVariable("e2", 9);
            Expression e3 = new DoubleLiteral(22.5);
            Expression e4 = new DoubleVariable("e4", 5.5);
            Expression e5 = new StringLiteral("Selam!");
            Expression e6 = new IntegerLiteral(-12);
            Expression e7 = new IntegerLiteral(5);

            
            System.out.println(e1 + " % " + e2 + " = " + new ModExpression(e1,e2).execute());
             try{
                 System.out.println(e5 + " % " + e1 + " = " + new ModExpression(e5,e2).execute());
            
            }
             catch(Exception e){
                 System.out.println(e);
            }

            System.out.println(e3 + " % " + e2 + " = " + new ModExpression(e3,e2).execute());
            System.out.println();

            System.out.println("Square root of " + e1 + " is " + new SquareRootExpression(e1).execute());
            
            try{
                System.out.println("Square root of " + e6 + " is " + new SquareRootExpression(e6).execute());
            }
            catch(Exception e){   
                System.out.println(e);
            }
            System.out.println("Square root of " + e3 + " is " + new SquareRootExpression(e3).execute());
            System.out.println();

            System.out.println("Collatz Conjecture of " + e1 + " is " + new CollatzConjectureExpression(e1, e7).execute());
            try{
                System.out.println("Collatz Conjecture of " + e4 +" is " + new CollatzConjectureExpression(e4, e3).execute());
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("Collatz Conjecture of " + e2 +" is " + new CollatzConjectureExpression(e2, e2).execute());

            
            System.out.println();
            
        }
	
}
