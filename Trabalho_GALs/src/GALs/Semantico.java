package GALs;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack();
    Map<String, Integer> vars = new HashMap<String, Integer>();
    String varAtual;
    
    public void executeAction(int action, Token token)	throws SemanticError
    {
        Integer a, b;
        switch(action){
            case 1: // Var
                stack.push(vars.get(token.getLexeme()));
                break;
            case 2: // Num
                stack.push(Integer.parseInt(token.getLexeme(),2));
                break;
            case 3: // Exp
                System.out.println("Exp");
                b = stack.pop();
                a = stack.pop();
                Double exp = Math.pow(a,b);
                stack.push(exp.intValue());
                break;
            case 4: // Div
                System.out.println("Div");
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
                break;
            case 5: // Mult
                System.out.println("Mult");
                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
                break;
            case 6: // Sub
                System.out.println("Sub");
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
                break;
            case 7: // Sum
                System.out.println("Soma");
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
                break;
            case 8: // Show
                System.out.println("Valor na variável " + varAtual + ": " + Integer.toBinaryString(vars.get(varAtual)) + "\n");
                break;
            case 9: // Atribuição
                System.out.println("Atribuiu");
                vars.put(varAtual, stack.pop());
                 break;
            case 10: // Var atribuido
                varAtual = token.getLexeme();
                break;
        }
    }	
}
