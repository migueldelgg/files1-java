package application;

import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        String path = "c:\\temp\\file1.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            List<Product> list = new ArrayList<>(); // Lista de produtos

            while (line != null) { // enquanto a variavel line for diferente de nula, iremos fazer:

                String[] vect = line.split(","); // vetor com as strings do arquivo armazenado na variavel line

                String name = vect[0];
                double price = Double.parseDouble(vect[1]);
                int qnt = Integer.parseInt(vect[2]);

                Product product = new Product(name, price, qnt); // instancia um novo produto
                list.add(product);

                line = br.readLine();

                String strPath = "c:\\temp"; // local onde sera criado a pasta out

                boolean folder = new File(strPath + "//Out").mkdir();
                // crição do diretorio Out
                System.out.println("Directory created successfully:  " + folder);
                // diretorio criado com sucesso. (deve aparecer apenas um true)

                String newPath = "c:\\temp\\Out\\summary.csv";
                // c:\temp\Out --> caminho em que será criado o arquivo .csv
                // \summary.csv --> nome do arquivo.

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(newPath)))
                //criado um novo BufferedWrite e FileWriter pois nao consigo reutilizar o criado antes (nao sei porque)
                {
                    // percorre uma lista de produtos
                    // para cada produto "e" faça:
                    for (Product e : list) {
                        bw.write(e.getName() + "," + e.value()); // escreve nome do item e o valor total(price * quantity)
                        bw.newLine(); // quebra de linha no arquivo
                    }
                }
            }

        } catch (IOException e) {
            // Captura e imprime mensagens de erro em caso de IOException
            System.out.println("Error " + e.getMessage());
        }
    }


}
