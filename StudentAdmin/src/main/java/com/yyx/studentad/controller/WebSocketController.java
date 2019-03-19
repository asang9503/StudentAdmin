package com.yyx.studentad.controller;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/**
 * 阿桑
 * 2019/3/19
 */
@ServerEndpoint("/msg")
@Component
public class WebSocketController {
    static Logger logger = Logger.getLogger("webSocket");
    private static int onlineCount = 0;
    private static CopyOnWriteArraySet<WebSocketController> webSocketSet = new CopyOnWriteArraySet<>();
    private Session session;
    private String sid = "";

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        logger.info("有新成员加入:" + sid + ",当前在线人数为" + getOnlineCount());
        this.sid = sid;
        sendMsg("连接成功");
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        logger.info("有人退出聊天！当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String msg, Session session) {
        logger.info("收到来自窗口" + sid + "的消息:" + msg);
        for (WebSocketController webSocketController : webSocketSet) {
            webSocketController.sendMsg(msg);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.warning("发生错误");
        error.printStackTrace();
    }

    public void sendMsg(String msg) {
        try {
            this.session.getBasicRemote().sendText(msg);
        } catch (IOException e) {
            logger.warning("发生异常:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketController.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketController.onlineCount--;
    }
}