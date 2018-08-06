package com.my.mqtt.config.mqtt;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by duanp on 2018/8/6.
 */
@Component
@Data
@ConfigurationProperties(prefix = "mqtt.properties")  // 配置文件中的前缀
public class MqttServer {
    private String hostName;   //地址
    private String clientId;   //clientId
    private String appTopic;  //主题
    private String userName;
    private String password;
    private Integer timeout;  //超时时间
    private Integer keepalive;  //
    private MqttClient client ;

    public void connect(){
        try {
            //获取客户端连接
            client=new MqttClient(hostName,clientId);

            //设置参数
            MqttConnectOptions options = new MqttConnectOptions();
            options.setCleanSession(false);
            options.setUserName(userName);
            options.setPassword(password.toCharArray());
            // 设置超时时间
            options.setConnectionTimeout(timeout);
            // 设置会话心跳时间
            options.setAutomaticReconnect(true);
            options.setKeepAliveInterval(keepalive);
            client.setCallback(new PushCallback());
            client.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    /***
     * 发送消息
     * @param sendMsg    消息内容
     */
    public void publish(String sendMsg){
        try {
            connect();
            MqttTopic topic = client.getTopic(appTopic);
            System.out.println("发送的消息内容为:"+sendMsg);
            MqttMessage message = new MqttMessage(sendMsg.getBytes("utf-8"));
            message.setQos(1);
            topic.publish(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

/***
 * 回调函数
 * @author ouyjm
 *
 */
class PushCallback implements MqttCallback {
    @Override
    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连
        System.out.println("连接断开，可以做重连");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // publish后会执行到这里
        System.out.println("deliveryComplete---------"+ token.isComplete());

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
        System.out.println("接收消息主题:"+topic);
        System.out.println("接收消息Qos:"+message.getQos());
        System.out.println("接收消息内容:"+new String(message.getPayload()));

    }
}