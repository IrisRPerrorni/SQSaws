package br.iris.hellowordapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

import java.util.List;

@RestController
@RequestMapping("/app/fila")
public class Controller {
 @Autowired
 SqsClient sqsClient;


//    @PostMapping("/postar")
//    public void contatos(@RequestBody Agenda agenda){
//        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
//                .queueUrl("http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/eventos-criacao-contatos-telefonicos")
//                .messageBody(String.format("Nome:%s, Telefone: %s" , agenda.getNome(),agenda.getTelefone())).build();
//        sqsClient.sendMessage(sendMessageRequest);
//
//    }

    @PostMapping("/postar")
    public ResponseEntity<String> contatoMensagem(@RequestBody Agenda agenda){
        try {
            SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl("http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/eventos-criacao-contatos-telefonicos")
                    .messageBody(agenda.toString()).build();
            sqsClient.sendMessage(sendMessageRequest);
            return ResponseEntity.ok("Mensagem postada na fila SQS com sucesso!");

        }finally {
            sqsClient.close();
        }
    }


}
