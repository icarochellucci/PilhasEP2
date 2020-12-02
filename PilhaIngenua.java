import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class PilhaIngenua {

    protected int capacity;
    public static final int CAPACITY = 8;
    protected Integer [] pilha;
    protected int size;

    public PilhaIngenua ( ) {
    capacity = CAPACITY;
    pilha = new Integer [capacity];
    size = 0;
    }
    
    public void add (int newElement) {
        if (size == capacity){
            capacity += CAPACITY;
            Integer [] tmp = new Integer [capacity];
            for (int j=0;j<size;j++)
                tmp[j]=pilha [j];
            pilha = tmp;
        }
        pilha [size] = newElement ;
        size ++;
    }

    public int remove () {

        int tmpRemov = pilha[size-1];
        --size;

        Integer [] tmp = new Integer [capacity];

        for (int j=0;j<size;j++) {
            tmp[j] = pilha[j];
        }
        pilha = tmp;

        return tmpRemov;
    }
	
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner arquivos = new Scanner(System.in);
        // Inserir o local de entrada de arquivos
        System.out.println("Especifique o caminho do arquivo de entrada: ");
        // EXEMPLO===> "C:\\entradas\\tarefas1000.txt"
        String entradaArquivos = arquivos.nextLine();
        // Inserir o local de sa√≠da de arquivos
        System.out.println("Especifique o caminho do arquivo de saÌda e seu tÌtulo a ser criado: ");
        // EXEMPLO==> "C:\\saidas\\PIsaidas\\PIsaidas1000.txt"
        String saidaArquivos = arquivos.nextLine();
    	long start = System.currentTimeMillis(); // In√≠cio do cron√¥metro  
        File entradaDados = new File (entradaArquivos);        
        arquivos.close();
	        try{
	        	Scanner dados = new Scanner(entradaDados);
	            FileWriter fileWriter = new FileWriter(saidaArquivos);
	            PrintWriter printWriter = new PrintWriter(fileWriter);
                PilhaIngenua pilhaIngenua = new PilhaIngenua();
	            while(dados.hasNext()){
	                String leitura = dados.nextLine();
	                if (leitura.equals("")){
	                    String proximo = Integer.toString(pilhaIngenua.remove());                   
	                    printWriter.print(proximo);
	                    printWriter.print("\n");
	                    printWriter.flush();
	                }else{pilhaIngenua.add(Integer.parseInt(leitura));}
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