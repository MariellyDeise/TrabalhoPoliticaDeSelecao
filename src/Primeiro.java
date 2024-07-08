
class BlocoDeMemoria {
    private int tamanho;
    private boolean ocupado;
    private Instrucoes objeto;

    public BlocoDeMemoria(int tamanho) {
        this.tamanho = tamanho;
        this.ocupado = false;
        this.objeto = null;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar(Instrucoes objeto) {
        this.ocupado = true;
        this.objeto = objeto;
        this.tamanho = objeto.getTamanho();
    }

    public void liberar() {
        this.ocupado = false;
        this.objeto = null;
    }

    @Override
    public String toString() {
        return "(" + tamanho + "," + ocupado + ")";
    }
}