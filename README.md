EASTER_EGG_URLS

Solução desenvolvida em linguagem de programação Java (JDK 17) com a finalidade de retornar o conteúdo encontrado na camada mais profunda entre tags HTML.

====================================================================================
 
EXECUÇÃO DA APLICAÇÃO:

Passo 1: utilizando o terminal de linha de comando, navega até o diretório do projeto, dentro do diretório src, e compile o código com:

javac HtmlAnalyzer.java

Passo 2: após a compilação, insira o seguinte comando para executar do programa:

java HtmlAnalyzer

Passo 3: em seguida, será exibida a String "inserir-url-aqui". Neste momento, você poder inserir a URL desejada para execução do programa. Ele retornará o conteúdo HTML encontrado, ou informará sobre alguma inconsistência no conteúdo HTML, ou ainda sobre uma falha de conexão..

====================================================================================

A solução está dividida entre cinco classes, sendo uma delas a classe principal (main) e as outras referentes a objetos, cada uma com seus devidos métodos, com o objetivo de obter os resultados esperados. Estes resultados podem ser:

#1 Retornar o conteúdo HTML;

#2 Retornar "malFormed HTML" quando houver inconsistências entre as tags HTML;

#3 "URL connection error" quando não houver conexão com a internet para acessar a URL que contém o HTML.

Quanto às classes que compõem a solução, temos:

#1 HtmlAnalyzer: onde é encontrado o método main que executará a aplicação;

#2 Connected: classe responsável por verificar se há conexão para efetuar a captura do HTML através da URL. Se não houver conexão, será retornado "false" e, no console, teremos o retorno da String "URL connection error". Caso haja conexão, o programa continuará a verificação e análise do conteúdo HTML;

#3 ScanUrl: classe que possui o método para inserir como entrada a URL da qual se deseja capturar o HTML;

#4 GetHtmlContent: classe que captura o HTML, transformando-o e retornando- num objeto String, através da URL que foi dada como entrada no item anterior;

#5 AnalyzingHtmlContent: classe que recebe o conteúdo HTML convertido em String e verifica se o conteúdo entre as tags está na camada mais profunda, ou se há incoerências na estrutura HTML. Após a verificação, irá retornar no console um dos resultados. A análise de tags e conteúdos é realizada em uma estrutura de repetição, utilizando uma pilha e identificando as tags por meio de expressões regulares (regex).

====================================================================================

Testes realizados com as URLs fornecidas para o exercício:

#1 URL: http://hiring.axreng.com/internship/example1.html /
RETORNO: This is the title.

#2 URL: http://hiring.axreng.com/internship/example2.html /
RETORNO: This is in level 4. Correct result.

#3 URL: http://hiring.axreng.com/internship/example3.html /
RETORNO: malformed HTML

#4 URL: http://hiring.axreng.com/internship/example4.html /
RETORNO: malformed HTML

#5 URL: http://hiring.axreng.com/internship/example5.html /
RETORNO: malformed HTML

#6 URL: http://hiring.axreng.com/internship/example6.html /
RETORNO: Easter egg | Este n&atilde;o &eacute; s&oacute; mais um exemplo
