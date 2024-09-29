import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManipuladorArquivos bot = new ManipuladorArquivos();
        List<Product> produtos = new ArrayList<>();


        bot.verificarDir("c:\\temp");
        bot.verificarDir("c:\\temp\\out");

        try (FileWriter criar = new FileWriter("c:\\temp\\out\\sumario.csv")){
            System.out.println("craindo o sumario");
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Erro ao criar o arquivo");
        }


        //--------------------------------------------------------------------------------------------------
        System.out.print("bote o nome do arquivo: ");

        String fileName = sc.nextLine();
        String caminho = "c:\\temp\\"+fileName+".csv";

        bot.verificarFile(caminho);
        System.out.println("--------------------------------");
        System.out.println("Verificando os items do arquivo");
        try(BufferedReader leitor = new BufferedReader(new FileReader(caminho))){

            String linha = leitor.readLine();

            if(linha != null){
                while (linha != null){
                    String[] InfoProduto = linha.split(",");


                    String nome = InfoProduto[0];
                    Double value = Double.parseDouble(InfoProduto[1]);
                    Integer quantidade = Integer.parseInt(InfoProduto[2]);


                    Product produto = new Product(nome, value, quantidade,"c:\\temp\\out\\sumario.csv");
                    produtos.add(produto);
                    linha = leitor.readLine();

                }
            }
        }
        catch (IOException e){

            System.out.println("Erro ao abrir o arquivo: "+e.getMessage());

        }

        System.out.println("Arquivo og");
        bot.LerArquivo("c:\\temp\\teste.csv");
        System.out.println("--------------------------------");
        System.out.println("Sumario: ");
        bot.LerArquivo("c:\\temp\\out\\sumario.csv");

        for(Product produto : produtos){
            System.out.println("vai tomar no cu");
            produto.toString();
        }


    }
}




