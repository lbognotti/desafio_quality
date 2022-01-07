# Sobre o Projeto

O objetivo deste projeto é aplicar os conteúdos dados até o momento durante o
Programa de aceleração MeLi (Git, Java e Spring), com ênfase principal nas validações e
tipos de teste que podem ser usados a partir de uma proposta, um especificação de
requisitos e documentação anexa.

# Ferramentas Utilizadas

- Java
- Spring boot
- Maven
- Lombok
- Mockito

# Instalação

Segue abaixo as instruções para instalação do nosso projeto.

1 - Clone o nosso repositório

```sh
git clone https://github.com/lbognotti/desafio_quality
```
2 - Abre com a sua IDE de preferência

# Executando Testes

<strong> Nesta primeira imagem é sinalizado como executar um teste de forma completa,
passando por todos os outros testes existentes dentro da PropertyServiceTest</strong>

<img src=˜images/img_runtest_03.png>

<strong> Nesta segunda imagem é sinalizado onde executar o teste de forma individual, ou seja,
executando somente este teste dentro da PropertyServiceTest</strong>

<img src=˜images/img_runtest_01.png>

<strong> Nesta terceira imagem é sinalizado onde executar o teste de forma individual e as várias formas de executar e logo abaixo exibindo
o resultado do teste dentro da PropertyServiceTest</strong>

<img src=˜images/img_runtest_02.png>

# Testes Unitários e Validações de Entradas

- Teste para retornar a area total de uma propriedade
```sh
@Test
deveRetornarAAreaTotalDaPropriedade
```
- Teste para validar se os valores da propriedade sao 0
```sh
@Test
naoDeveCadastrarUmComodoComValoresDeAreasIgual0
```
- Teste para validar se os valores da propriedade sao negativos
```sh
@Test
naoDeveCadastrarUmComodoComValoresDeAreasNegativos
```
- Teste para validar o cadastro de uma nova propriedade
```sh
@Test
deveCadastrarUmComodoComValoresInteiroPositivo
```
- Testa se retorna o maior cômodo dada uma propriedade
```sh
@Test
deveRetornarOMaiorComodoDaPropriedade
```
- Teste retorna uma excessao ao buscar uma propridade que nao esta cadastrada
```sh
@Test
deveRetornarUmaExceptionQuandoNaoEncontrarUmaProperty
```
- Teste retorna uma excessao ao buscar um bairro que nao esta cadastrado
```sh
@Test
deveRetornarUmaExceptionQuandoNaoEncontrarUmDistrict
```
- Teste para validar o total da propridade
```sh
@Test
deveRetornarOvalorTotalDaPropriedade
```
- Testa se de fato o total de metros quadrados por cômodo está correto.
```sh
@Test
deveRetornarAsAreasDeCadaComodoDeUmaPropriedade
```
- Testa se o método getRoomArea do serviço lança um NullPointerException com mensagem nula quando
o método findByName do repository retornar null por nõ encontrar o registro no repositório
```sh
@Test
deveLancarExcecaoQuandoOFindByNameRetornaNullNoGetRoomArea
```

# Autores

- <strong>Everson Okuhara</strong> - Desenvolvedor e Documentação
- <strong>Lucas Matos</strong> - Desenvolvedor
- <strong>Ronaldd Pinho</strong> - Desenvolvedor
- <strong>Tiago Wolsen</strong> - Desenvolvedor
- <strong>Vinicius Feitoza</strong> - Desenvolvedor e Documentação

# Expressões de Gratidão

Agradecemos todo o suporte neste desafio aos membros da DH @Kenyo @Mauri @Joice @Michele @Betania e @Michelle e também o pessoal do Meli 🙂 <br>
Agracedimento especial a cada membro do grupo G8 que dedicaram e deram o seu máximo neste desafio! 🤝
