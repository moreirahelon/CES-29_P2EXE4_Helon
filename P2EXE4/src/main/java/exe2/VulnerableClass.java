package exe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VulnerableClass {
	private BufferedReader _bufferedReader;
	private Scanner _console;

	public void vulnerableMethod(String FILENAME){
		if(!FILENAME.matches("[\\w]*")){
			// Para impedir script, limitando os caracteres que entram.
			// Caso se queira mais caraacteres, tem que mudar!
			throw new IllegalArgumentException();
		}
		while (true) {
		    _console = new Scanner(System.in);
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo>? ");
		    String CaractereDeOperacao = _console.nextLine();
			
		    if (CaractereDeOperacao.equals("R")){
				try {
					String sCurrentLine;

					_bufferedReader = new BufferedReader(new FileReader(FILENAME));

					while ((sCurrentLine = _bufferedReader.readLine()) != null) {
						System.out.println(sCurrentLine);
					}

				} catch (IOException e) {

					e.printStackTrace();

				} 
			}
			
			else if (CaractereDeOperacao.equals("W")){
				  BufferedWriter buffWrite;
				  
				  try {
					buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					String linha = "";
					System.out.println("Escreva algo: ");
				    linha = _console.nextLine();
				    if(!linha.matches("[\\w]*")){
						// Para impedir script, limitando os caracteres que entram.
						// Caso se queira mais caraacteres, tem que mudar!
						throw new IllegalArgumentException();
					}
				    buffWrite.append(linha + "\n");
				     
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}else break;
		}
	}
}
