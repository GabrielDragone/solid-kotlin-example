## SOLID com Java (Só que fiz em Kotlin xD): Princípios da programação orientada a objetos
https://cursos.alura.com.br/course/solid-orientacao-objetos-java

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
