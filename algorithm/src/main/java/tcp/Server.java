package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by irskj on 2019/1/23.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        boolean f = true;
        while (f){
            Socket ss = socket.accept();
            new Thread(new SocketAction(ss)).start();
        }
        socket.close();
    }

    public static class SocketAction implements Runnable{
        private Socket ss;
        private boolean run=true;

        public SocketAction(Socket s){
            this.ss = s;
            System.out.println("connect "+s.getInetAddress().getHostAddress());
            try {
                sendMsg("from server");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendMsg(String msg) throws IOException {
            OutputStream os = ss.getOutputStream();
            os.write(msg.getBytes());
            os.flush();
        }

        @Override
        public void run() {
            //获取Socket的输出流，用来向客户端发送数据

            try {
                //获取Socket的输入流，用来接收从客户端发送过来的数据
                BufferedReader buf = new BufferedReader(new InputStreamReader(ss.getInputStream()));
                boolean flag =true;
                while(flag){
                    //接收从客户端发送过来的数据
                    String str =  buf.readLine();
                    if(str == null || "".equals(str)){
                        flag = false;
                    }else{
                        if("bye".equals(str)){
                            flag = false;
                        }else{
                            //将接收到的字符串前面加上echo，发送到对应的客户端
                            sendMsg("echo:" + str);
                        }
                    }
                }
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
