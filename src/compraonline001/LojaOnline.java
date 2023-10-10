package compraonline001;

public class LojaOnline {

    public NotaFiscal efetuarCompra(Compra compra) {
        int codigo = this.gerarCodNota();
        double totalFinal = calcularTotal(compra);
        double parcelas = calcularParcela(totalFinal, compra.getParcelas());
        
        NotaFiscal notinha = new NotaFiscal();
        notinha.setCliente(compra.getCliente());
        notinha.setItens(compra.getCarrinho());
        notinha.setTotal(totalFinal);
        notinha.setValorParcelas(parcelas);
        notinha.setCodNota(codigo);
        return notinha;
    }

    private double calcularTotal(Compra compra) {
        double total = 0;
        double descontoPag = 0;
        double descontoFinal = 0;
        String formPag = compra.getFormaPag();

        for (Item item : compra.getCarrinho()) {
            total += item.getPreco();
        }

        if (formPag.equals("Débito")) {
            descontoPag = 0.05;
        } else if (formPag.equals("Pix")) {
            descontoPag = 0.1;

        }

        descontoFinal = total - (total * descontoPag);

        double cupom = verificarCupom(compra.getCupom());
        double totalFinal = descontoFinal - cupom;

        return totalFinal;
    }

    private double verificarCupom(String cupom) {
        int desconto = 0;

        switch (cupom) {
            case "QUERO100":
                desconto = 100;
                break;
            case "QUERO200":
                desconto = 200;
                break;
            case "QUERO500":
                desconto = 500;
                break;
        }

        return desconto;
    }

    private double calcularParcela(double total, int parcelas) {
        double juros = 0.03;

        double jurosTotal = total * juros * parcelas;

        double parcelasFinal = (total + jurosTotal) / parcelas;
        return parcelasFinal;
    }

    private int gerarCodNota() {
        int codNota = (int) (Math.random() * 999);
        return codNota;
    }
}
