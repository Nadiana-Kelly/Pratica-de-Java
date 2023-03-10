
import java.util.Scanner;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

class Main {
	  public static LocalDate obter_data() {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Data de referencia: ");
			
			String dt = scanner.nextLine();

		  	// Parseio a data baseado-se num formato específico
			LocalDate ld  = LocalDate.parse(dt, 
            DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		  	return ld;
	  }
	
	  public static void main(String[] args) {
            System.out.println("\n ");
			LocalDate  data = obter_data();
		  
		    System.out.print("Digite o dia de vencimento: ");
		  	Scanner scanner = new Scanner(System.in);
		  	int dia_vencimento = scanner.nextInt();
		  
			System.out.print("Digite a quantidade de dias de corte: ");
		  	int dias_corte = scanner.nextInt();

		  	// obtenho o dia atual
			int dia_atual = data.getDayOfMonth();

		  	// Checando por dados incoerentes..
			if(dia_vencimento <= dia_atual) {
				System.out.println("Dia de vencimento anterior ou igual ao dia atual\n");
			} else if(dia_vencimento-dia_atual < dias_corte) {
				System.out.println("Informacoes incoerentes\n");
			} else {
				// nesse ponto os dados já foram validados
				LocalDate  data_vencimento = data;
				// somando alguns dias na data_vencimento
				data_vencimento = data_vencimento.plusDays(dia_vencimento-dia_atual);

				LocalDate  dia_apuracao = data_vencimento;
				// subtraindo algunas dias em dia_apuracao
				dia_apuracao = dia_apuracao.minusDays(dias_corte);

				int dia  = data_vencimento.getDayOfMonth();
				int mes  = data_vencimento.getMonthValue();
				int ano  = data_vencimento.getYear();

                System.out.println("\n ");
                
				System.out.println("Data de Vencimento: " + dia + "/" + mes + "/" + ano);

				dia  = dia_apuracao.getDayOfMonth();
				mes  = dia_apuracao.getMonthValue();
				ano  = dia_apuracao.getYear();
				
				System.out.println("Data de Apuracao: " + dia + "/" + mes + "/" + ano);
			}
  
		  	scanner.close();	
	  }
}
