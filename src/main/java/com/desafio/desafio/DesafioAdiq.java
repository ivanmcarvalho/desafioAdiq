package com.desafio.desafio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

public class DesafioAdiq {
	
	public static void main(String[] args) {
		
		// Coletar dados de Autorização
		Scanner entrada = new Scanner(System.in);
		
		String grantType = "client_credentials";
		String clientId = "aC2yaac23";
		String clientSecret = "1bhS45TT";
		String emproducao = "N";
		boolean fim = false;
		
		do {
			emproducao = JOptionPane.showInputDialog("Trabalhar em Produção (S/N)", emproducao);
			grantType = JOptionPane.showInputDialog("grantType", grantType);
			clientId = JOptionPane.showInputDialog("Cliente ID", clientId);
			clientSecret = JOptionPane.showInputDialog("Cliente Secret", clientSecret);			
			
			
			String confirmaDados = "grantType: " + grantType + "\n" +
								   "Client Id: " + clientId + "\n" +
								   "Client Secret: " + clientSecret + "\n" +
								   "As informações acima estão corretas?";
			
			int resposta = JOptionPane.showConfirmDialog(null, confirmaDados);	
			
			if(grantType    != null && 
			   clientId     != null &&
			   clientSecret != null &&
			   resposta     == JOptionPane.YES_OPTION) 
			{
				// Preparar Dados para Autorização		
				Auth auth = new Auth(grantType, clientId, clientSecret, emproducao.toUpperCase());
				if(Auth.autorizado) {
					JOptionPane.showMessageDialog(null, "Autorizado, tenha um bom dia de trabalho!\n" + Auth.resposta + "\n" + Auth.accessToken);
					String opMenu = null;
					do {
						opMenu = JOptionPane
						         .showInputDialog("*** Menu Transações ***\n" +
				                                  "1 - Solicitar pagamento\n" + 
				                                  "2 - Consulta informações de pagamento\n" + 
				                                  "3 - Cancelar Pagamento\n" +
				                                  "4 - Sair"
						        		         );
						switch(opMenu) {
							case "1":
								Payment pag = new Payment();
								break;
							case "2":
								String paymentId = JOptionPane.showInputDialog("Id do Pagamento: ");
								CheckPayment infoPag = new CheckPayment(paymentId);
								break;
							case "3":
								CancelPayment cancPag = new CancelPayment();
								break;
						}
						
					} while(!opMenu.equals("4"));
					fim = true;
				} else {
					JOptionPane.showMessageDialog(null, "Não Autorizado, tente novamente!\n" + Auth.resposta + "\n" + Auth.accessToken);
				}								
					
			}
			
			if (resposta == JOptionPane.CANCEL_OPTION) 
			{
				fim = true;
			}

		} while(!fim);
		
		 
		
		
		entrada.close();
	}

}
