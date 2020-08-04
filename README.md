# Sistema de análise de dados.
O programa de análise de dados foi desenvolvido no intuito de monitorar uma pasta de nome "in" em "%HOMEPATH%/data/in"
para todos os arquivos .dat que forem adicionados.
Os arquivos .dat devem seguir um padrão em sua composição: devem ser separados por quebra de linha, e os dados informados em cada linha devem ter o separador "ç".

Ex: 
001ç1234567891234çPedroç50000

Os dados seguem um formato para cada tipo de dado diferente.

Os dados de um vendedor, devem iniciar com o código "001", e seguir o padrão:

001çCPFçNomeçSalario

Ex: 001ç1234567891234çPedroç50000

Os dados referentes ao cliente, devem iniciar com  código "002", e seguir o padrão:

002çCNPJçNomeçArea_De_negocio

Ex: 002ç2345675434544345çJose da SilvaçRural

Os dados referentes a venda, devem iniciar com o código "003", e seguir o padrão:

003çID_VENDAç[Produto ID- Quantidade_Do_Produto -Valor_Do_Produto]çNome_Vendedor

Ex: 003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo

Todos os dados que possuírem um ID inválido ou possuirem ausência/excesso de informação, deverão ser ignorados.

Na entrada de arquivos, os Clientes serão filtrados por seus CNPJ's, sendo assim, apenas um cliente por CNPJ deve ser adicionado. No momento em que há a entrada de dados de um cliente com o CNPJ repretido, seus dados devem ser ignorados.
O mesmo vale para os vendedores, que serão filtrados por seus CPF's, e as vendas, que serão filtradas por seus ID's únicos.


Após receber um ou mais arquivos, deve retornar um arquivo .dat com as informações requisitadas na proposta do aplicativo na pasta "out" em "%HOMEPATH%/data/out".
São elas: Quantidade de clientes no arquivo de entrada, quantidade de vendedores no arquivo de entrada, ID da venda mais cara e  o pior vendedor.

Após o arquivo na pasta "out" ser escrito, todos os arquivos da pasta "in" serão apagados.

## Criação da imagem Docker e inicialização de container

No repositório do arquivo, encontra-se uma pasta chamada "Docker". Dentro dela, deve haver um arquivo ".jar" e um arquivo chamado "Dockerfile"

Certifique-se que sua máquina possui o Docker instalado. 

No terminal de sua máquina, digite o comando:

```bash
docker build -t analise_dados/spring-boot-java-data-analisys .
```

Esse comando deve criar a imagem que será usadada no Docker.

Para inicializar o container, digite o comando:

```bash
sudo docker run -p 8080:8080 analise_dados/spring-boot-java-data-analisys
```
Enquanto o sistema estiver rodando, você pode adicionar arquivos à pasta "in" utilizando Postman ou Insomnia com o médoto de requisição POST,
em "http://localhost:8080/dados/upload".

A requisição deve conter a chave "dados", do tipo FILE, e a chave deve conter o arquivo .dat.

No momento em que um ou mais arquivos forem adicionados, o programa deve retornar alguns logs com as informações mais importantes como:
"Cliente adicionado."
"Cliente não  não adicionado pois CNPJ já foi cadastrado."
"Dado ignorado pois o código é inválido."

Ao terminar de analisar os dados, o sistema reve retonar um log de quantos arquivos foram lidos.

Junto ao READ.ME deste diretório, existe um arquivo para teste com o none de "testFileWithAll.dat". 

Ao ser inserido na pasta "in" o sistema retornará alguns logs referentes ao arquivo enviado.

Na pasta "out" um arquivo deve ter sido criado com o filename no formato "dia_dia-da-semana_mes_hora_ano.done.dat"
O arquivo deve conter as seguintes informações:

"A quantidade de clientes registrados nos arquivos processados é: 24.
A quantidade de vendedores registrados nos arquivos processados é: 25.
O ID da venda de maior valor é: 128.
Dos vendedores que fizeram alguma venda, o pior vendedor é o vendedor ANDRE vendendo um total de: R$845.5.
Os vendedores Antonio, Luiz, Jose, Luan, Matheus não fizeram nenhuma venda."

Para acessar essas informações e verificar se elas estão corretas um metodo de requisição do  tipo GET, em "http://localhost:8080/dados/download",
deve retornar as informações do ultimo arquivo criado na pasta "OUT".

Para encerrar o container, utilize o comando: 

```bash
docker stop container analise_dados/spring-boot-java-data-analisy
```

# Tecnologias utilizadas no desenvolvimento do sistema:
Java 14, Sprigboot, Gradle, Docker.
