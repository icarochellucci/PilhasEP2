import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PilhaEsperta {
    public static void main (String [] args){
        Scanner arquivos = new Scanner(System.in);
        // Inserir o local de entrada de arquivos
        System.out.println("Especifique o caminho do arquivo de entrada: ");
        // EXEMPLO===> "C:\\entradas\\tarefas1000.txt"
        String entradaArquivos = arquivos.nextLine();
        // Inserir o local de sa√≠da de arquivos
        System.out.println("Especifique o caminho do arquivo de saÌda e seu tÌtulo a ser criado: ");
        // EXEMPLO==> "C:\\saidas\\PEsaidas\\PEsaidas1000.txt"
        String saidaArquivos = arquivos.nextLine();
    	long start = System.currentTimeMillis(); // In√≠cio do cron√¥metro  
        File entradaDados = new File (entradaArquivos);        
        Stack <String> stack = new PilhaArranjo <String> (); // instancia da pilha de string
        arquivos.close();
        try{
            Scanner dados = new Scanner(entradaDados);
            FileWriter fileWriter = new FileWriter(saidaArquivos);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            while(dados.hasNext()){
                String leitura = dados.nextLine();
                if (leitura.equals("")){
                    String proximo = stack.pop();                   
                    printWriter.print(proximo);
                    printWriter.print("\n");
                    printWriter.flush();
                }else{stack.push(leitura);}
            }
            printWriter.close();
            dados.close();
        }catch (IOException ex){
        	System.out.println("Erro ao escrever arquivo: " + ex.getMessage());
        }
        long end = System.currentTimeMillis();// fim do cronometro
        double total = (double) (end - start)/1000;
        System.out.println("ComeÁo do programa = "+start);
        System.out.println("Fim do programa = "+end);
        System.out.println("Tempo total = "+total+" segundos");
    }
}