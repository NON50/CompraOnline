package compraonline001;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI ();
        Cliente cliente = new Cliente ();
        
        ui.imprima("Dados do Cliente:");
        cliente.setNome(ui.pedirTexto("Nome: "));
        cliente.setEmail(ui.pedirTexto("Email: "));
        
        ui.pularLinha();
        int qtd = ui.pedirInt("Quantos produtos colocados no carrinho: ");
        Item[] itens = new Item[qtd];
        
        for (int i = 0; i < itens.length; i++){
            Item produto = new Item ();
            ui.imprima("Item" + (1 + i) + "º: ");
            ui.pedirTexto("");
            produto.setNome(ui.pedirTexto("Nome do Produto: "));
            produto.setPreco(ui.pedirDouble("Preço: "));
            
            itens [i] = produto;
            ui.pularLinha();
        }
        
        Compra compra = new Compra ();
        ui.pedirTexto("");
        compra.setCupom(ui.pedirTexto("Cupom de Desconto: "));
        compra.setParcelas(ui.pedirInt("Parcelas: "));
        ui.pedirTexto("");
        compra.setFormaPag(ui.pedirTexto("Forma de Pagamento: "));
        
        compra.setCliente(cliente);
        compra.setCarrinho(itens);
        
        LojaOnline lojaOnline = new LojaOnline ();
        NotaFiscal notinha = lojaOnline.efetuarCompra(compra);
        
        System.out.println(compra.getCupom());
        
        ui.comprovante(notinha);
    }
    
}
