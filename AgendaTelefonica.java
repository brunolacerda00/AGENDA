import java.util.ArrayList;
import java.util.Scanner;

class Contato {
    String nome;
    String numero;

    public Contato(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Número: " + numero;
    }
}

public class AgendaTelefonica {
    static ArrayList<Contato> contatos = new ArrayList<>();

    public static void cadastrarContato() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite o número do contato: ");
        String numero = scanner.nextLine();
        
        Contato novoContato = new Contato(nome, numero);
        contatos.add(novoContato);
        System.out.println("Contato cadastrado com sucesso!");
    }

    public static void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Não há contatos cadastrados.");
        } else {
            System.out.println("Contatos cadastrados:");
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    public static void excluirContato() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o nome do contato a ser excluído: ");
        String nomeExcluir = scanner.nextLine();
        
        boolean encontrado = false;
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).nome.equalsIgnoreCase(nomeExcluir)) {
                contatos.remove(i);
                encontrado = true;
                System.out.println("Contato excluído com sucesso!");
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    cadastrarContato();
                    break;
                case 2:
                    listarContatos();
                    break;
                case 3:
                    excluirContato();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }
}
