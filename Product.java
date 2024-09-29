import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Product{
    private String nome;
    private Double value;
    private Integer Quantidade;
    private Double totalValue;


    public Product(String nome, Double value, Integer Quantidade, String path){
        this.nome = nome;
        this.value = value;
        this.Quantidade = Quantidade;
        this.totalValue = value * Quantidade;

        File pathFile = new File(path);
        sumario(pathFile);

    }
    private void sumario(File path){

        try(BufferedWriter escritor = new BufferedWriter(new FileWriter(path, true))){
            escritor.write("Nome: "+ nome);
            escritor.write(" Valor total: "+ totalValue);
            escritor.newLine();
        }
        catch (IOException e){
            System.out.println("Erro ao abrir o arquivo: "+e.getMessage());
        }


    }

    @Override
    public String toString(){

        System.out.println("Nome: "+nome+"Valor unitário: "+value+"Qauntidade: " + Quantidade);
        return "Isso";
    }


}

