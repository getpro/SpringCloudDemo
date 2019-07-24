package tcp;

import java.io.*;
import java.net.Socket;

/**
 * TCP 客户端
 * Created by irskj on 2019/1/23.
 */
public class ClientTcp implements Closeable {
    private boolean runing = false;
    private Socket socket;
    private String host;
    private int port;
    private MsgListener msgListener;

    public ClientTcp(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public void setMsgListener(MsgListener msgListener) {
        this.msgListener = msgListener;
    }

    public void sendMsg(String msg) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeUTF(msg);
        oos.flush();
    }

    public void sendMsg(byte[] msg) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.write(msg);
        oos.flush();
    }

    public void sendMsg(Command command) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.write(command.toBytes());
        oos.flush();
        System.out.println("发送指令：" + command.toString());
    }

    public void start() throws IOException {
        if (runing) {
            return;
        }
        socket = new Socket(host, port);
        runing = true;
        new Thread(new ReceiveWatch()).start();
    }

    @Override
    public void close() throws IOException {
        runing = false;
        socket.close();
    }


    class ReceiveWatch implements Runnable {
        @Override
        public void run() {
            while (runing) {
                try {
                    //获取Socket的输入流，用来接收从客户端发送过来的数据
                    InputStream in = socket.getInputStream();
                    if (in.available() > 0) {
                        byte[] bytes = new byte[in.available()];
                        in.read(bytes);
                        if (msgListener != null) {
                            msgListener.onMsg(new Command(bytes), ClientTcp.this);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        ClientTcp.this.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 监听消息
     */
    public interface MsgListener {
        void onMsg(Command command, ClientTcp client);
    }

    public static class Command {
        private String head = "AA"; //1byte
        private String type = "02";// 1 byte
        private String id = "";// 4 byte
        private String cm; // 1 byte
        private String len;// 1 byte
        private String data; // n byte
        private String check = "AA";//2byte

        public Command() {
        }

        public Command(byte[] bytes) {
            decode(bytesToHexString(bytes));
        }

        public Command decode(String msg) {
            id = msg.substring((1 + 1) * 2, (1 + 1 + 4) * 2);
            cm = msg.substring((1 + 1 + 4) * 2, (1 + 1 + 4 + 1) * 2);
            len = msg.substring((1 + 1 + 4 + 1) * 2, (1 + 1 + 4 + 1 + 1) * 2);
            data = msg.substring((1 + 1 + 4 + 1 + 1) * 2, msg.length() - 2);
            check = msg.substring(msg.length() - 2);
            return this;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCm() {
            return cm;
        }

        public void setCm(String cm) {
            this.cm = cm;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getCheck() {
            return check;
        }

        public void setCheck(String check) {
            this.check = check;
        }

        public String encode() {
            len = integerToHex(data.length() / 2);
            return head + type + id + cm + len + data + check;
        }

        public byte[] toBytes() {
            return hexStringToBytes(encode());
        }

        @Override
        public String toString() {
            return "{ " +
                    "head:" + head + ", " +
                    "type:" + type + ", " +
                    "id:" + id + ", " +
                    "cm:" + cm + ", " +
                    "data:" + data + ", " +
                    "check:" + check +
                    " }";
        }
    }


    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return new byte[0];
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]) & 0xff);

        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 数字转16进制，奇数补零
     *
     * @param i
     * @return
     */
    public static String longToHex(long i) {
        String s = Long.toHexString(i);
        if (s.length() % 2 != 0) {
            s = "0" + s;
        }
        return s;
    }

    /**
     * 数字转16进制，奇数补零
     *
     * @param i
     * @return
     */
    public static String integerToHex(int i) {
        String s = Integer.toHexString(i);
        if (s.length() % 2 != 0) {
            s = "0" + s;
        }
        return s;
    }
}
