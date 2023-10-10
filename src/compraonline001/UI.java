package compraonline001;
import java.util.*;

public class UI {
   static Scanner digite = new Scanner(System.in);
    
    public void imprima(String msg, Object... values){
        System.out.printf(msg + "\n", values);
    }
    public void pularLinha() {
        System.out.println();
    }
    public double pedirDouble(String msg, Object... values) {
        System.out.printf(msg, values);
        double valor = digite.nextDouble();
        return valor;
    }

    public int pedirInt(String msg, Object... values) {
        System.out.printf(msg, values);
        int valor = digite.nextInt();
        return valor;
    }

    public String pedirTexto(String msg, Object... values) {
        System.out.printf(msg, values);
        String valor = digite.nextLine();
        return valor;
    }
    
    public void comprovante (NotaFiscal notaFiscal){
        pularLinha();
        pularLinha();
        imprima("=========================");
        imprima("    COMPRA REALIZADA!");
        imprima("=========================");
        
        pularLinha();
        imprima("=========================");
        imprima("         ITENS");
        imprima("=========================");
        for (Item itens : notaFiscal.getItens()){
            System.out.println(itens.getNome() + " - R$ " + itens.getPreco());
        }
        
        pularLinha();
        imprima("=========================");
        imprima("         TOTAL DA COMPRA");
        imprima("         (DESCONTOS INCLUSOS)");
        imprima("=========================");
        System.out.printf("R$ %.2f", notaFiscal.getTotal());
        
        pularLinha();
        imprima("=========================");
        imprima("        ENTREGA"); 
        imprima("=========================");
        imprima("Código: %d", notaFiscal.getCodNota());
        imprima("Cliente: %s", notaFiscal.getCliente().getNome());
        imprima("Valor de cada Parcela: %.2f", notaFiscal.getValorParcelas());
        
        pularLinha();
        imprima("=========================");
        imprima("         FIM");
        imprima("=========================");
        pularLinha();
        pularLinha();
    }
}

