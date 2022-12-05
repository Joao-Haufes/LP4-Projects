package lp4_av1;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lp4_av1.dao.Cdao;
import lp4_av1.dao.Pdao;

public class Main {
    
    public void relacionarPed(Pedido ped, Long idCliente) throws SQLException {
        try {
            Pdao pdao = new Pdao();
            Cdao clDAO = new Cdao();
            Cliente c = clDAO.selecionarC(idCliente);
            ped.setCliente(c);
            pdao.adicionar(ped);
            System.out.println("Relacionamento deu certo");
        } catch (SQLException e) {
            System.out.println("Relacionamento deu errado");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws SQLException, ParseException {
        Pdao p1dao = new Pdao();
        Pedido p1 = new Pedido();
        
        Date inicio = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        inicio = formatoData.parse("16/02/2021");
        
        p1.setData(inicio);
        p1.setStatus("Finalizado");
        p1.setValor(78.80);
        
        Cdao cdao;
        Cliente c1 = new Cliente();
        
        c1.setNome("Jussileide");
        c1.setCpf("25632558963");
    
        // Relacionando cliente e pedido
        Main funcao = new Main();
        funcao.relacionarPed(p1,3L);
    }
}
