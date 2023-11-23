# Telefonia Celular Revisada
Componentes do grupo: Mario Celso Zanin - matrícula 0050832311042 E Gabriel Henrique Tasso Martins - matrícula 0050832121043

Descrição do Sistema:  

O sistema deverá ser baseado em um menu com as seguintes opções:
a) Cadastrar assinante: o sistema deverá solicitar o tipo de assinante, prépago
ou póspago.
Depois solicitar os dados do assinante específico;
b) Listar assinantes: o sistema deverá listar os dados de todos os assinantes prépagos
seguida
de uma listagem de todos os assinantes póspagos
cadastrados;
c) Fazer chamada: o sistema deverá solicitar o tipo de assinante e seu CPF. Depois solicitar os
dados da chamada, data e duração;
d) Fazer recarga: o sistema deverá solicitar o CPF de um assinante prépago.
Depois solicitar a
data e o valor da recarga;
e) Imprimir faturas: o sistema deverá solicitar o mês e o ano e imprimir todas as faturas dos
assinantes prépagos
e póspagos;
f) Sair do programa: encerra a execução do programa.
3. Descrição das Classes
A seguir serão descritas as classes do sistema.

Assinante
A classe Assinante é abstrata possui 5 atributos:
a) cpf: CPF do assinante;
b) nome: nome completo do assinante;
c) numero: número do telefone celular do assinante.
d) chamadas: vetor de referências a objetos da classe Chamada (vide seção 3.5), representa
as chamadas feitas pelo assinante;
e) numChamadas: número de chamadas feitas pelo assinante.
O construtor desta classe deve inicializar os seus atributos com os argumentos do construtor
e instanciar o vetor chamadas.
Os métodos da classe Assinante são descritos a seguir:
a) long getCpf(): devolve o CPF do assinante;
b) String toString(): devolve uma representação textual dos atributos de um assinante;
c) void fazerChamada(): método abstrato;
d) void imprimirFatura(): método abstrato.

PrePago
A classe PrePago possui 5 atributos:
a) recargas: vetor de referências a objetos da classe Recarga (vide seção 3.6), representa as
recargas de crédito feitas pelo assinante;
b) numRecargas: número de recargas feitas pelo assinante;
c) creditos: representa o número de créditos do assinante;
O construtor desta classe deve inicializar o CPF, nome e número do telefone do assinante e instanciar o vetor recargas.
A seguir são descritos os métodos da classe PrePago:
a) void fazerChamada(GregorianCalendar data, int duracao): este método é utilizado para registrar uma chamada de um assinante prépago em uma data e com uma duração em minutos dadas por seus argumentos. O método deve verificar se ainda há espaço no vetor chamadas e se o assinante tem créditos suficientes para fazer a chamada. O custo de uma chamada prépaga é de R$ 1,45 por minuto. Se a chamada for bem sucedida, ela deve ser armazenada no vetor chamadas, o número de chamadas (atributo numChamadas) e os créditos do assinante (atributo creditos) devem ser atualizados; caso não seja possível fazer a chamada, exiba mensagens apropriadas;
b) void recarregar(GregorianCalendar data, float valor): este método é utilizado para registrar uma recarga de uma assinante prépago em uma data e com um valor dados por seus argumentos. O método deve verificar se ainda há espaço no vetor recargas, caso afirmativo, a recarga deve ser armazenada neste vetor e o número de recargas (atributo numRecargas) e os créditos do assinante (atributo creditos) devem ser atualizados; caso não haja mais espaço no vetor recargas, exibir mensagem apropriada.
c) void imprimirFatura(int mes, int ano): este método deve ser utilizado para imprimir a fatura de uma assinante prépago em um mês dado por seu argumento. O método deve imprimir os dados do assinante (CPF, nome e número do telefone), a data, duração e valor de suas chamadas feitas no mês e ano, e a data e valor de suas recargas feitas no mês e ano. Deve imprimir também o valor total de todas as ligações e recargas do mês e ano e o seus créditos.

PosPago
A classe PosPago possui 1 atributo:
a) assinatura: valor da assinatura do serviço póspago.
O construtor desta classe deve inicializar todos os seus atributos com os argumentos do construtor.
A seguir são descritos os métodos da classe PosPago:
a) void fazerChamada(GregorianCalendar data, int duracao): este método é utilizado para registrar uma chamada de um assinante póspago em uma data e com uma duração em minutos dadas por seus argumentos. O método deve verificar se ainda há espaço no vetor chamadas, caso afirmativo, a chamada deve ser armazenada neste vetor e atualizar o número de chamadas (atributo numChamadas). O custo de uma chamada póspaga é de R$ 1,04 por minuto. Caso não haja mais espaço no vetor chamadas, exiba uma mensagem apropriada;
b) void imprimirFatura(int mes,int ano): este método deve ser utilizado para imprimir a fatura de um assinante póspago em um mês dado por seu argumento. O método deve imprimir os dados do assinante (CPF, nome e número do telefone), a data, duração e valor de suas chamadas feitas no mês e ano. Deve imprimir também o valor total da fatura, que é a soma da assinatura (atributo assinatura) com o custo de todas as ligações do mês e ano.

Chamada
A classe Chamada possui 2 atributos:
a) data: data da realização da chamada (objeto da classe GregorianCalendar);
b) duracao: duração da chamada em minutos.
O construtor desta classe inicializa seus atributos com os argumentos do construtor. A seguir são descritos os métodos da classe Chamada:
a) GregorianCalendar getData(): devolve o atributo data;
b) int getDuracao(): devolve o atributo duracao;
c) String toString(): devolve uma representação textual dos atributos da classe. Recomendase usar a classe SimpleDateFormat para formatar a data no formato dd/MM/yyyy.

Recarga
A classe Recarga possui 2 atributos:
a) data: data da realização da recarga (objeto da classe GregorianCalendar);
b) valor: valor em reais da recarga.
O construtor desta classe inicializa seus atributos com os argumentos do construtor. A seguir são descritos os métodos da classe Recarga:
a) GregorianCalendar getData(): devolve o atributo data;
b) float getValor(): devolve o atributo valor;
c) String toString(): devolve uma representação textual dos atributos da classe. Recomendase usar a classe SimpleDateFormat para formatar a data no formato dd/MM/yyyy.

Telefonia
A classe Telefonia possui 2 atributos:
a) assinante: um vetor de referências a objetos do tipo Assinante. Representa os assinantes cadastrados pela empresa de telefonia celular;
b) numAssinantes: representa a quantidade assinantes cadastrados. O construtor desta classe instancia o vetor assinantes.
A seguir são descritos métodos da classe Telefonia:
a) void cadastrarAssinante(Assinante assinante): este método é invocado quando a primeira opção do menu do sistema (Cadastrar assinante) for selecionada. Este método recebe um assinante com todas as suas informações preenchidas e armazena o objeto no vetor assinantes e incrementa o número de assinantes cadastrados. Se não houver mais espaço no vetor, exibir uma mensagem ou lançar uma exceção;
b) void listarAssinantes(): este método é invocado quando a segunda opção do menu do sistema (Listar assinantes) é selecionada. O método exibe no vídeo o CPF, nome e número do telefone de todos os assinantes prépagos seguidos de uma listagem de todos os assinantes póspagos cadastrados;
c) void fazerChamada(Assinante assinante): este método é invocado quando a terceira opção do menu do sistema (Fazer chamada) é selecionada. O método recebe o assinante que deseja fazer a chamada como parâmetro e solicita a duração e a data da chamada e registra a chamada para o assinante através do método fazerChamada();
d) void fazerRecarga(PrePago prePago): este método é invocado quando a quarta opção do menu do sistema (Fazer recarga) é selecionada. O método recebe um assinante do tipo prépago como parâmetro e solicita o valor e a data da recarga e registra a recarga para o assinante prépago através do método recarregar() da classe PrePago;
e) Assinante localizarAssinante(long cpf): este método devolve o assinante registrado no vetor assinates que possuir o CPF igual ao fornecido como argumento para este método. Caso o assinante não seja localizado, o método devolve null;
f) void imprimirFaturas(): este método é invocado quando a quinta opção do menu do sistema (Imprimir faturas) é selecionada. O método deve solicitar um mês e ano e imprimir as faturas deste mês e ano de todos os assinantes prépagos seguida das faturas do assinantes póspagos;
g) static void main(String[] args): este método deve instanciar um objeto da classe Telefonia, exibir repetidamente o menu de opções e invocar os métodos apropriados a partir da seleção do usuário.
