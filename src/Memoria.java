import java.util.ArrayList;
import java.util.List;

class Memoria {
    private List<BlocoDeMemoria> blocos;

    public Memoria(int tamanho) {
        blocos = new ArrayList<>();
        blocos.add(new BlocoDeMemoria(tamanho));
    }

    public boolean alocarPrimeiroAjuste(Instrucoes objeto) {
        for (int i = 0; i < blocos.size(); i++) {
            BlocoDeMemoria bloco = blocos.get(i);
            if (!bloco.isOcupado() && bloco.getTamanho() >= objeto.getTamanho()) {
                if (bloco.getTamanho() > objeto.getTamanho()) {
                    blocos.add(i + 1, new BlocoDeMemoria(bloco.getTamanho() - objeto.getTamanho()));
                }
                bloco.ocupar(objeto);
                return true;
            }
        }
        return false; // Se não encontrar bloco adequado
    }

    public boolean alocarMelhorAjuste(Instrucoes objeto) {
        BlocoDeMemoria melhorBloco = null;
        int melhorIndice = -1;
        for (int i = 0; i < blocos.size(); i++) {
            BlocoDeMemoria bloco = blocos.get(i);
            if (!bloco.isOcupado() && bloco.getTamanho() >= objeto.getTamanho()) {
                if (melhorBloco == null || bloco.getTamanho() < melhorBloco.getTamanho()) {
                    melhorBloco = bloco;
                    melhorIndice = i;
                }
            }
        }
        if (melhorBloco != null) {
            if (melhorBloco.getTamanho() > objeto.getTamanho()) {
                blocos.add(melhorIndice + 1, new BlocoDeMemoria(melhorBloco.getTamanho() - objeto.getTamanho()));
            }
            melhorBloco.ocupar(objeto);
            return true;
        }
        return false;
    }

    public boolean alocarPiorAjuste(Instrucoes objeto) {
        BlocoDeMemoria piorBloco = null;
        int piorIndice = -1;
        for (int i = 0; i < blocos.size(); i++) {
            BlocoDeMemoria bloco = blocos.get(i);
            if (!bloco.isOcupado() && bloco.getTamanho() >= objeto.getTamanho()) {
                if (piorBloco == null || bloco.getTamanho() > piorBloco.getTamanho()) {
                    piorBloco = bloco;
                    piorIndice = i;
                }
            }
        }
        if (piorBloco != null) {
            if (piorBloco.getTamanho() > objeto.getTamanho()) {
                blocos.add(piorIndice + 1, new BlocoDeMemoria(piorBloco.getTamanho() - objeto.getTamanho()));
            }
            piorBloco.ocupar(objeto);
            return true;
        }
        return false;
    }

    public boolean desalocarPorTamanho(int tamanho) {
        for (BlocoDeMemoria bloco : blocos) {
            if (bloco.isOcupado() && bloco.getTamanho() == tamanho) {
                bloco.liberar();
                return true;
            }
        }
        return false;
    }

    public void mostrarMemoria() {
        for (BlocoDeMemoria bloco : blocos) {
            System.out.print(bloco + " ");
        }
        System.out.println();
    }
}