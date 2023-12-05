package listener;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Title: ConsumerListener
 * @Author Mr.罗
 * @Package listener
 * @Date 2023/12/4 17:21
 * @description: 消费者监听队列
 */

@Component
public class ConsumerListener implements MessageListener {

    //jackson提供序列化和反序列化中使用最多的类,用来转换json的
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public void onMessage(Message message) {
        //1.将message对象转换成json
        try {
            JsonNode jsonNode = MAPPER.readTree(message.getBody());
            String name = jsonNode.get("name").asText();
            String email = jsonNode.get("email").asText();
            System.out.println("从消息队列中获取到" + name + "的" + "email为:" + email);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
