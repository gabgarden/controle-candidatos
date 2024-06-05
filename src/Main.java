import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args)
    {

        imprimirCandidatos();
        analisarCandidato(1900.0);
        analisarCandidato(2200.0);
        analisarCandidato(2000.0);

        selecaoCandidato();


        String[] candidatos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        for(String candidato : candidatos)
        {
            entrandoEmContato(candidato);
        }

    }


    static void entrandoEmContato(String candidato)
    {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do
        {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
            {
                tentativasRealizadas++;
            } else
            {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }

        }   while(tentativasRealizadas < 3 && continuarTentando);

        if(atendeu)
        {
            System.out.println("Conseguimos contato com o candidato " + candidato + "na " + tentativasRealizadas+ "a tentativa.") ;
        } else
        {
            System.out.println("Não conseguimos contato com o candidato " + candidato + ".");
        }
    }


    static boolean atender()
    {
        return new Random().nextInt(3)==1;
    }

    static void imprimirCandidatos()
    {
        String[] candidatos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        System.out.println("Imprimindo a lista de candidatos.");

        for(int i = 0; i  < candidatos.length; i++)
        {
            System.out.println((i+1) + "o candidato: " + candidatos[i]);
        }
    }



    static void selecaoCandidato()
    {
        String[] candidatos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length)
        {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou o valor de: " + salarioPretendido);
            if(salarioBase >= salarioPretendido)
            {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            } else
            {
                System.out.println("O candidato " + candidato + " não foi selecionado para a vaga.");
            }
            candidatoAtual++;
        }
    }

    static void analisarCandidato(double salarioPretendido)
    {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido)
        {
            System.out.println("Ligar para o candidato.");
        } else if (salarioBase == salarioPretendido)
        {
            System.out.println("Ligar para candidato com contra proposta.");
        } else
        {
            System.out.println("Aguardando demais candidatos.");
        }
    }


    static double valorPretendido()
    {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
}