import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Scanner;
class Telefonia {
    private Assinante[] assinantes;
    private int numAssinantes;
    public Telefonia(int maxAssinantes) {
        this.assinantes = new Assinante[maxAssinantes];
        this.numAssinantes = 0;
    }
    private static Assinante criarAssinante() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o tipo de assinante (1 para Pré-pago, 2 para Pós-pago): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o CPF do assinante: ");
        long cpf = scanner.nextLong();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o nome do assinante: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o número do assinante: ");
        String numero = scanner.nextLine();
        if (tipo == 1) {
            return new PrePago(cpf, nome, numero, 100, 50);
        } else if (tipo == 2) {
            return new PosPago(cpf, nome, numero, 100, 150);
        } else {
            System.out.println("Tipo de assinante inválido.");
            return null;
        }
    }
    public void cadastrarAssinante(Assinante assinante) {
        if (numAssinantes < assinantes.length) {
            assinantes[numAssinantes] = assinante;
            numAssinantes++;
            System.out.println("Assinante cadastrado com sucesso!");
        } else {
            System.out.println("Limite de assinantes atingido.");
        }
    }
    public void listarAssinantes() {
        System.out.println("Assinantes Pré-pagos:");
        for (int i = 0; i < numAssinantes; i++) {
            if (assinantes[i] instanceof PrePago) {
                System.out.println(assinantes[i]);
            }
        }
        System.out.println("Assinantes Pós-pagos:");
        for (int i = 0; i < numAssinantes; i++) {
            if (assinantes[i] instanceof PosPago) {
                System.out.println(assinantes[i]);
            }
        }
    }
    public void fazerRecarga() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante pré-pago para recarga: ");
        long cpf = scanner.nextLong();
        scanner.nextLine(); // Limpar o buffer
        PrePago assinante = (PrePago) localizarAssinante(cpf);
        if (assinante != null) {
            System.out.println("Digite o valor da recarga: ");
            float valorRecarga = scanner.nextFloat();
            assinante.recarregar(valorRecarga);
            System.out.println("Recarga realizada com sucesso!");
        } else {
            System.out.println("Assinante pré-pago não encontrado.");
        }
    }
    public void fazerChamada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do assinante: ");
        long cpf = scanner.nextLong();
        scanner.nextLine(); // Limpar o buffer
        Assinante assinante = localizarAssinante(cpf);
        if (assinante != null) {
            if (assinante.podeFazerChamada()) {
                Chamada chamada = criarChamada(); // Adicionado para criar uma chamada
                assinante.fazerChamada(chamada);
                System.out.println("Chamada processada com sucesso!");
            } else {
                System.out.println("Saldo insuficiente para fazer chamada. Faça uma recarga.");
            }
        } else {
            System.out.println("Assinante não encontrado.");
        }
    }
    private Chamada criarChamada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a data da chamada (formato DD/MM/YYYY HH:MM:SS): ");
        String dataString = scanner.nextLine();
        GregorianCalendar data = converterStringParaGregorianCalendar(dataString);
        System.out.println("Digite a duração da chamada em minutos: ");
        int duracaoEmMinutos = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o número discado: ");
        String numeroDiscado = scanner.nextLine();
        return new Chamada(data, duracaoEmMinutos, numeroDiscado);
    }
    private GregorianCalendar converterStringParaGregorianCalendar(String dataString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(sdf.parse(dataString));
            return calendar;
        } catch (Exception e) {
            System.out.println("Erro ao converter data. Utilizando data atual.");
            return new GregorianCalendar();
        }
    }
    public void imprimirFaturas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o mês e o ano para imprimir as faturas (MM/YYYY): ");
        String mesAno = scanner.nextLine();
        String[] partes = mesAno.split("/");
        int mes = Integer.parseInt(partes[0]);
        int ano = Integer.parseInt(partes[1]);
        System.out.println("Faturas do mês " + mes + " de " + ano + ":");
        for (int i = 0; i < numAssinantes; i++) {
            assinantes[i].imprimirFatura(mes, ano);
        }
    }
    private Assinante localizarAssinante(long cpf) {
        for (int i = 0; i < numAssinantes; i++) {
            if (assinantes[i].getCpf() == cpf) {
                return assinantes[i];
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Telefonia telefonia = new Telefonia(100);
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Assinante");
            System.out.println("2. Listar Assinantes");
            System.out.println("3. Fazer Recarga");
            System.out.println("4. Fazer Chamada");
            System.out.println("5. Imprimir Faturas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            switch (opcao) {
                case 1:
                    telefonia.cadastrarAssinante(criarAssinante());
                    break;
                case 2:
                    telefonia.listarAssinantes();
                    break;
                case 3:
                    telefonia.fazerRecarga();
                    break;
                case 4:
                    telefonia.fazerChamada();
                    break;
                case 5:
                    telefonia.imprimirFaturas();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }
}