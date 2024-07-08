public class Instrucoes {
    //private boolean[] ocupacao;
    public int tamanho; 

    public Instrucoes(int quant_KB){
        this.tamanho = quant_KB;
    }

    public int getTamanho(){
        return tamanho;
    }

    public String toRetorno(){
        return "Objeto {tamanho = " + tamanho + "}";
    }
   
}
