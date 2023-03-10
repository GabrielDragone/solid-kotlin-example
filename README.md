## SOLID com Java (Só que fiz em Kotlin xD): Princípios da programação orientada a objetos

### Link para o curso:

https://cursos.alura.com.br/course/solid-orientacao-objetos-java

### Anotações:
* **S**_ingle Responsibility Principle_
* **O**_pen Closed Principle_
* **L**_iskov Substitution Principle_
* **I**_nterface Segregation Principle_
* **D**_ependency Inversion Principle_

1. Orientação a Objetos:
   1. Apresentação:
      * Utilizamos os princípios do SOLID para escrever um código que seja mais fácil de manter, entender, adicionar novas características, comportamentos, e funcionalidades com o menor impacto possível.
      * 3 princípios importantes de POO: Coesão, Encapsulamento e Acoplamento.
   2. Projeto inicial do treinamento:
   https://caelum-online-public.s3.amazonaws.com/2051-solid-java-principios-programacao-orientada-objetos/2051-solid-java-projeto_inicial.zip
   3. Coesão:
      * Coesão:
        * União harmônica entre uma coisa e outra. 
        * Harmonia entre elementos.
        * Atributos e métodos devem estar em harmonia e representar coisas em comum.
        * A classe precisa ter uma única responsabilidade.
        * As classes não coesas tendem a crescer indefinidamente, o que as tornam difíceis de manter.
   4. Classes coesas:
      * Definição de uma classe coesa, seria uma classe que executa bem a sua única tarefa, de forma concisa. Cada classe deve ser responsável por apenas uma coisa, e deve executar essa tarefa muito bem.
   5. Encapsulamento:
      * Incluir ou proteger alguma coisa em uma cápsula.
      * Proteger uma classe de influências externas.
      * Exemplo: Um atributo salário, não pode ser alterado diretamente, teria que passar por um método de reajuste para validar se o aumento do salário é menor que determinado percentual, ou seja, passa por uma regra negocial antes de ser alterada. 
      * A alteração direta por set seria uma violação no encapsulamento.
      * Classes não encapsuladas permitem violação de regras de negócio, além de aumentarem o acoplamento.
   6. Protegendo o código:
      * Getters e setters por si só não fornecem nenhum tipo de encapsulamento. Isso, na verdade, quebra o encapsulamento da nossa classe. 
      * Encapsulamento ajuda no uso correto dos objetos. Ao encapsular o acesso a determinados dados, liberando acesso apenas ao necessário, os objetos da nossa classe se tornam mais fáceis de serem utilizados.
   7. Acoplamento:
      * Ação de acoplar. Agrupamento aos pares. 
      * Dois componentes ligados entre si que causam uma dependência entre eles. 
      * O acoplamento em si não é ruim. O problema é ter um acoplamento muito forte entre as classes, uma classe conhecer muitos detalhes da outra.
      * Classes acopladas causam fragilidade no código da aplicação, o que dificulta sua manutenção. 
      * Exemplo manutenção de uma classe que quebra funcionalidades de outra. 
   8. Dependências no código:
      * É impossível criar um bom sistema sem nenhum tipo de acoplamento. 
      * É normal alguma classe precisar da outra, para que essa não tenha muitas responsabilidades.
      * Cabe a nós desenvolvedores, analisamos se determinado acoplamento com as dependências faz sentido

2. Melhorando a coesão:
   1. Extraindo a lógica de reajuste salarial:
      * O objetivo da classe Funcionario, é representar o que é o conteúdo de funcionário do domínio dessa aplicação.
      * O método reajustarSalario não está coeso com a classe Funcionario.
      * Esse foi extraido para uma nova classe chamada ReajusteService, onde colocamos a regra negocial de reajustar salario.
      * Na classe de Funcionario, apenas criamos um novo método de atualizarSalario, pois essa não precisa saber como é realizado o reajuste, precisa apenas atualizar o mesmo.
    2. Extraindo classe:
       * Refatoração é uma alteração no código que visa melhorar sua clareza e entendimento. Servem para melhorar o design do código, e não o funcionamento do sistema. Uma refatoração não deve influenciar em nada no funcionamento.
    3. Single Responsibility Principle:
       * Just because you can, doesn’t mean you should.
       * Só pq podemos ter o sistema inteiro escrito em uma única classe, não significa que deveríamos ter, pois estaríamos ferindo a coesão e dificultando na manutenção. 
       * Uma classe deveria ter apenas um único motivo para mudar. 
       * Quando aplicamos esse princípio, estamos focando em manter uma alta coesão em nosso código.
    4. Definição de SRP:
       * Ao extrair uma nova classe, vimos que agora temos classes com menos responsabilidades, o que facilita na manutenção, e esse é o conceito de Single Responsibility Principle.
       * Uma classe (ou módulo, função, etc) deve ter apenas uma responsabilidade bem definida.

3. Reduzindo o acoplamento:
   2. Extraindo validações:
     * Imaginamos um cenário onde o RH nos informou que um funcionário só pode ter um reajuste a cada 6 meses.
     * Então antes de realizarmos o reajuste, iremos realizar a validação da data.
     * Realizando a tratativa dos meses dentro do método reajustarSalarioDoFuncionario, o mesmo começa a aumentar a complexidade do método, fazendo com que cada vez que houvesse uma nova regra, o método e a classe tivesse cada vez mais linhas o que dificultaria a manutenção.
     * Um modo de realizar a tratativa seguindo os padrões SOLID, seria extrair a validação de percentual e de periodicidade para classes de Validações (ValidacaoPercentualReajuste e ValidacaoPeriodicidadeEntreReajustes).
     * Criamos uma interface chamada ValidacaoReajuste que será implementada em cada uma das classes criadas acima.
     * Se analisarmos, agora as validações não se conhecem mais e a Service também não sabe quais as validações, pois estamos nos referenciando à interface que é um conceito de abstração de validações.
     * Na Classe ReajusteService, chamamos uma lista de ValidacaoReajuste Interface antes de realizar a atualização do salário do cliente.
     * Se surgir uma nova validação, não precisaremos mais alterar a ReajusteService e sim criar uma nova classe implementando a ValidacaoReajuste e o método validar.
       * A classe que chamar a Service terá que passar as validações.
   3. Muitas validações:
      * O problema encontrado na classe ReajusteService é que enquanto novas validações de reajustes fossem criadas, novas condições deveriam ser adicionadas, fazendo-a crescer interminavelmente.
   4. Open Closed Principle:
      * Princípio Aberto/Fechado (OCP).
      * “Open chest surgery is not needed when putting on a coat”. Você não precisa abrir seu peito para colocar um novo comportamento, que seria colocar um casaco.
      * Ao em vez de toda nova regra, adicionarmos um novo código e mexer na mesma classe, a gente extrai utilizando interfaces e polimorfismo para tornar a classe mais extensível.
      * Entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão (adicionar novos comportamentos), porém fechadas para modificação (evitando ao máximo mexer em código existente).
      * Devemos poder criar novas funcionalidades e estender o sistema, sem precisar modificar muitas classes já existentes.
      * Uma classe que tende a crescer “para sempre” é uma forte candidata a sofrer alguma espécie de refatoração.
   5. Garantindo que o sistema seja extensível:
      * Para garantir que nosso sistema esteja extensível da forma correta, precisamos garantir que cada ação/responsabilidade esteja na classe correta.

4. Herança indesejada:
   2. Implementando uma nova regra de negócio:
      * Nova funcionalidade de promover o funcionário (subir de cargo).
      * Criamos uma classe chamada PromocaoService com as validações: Se Funcionário já for Gerente, não deve deixar ser promovido. 
      * Se o funcionário tiver batido a meta, pegamos o cargoAtual e chamamos o método abstrato que forçará a implementação do próximo cargo através das constantes do enum.
      * Se funcionário não tiver batido a meta, então lança exception.
   3. Utilizando herança da maneira errada:
      * Além de Funcionarios a empresa precisa gerenciar os Terceirizados.
      * Iremos criar um Terceirizado herdando de Funcionario com um atributo a mais que seria a empresa. 
        * Obs: Nesse caso, como estou utilizando Kotlin, tive que criar uma classe abstrata chamada BaseFuncionario, com os atributos padrões do Funcionario e fazer essa ser extendida nas classes Funcionario e Terceirizado, pois o Kotlin não permite herança de data class, devido aos métodos gerados automaticamente através dos atributos no construtor.
      * Quando realizamos a Herança de classes, temos que ter cuidado pois tudo que tem na Classe mãe, será herdada para a Classe filha. Então nesse cenário que temos, um Terceirizado não poderia ser promovido (PromocaoService), pois quem controla isso, é a empresa dele.
      * Uma forma de reverter isso, seria subscrever os métodos promover e atualizar salário, ou deixando em branco, ou lançando alguma exception quando Terceirizado tivesse esses invocados. Porém isso seria um indício de que não estamos utilizando a Herança da maneira correta, pois se não utilizarei determinados métodos e atributos, logo não preciso deles.
   4. Herança:
      * Quando estendemos uma classe através de herança, devemos sempre respeitar os contratos (interfaces) de seus métodos. Uma classe não deve herdar métodos e atributos que não fazem sentido para ela.
   5. Liskov Substitution Principle:
      * “Se parece como um pato, faz quack igual um pato, mas precisa de baterias, você provavelmente tem uma abstração errada.” 
      * “Se q(x) é uma propriedade demonstrável dos objetos x de tipo T, então q(y) deve ser verdadeiro para objetos y de tipo S, onde S é um subtipo de T” - Barbara Liskov. 
      * O Princípio de Substituição de Liskov diz que devemos poder substituir classes base por suas classes derivadas em qualquer lugar, sem problema.
      * Traduzindo o enigma acima, PromocaoService.promover que recebe Funcionario (terá um comportamento), se passarmos um Terceirizado que herda de Funcionario, não deveriam gerar um efeito colateral, tudo deveria funcionar corretamente. Porém o Terceirizado não deve receber promoção pela empresa e logo não deveria ser possível passá-lo no método promover.
      * Dessa forma ferimos o princípio de Liskov, pois usamos a Herança de maneira errada para reaproveitar alguns atributos e acabou tendo comportamentos inesperados, tendo funções que não deveriam receber aquele tipo de objeto e tendo métodos (dentro da classe model) que não faziam sentido, que lançariam exception. 
      * Uma solução seria utilizar composição e retirar a Herança de Terceirizado ou até mesmo a classe abstrata como utilizei, pois o Terceirizado não estaria herdando de Funcionario.
   6. Alternativa à herança:
      * Quando a herança não fizer sentido (métodos e atributos não utilizados), podemos utilizar composição para evitar duplicação de código.

5. Trabalhando com abstrações:
   2. Criando abstrações com interfaces e polimorfismo:
      * Uma interface costuma ser mais estável, muda menos, pois ela só define o contrato.
      * Já uma classe costuma ser mais instável, pois muda a toda hora.
      * O ideal seria depender sempre de coisas mais estáveis como as interfaces, pois ela dá mais segurança.
      * No exemplo do curso, criamos a interface de Validacoes e sempre que uma validação nova fosse adicionada, precisamos apenas criar uma nova implementação da interface, mas na classe ReajusteService não mexeremos, tornando a mesma mais estável por depender só de interfaces.
   3. Dependency Inversion Principle:
      * “Quando você vai ligar uma lâmpada na sua casa, você não pega um fio e solda diretamente na fiação elétrica”.
      * “Abstrações não devem depender de implementações. Implementações devem depender de abstrações”.
      * No exemplo do Curso, as implementações de Validações de Percentual e Periodicidade dependem da interface de contratado ValidacaoReajuste, não ao contrário.
      * Quando implementamos o princípio O do SOLID, somos inducidos a implementar o S (implementações em classes distintas), O e D.
   4. Vantagem ao criar dependências com interfaces:
      * Caso uma determinada implementação mude, não seremos afetados, pois dependemos apenas da sua interface.
      * Quando um método muda a forma como realiza sua tarefa, desde que a interface se mantenha, não vamos precisar nos preocupar nem em editar nosso código.
   5. Interface Segregation Principle:
      * “Uma classe não deveria ser forçada a depender de métodos que não utilizará”.
      * Ou seja, no exemplo utilizado, foram criadas duas classes: A Anuenio e a Promocao, essas que implementaram a interface Reajuste que continham três métodos, sendo eles: valor(), data() e valorImpostoDeRenda().
      * Para a classe Promocao, o último método valorImpostoDeRenda(), fazia sentido a implementação, já para Anuenio não.
      * Dessa forma, estariamos forçando Anuenio a implementar um método que não seria utilizado.
      * Para corrigirmos e deixarmos o código mais fácil para fazer manutenção e estender, o correto seria criarmos uma nova interface ReajusteTributavel com o contrato de valorImpostoDeRenda() e retirar esse de Reajuste. 
      * Dai teriam duas alternativas: 
        * Fazer a classe Promocao implementar Reajuste e ReajusteTributavel. 
        * Ou fazer a interface ReajusteTributavel (que só tem um contrato) herdar de Reajuste que continham os outros dois contratos.
   6. Definição do ISP:
      * Classes não devem ser obrigadas a implementar métodos que não irão precisar. 
      * Para isso, uma interface deverá ser extraída apenas com métodos necessários para a classe implementar.
   9. O que aprendemos?
      * É mais interessante depender de interfaces (classes abstratas, assinaturas de métodos e interfaces em si) do que das implementações de uma classe, pois elas podem mudar a todo momento.
      * Interfaces são mais estáveis, pois não sofrem mudanças a todo momento, enquanto implementações podem mudar a qualquer hora.
      * O Princípio de Inversão de Dependência diz que implementações devem depender de abstrações e abstrações não devem depender de implementações. 
      * Interface devem definir apenas os métodos que fazem sentido para seu contexto.
      * Uma classe não deve ser obrigada a implementar um método que ela não precisa, isso se chama Princípio de Segregação de Interfaces.
