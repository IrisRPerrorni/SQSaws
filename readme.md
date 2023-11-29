# Estudo com AWS Cli 

1. Crie uma fila usando o AWS CLI de nome 'eventos-criacao-contatos-telefonicos'.

2. Cria uma app java com um endpoint POST '/app/fila/postar'. O corpo do post deve ser um json no formado:
   {
   nome: "<NOME QUALQUER>",
   telefone:"<NUMERO QUALQUER>"
   }

3. Na app, quero que você peque o corpo do POST e escreva no corpo da fila SQS

4. Ai quero que você use o comando "#Buscar as mensagens de um SQS"

Use a lib: AWS SDK for Java 2.x
_______________________________________________
- Com a localstack configurada usar o seguinte comando para criar a fila: 
```bash
#Criar SQS
aws --endpoint-url http://localhost:4566 --profile localstack sqs create-queue --queue-name eventos-criacao-contatos-telefonicos 
```
OBS: Caso não esteja configurada a localstack usar o seguinte comando: 
```bash
aws configure --profile localstack
 Insira as credenciais e a região (por exemplo, us-east-1)
```
- para exemplos de codigos usando sqs

https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2/example_code/sqs

- Execute sua aplicação Java e, em seguida, faça uma solicitação POST para http://localhost:8080/app/fila/postar com o corpo JSON desejado.
- Use o comando AWS CLI para receber mensagens da fila e visualizar no console.
```bash
#Buscar as mensagens de um SQS
aws --endpoint http://localhost:4566 --profile localstack sqs receive-message --queue-url http://localhost:4566/000000000000/eventos-criacao-contatos-telefonicos --attribute-names All --message-attribute-names All --max-number-of-messages 10
```
