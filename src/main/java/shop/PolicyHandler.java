package shop;

import shop.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    /*@StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrdered_Ship(@Payload Ordered ordered){

        if(ordered.isMe()){
        	// business logic
        	// CJ 대한통운 전문 교환 
        	// 주문자에게 배송 시작 알림 sms 발송
        	// 배송정보 저장 (save)
            System.out.println("##### listener Ship : " + ordered.toJson());
        }
    }*/
    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrdered_Ship(@Payload Ordered ordered){
    
        if(ordered.isMe()){
            Delivery delivery = new Delivery();
            delivery.setOrderId(ordered.getId());
            delivery.setStatus("SHIPPED");
    
            deliveryRepository.save(delivery);
        }
    }

}
