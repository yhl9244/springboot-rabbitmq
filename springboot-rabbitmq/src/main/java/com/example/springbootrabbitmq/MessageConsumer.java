package com.example.springbootrabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class MessageConsumer {

    /**
     * 单纯接收map的类型的消息
     * @param
     */
	/*@RabbitListener(queues="java_queue")
	@RabbitHandler
	public void handleOrder(Map<String, Object> message){
		System.out.println("收到了订单消息 :" + message.get("name"));
	}*/

    @RabbitListener(queues="message")
    @RabbitHandler
    public void handleEmployeeMsg(@Payload Employee employee, Channel channel,
                                  @Headers Map<String, Object> headers){

        System.out.println("消费者开始接收员工消息 =================");
        System.out.println(employee.getName());
        Long tag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(tag, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
