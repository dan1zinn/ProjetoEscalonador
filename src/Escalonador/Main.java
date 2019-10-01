package Escalonador;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {
	static ArrayList<Processo> prioridadeBaixa = new ArrayList<Processo>();
	static ArrayList<Processo> prioridadeMedia = new ArrayList<Processo>();
	static ArrayList<Processo> prioridadeAlta = new ArrayList<Processo>();
	static Random r = new Random();
	static ArrayList<Processo> processosfinalizados = new ArrayList<Processo>();
	static Processo processo = new Processo();
	static int quantb, quantm, quanta;
	 static void novo() {
		
		
		
		
		String auxiliar = JOptionPane.showInputDialog(null, "processos de baixa prioridade>>:");
		quantb = Integer.parseInt(auxiliar);
		auxiliar = JOptionPane.showInputDialog(null, " processos de média prioridade>>:");
		quantm = Integer.parseInt(auxiliar);
		auxiliar = JOptionPane.showInputDialog(null, " processos de Alta prioridade>>:");
		quanta = Integer.parseInt(auxiliar);
		
		System.out.print(quantb);
		System.out.print(quanta);
		System.out.println(quantm);
		
	
		
		for(int index2 = 1; index2<=quantb;index2++) {
			processo = new Processo();
			processo.setID(index2 + "");
			processo.setPrioridade(1);
			processo.setTempo(r.nextInt(10));
			prioridadeBaixa.add(processo);
		}
		System.out.println(prioridadeBaixa);
		
		
		

		for(int index1 = 1; index1<=quantm;index1++) {
			processo = new Processo();
			processo.setID(index1 + "");
			processo.setPrioridade(2);
			processo.setTempo(r.nextInt(10));
			prioridadeMedia.add(processo);
		}
		System.out.println(prioridadeMedia);
		
		
		for(int index = 1; index<=quanta;index++) {
			processo = new Processo();
			processo.setID(index + "");
			processo.setPrioridade(3);
			processo.setTempo(r.nextInt(10));
			prioridadeAlta.add(processo);
		}
		System.out.println(prioridadeAlta);
		
				
				
						
			
		}

	
	public static void pronto() {

		while(prioridadeAlta.isEmpty() == false|| prioridadeMedia.isEmpty()==false||prioridadeBaixa.isEmpty()==false) {
			for(int t=0;t<4 && prioridadeAlta.isEmpty() == false;t++) {
				Processo auxiliar1;
				Processo auxiliar2;
				auxiliar1 = new Processo();
				auxiliar2 = new Processo();
				
				processo = new Processo();
				processo = prioridadeAlta.get(prioridadeAlta.size()-1);
				processo = executa(processo);
				
				
				if(processo.getTempo() == 0) {
					try {
						
					finalizado(processo);
					prioridadeAlta.remove(prioridadeAlta.size() - 1);
					processo = prioridadeAlta.get(prioridadeAlta.size() - 1);
					}
					catch(Exception a){
						
					}
					
				}
				
				auxiliar1 = processo;
				for(int indext = 0;indext< prioridadeAlta.size() - 1; indext ++) {
					auxiliar2 = prioridadeAlta.get(indext);
					prioridadeAlta.set(indext, auxiliar2);

				}
				
				
			}
			
			for(int t=0;t<2 && prioridadeMedia.isEmpty() == false;t++) {
				Processo auxiliar1;
				Processo auxiliar2;
				auxiliar1 = new Processo();
				auxiliar2 = new Processo();
				
				processo = new Processo();
				processo = prioridadeMedia.get(prioridadeMedia.size()-1);
				processo = executa(processo);
				
				
				if(processo.getTempo() == 0) {
					try {
						
					finalizado(processo);
					prioridadeMedia.remove(prioridadeMedia.size() - 1);
					processo = prioridadeMedia.get(prioridadeMedia.size() - 1);
					}
					catch(Exception a){
						
					}
					
				}
				
				auxiliar1 = processo;
				for(int indext = 0;indext< prioridadeMedia.size() - 1; indext ++) {
					auxiliar2 = prioridadeMedia.get(indext);
					prioridadeMedia.set(indext, auxiliar2);
	
				}
				
				
			}
			
			
			for(int t=0;t<1 && prioridadeBaixa.isEmpty() == false;t++) {
				Processo auxiliar1;
				Processo auxiliar2;
				auxiliar1 = new Processo();
				auxiliar2 = new Processo();
				
				processo = new Processo();
				processo = prioridadeBaixa.get(prioridadeBaixa.size()-1);
				processo = executa(processo);
				
				
				if(processo.getTempo() == 0) {
					try {
						
					finalizado(processo);
					prioridadeBaixa.remove(prioridadeBaixa.size() - 1);
					processo = prioridadeBaixa.get(prioridadeBaixa.size() - 1);
					}
					catch(Exception a){
						
					}
					
				}
				
				auxiliar1 = processo;
				for(int indext = 0;indext< prioridadeBaixa.size() - 1; indext ++) {
					auxiliar2 = prioridadeBaixa.get(indext);
					prioridadeBaixa.set(indext, auxiliar2);	
				}
				
				
			}
			
			
			
		}
	}
	public static Processo executa(Processo processo) {

		
		try {
			Thread.sleep(500);
			
		}
		catch(InterruptedException a) {
			
		}
		processo.setTempo(processo.getTempo() - 1);
		return processo;
		
		
		
	}
	public static void  finalizado(Processo processo2) {
				processosfinalizados.add(processo);
				System.out.println("Processos Finalizados" + processosfinalizados);
				
				
				
				
				
			
		}
		
		
	

	public static void main(String[]Args) {
		novo();
		pronto();
		System.out.println(prioridadeAlta);
		System.out.println(prioridadeMedia);
		System.out.println(prioridadeBaixa);
		
		
	}
}
