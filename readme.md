# Estudo com AWS Cli 

1. Crie uma fila usando o AWS CLI de nome 'eventos-criacao-contatos-telefonicos'.(Veja o comando na minha cola ai em cima heehehhe)

2. Cria uma app java com um endpoint POST '/app/fila/postar'. O corpo do post deve ser um json no formado:
   {
   nome: "<NOME QUALQUER>",
   telefone:"<NUMERO QUALQUER>"
   }

3. Na app, quero que você peque o corpo do POST e escreva no corpo da fila SQS

4. Ai quero que você use o comando "#Buscar as mensagens de um SQS"(Na minha cola também!) e me mande um print do resultado no console, com a mensagem enviada pela app java.

Use a lib: AWS SDK for Java 2.x

https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2/example_code/sqs

#Criar SQS
aws --endpoint-url http://localhost:4566 --profile localstack sqs create-queue --queue-name eventos-criacao-contatos-telefonicos 
#Buscar as mensagens de um SQS
aws --endpoint http://localhost:4566 --profile localstack sqs receive-message --queue-url http://localhost:4566/000000000000/sqs-teste --attribute-names All --message-attribute-names All --max-number-of-messages 10
