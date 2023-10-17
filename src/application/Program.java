package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		String inputFile = "src\\arquivo.csv";
		String outputFile = "out/arquivo.csv";
		
		File outputDir = new File("out");
		
		if(!outputDir.exists()) {
			outputDir.mkdir();
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
	             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
			
			String line;
			
			while ((line = br.readLine()) != null) {
                
				String[] parts = line.split(",");
                
                if (parts.length == 3) {
                    String product = parts[0].replace("\"", "");
                    double value = Double.parseDouble(parts[1]);
                    int quantity = Integer.parseInt(parts[2].replace("\"", ""));
                    double total = value * quantity;

                    // Escrever os dados no arquivo de resumo
                    bw.write(product + "," + total);
                    bw.newLine();
                }
            }

            System.out.println("Arquivo de resumo criado em: " + outputFile);
            System.out.println();
			
			}catch(IOException e){
			System.out.println("Error: "+ e.getMessage());
		}
		
		 try(BufferedReader br = new BufferedReader(new FileReader(outputFile))){ 
          
			 String line = br.readLine();
			 
	         while (line != null) {
	        	 
	        	System.out.println(line);
     			line = br.readLine(); 
         	}
		 }catch(IOException e) {
			 System.out.println("Error: " + e.getMessage());
		 }
	}
}
