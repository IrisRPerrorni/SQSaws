package br.iris.hellowordapi;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;

public class Mensagem {
//    public void receberMensagens() {
//        SqsClient sqsClient = SqsClient.create();
//
//        try {
//
//            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
//                    .queueUrl("http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/eventos-criacao-contatos-telefonicos")
//                    .maxNumberOfMessages(5) // Número máximo de mensagens a serem recebidas
//                    .build();
//
//            List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();
//
//            for (Message message : messages) {
//                System.out.println("Corpo da Mensagem: " + message.body());
//            }
//        } finally {
//            sqsClient.close();
//        }
//    }
}
