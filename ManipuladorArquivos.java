import java.io.*;

public class ManipuladorArquivos {
    public void verificarDir(String path){


        File Dir = new File(path);

        if(Dir.exists() && Dir.isDirectory()){
            System.out.println("O diretório já existe");
        }
        else{
            boolean sucesso = new File(path).mkdir();
            System.out.println("Pasta Criado com sucesso: " + sucesso);
        }

    }

    public void verificarFile(String path){
        File file = new File(path);

        if (file.exists() && file.isFile()){
            System.out.println("O arquivo: "+file.getName()+". Já existe");
        }

        else{
            try(FileWriter criar = new FileWriter(path)){
                criar.close();
            }
            catch (IOException e){
                System.out.println("Erro ao abrir o arquivo: "+e.getMessage());
            }
        }

    }


    public void LerArquivo(String path){
        File file = new File(path);
        System.out.println("--------------------------------");
        try(BufferedReader bw = new BufferedReader(new FileReader(path))){
            String linha = bw.readLine();

            while (linha != null){
                System.out.println(linha);
                linha = bw.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Erro ao abrir o arquivo: "+e.getMessage());
        }


    }
}
