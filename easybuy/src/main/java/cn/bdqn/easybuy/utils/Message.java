package cn.bdqn.easybuy.utils;

/**
 * Created by Administrator on 2017/12/19.
 */
public class Message {
    private String msg;
    private String look;

    public static Message succeed() {
        Message message=new Message();
        message.setLook("00000");
        message.setMsg("操作成功！！");
        return message;
    }

    public static Message error() {
        Message message=new Message();
        message.setLook("11111");
        message.setMsg("操作失败！！");
        return message;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }
}
