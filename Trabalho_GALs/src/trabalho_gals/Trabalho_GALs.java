package trabalho_gals;
import GALs.Sintatico;
import GALs.*;
import java.io.IOException;
import java.io.StringReader;
/**
 *
 * @author Gustavo
 */
public class Trabalho_GALs {

    public static void main(String[] args) throws IOException{
        try{
            Lexico lexico = new Lexico(new StringReader("A = 10; B = 11; B = 111 + A * B; Show( B );"));
            //Lexico lexico = new Lexico(new StringReader("A = 11*((10+100)/10); Show(A);"));
            //Lexico lexico = new Lexico(new StringReader("A = (10+(10^10)/10)+(10*10-10); B = 10; Show(A);"));
            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        }
        catch(LexicalError | SyntaticError | SemanticError e){
            System.out.println("Num tem esse comando não!");
        }
    }
    
}
