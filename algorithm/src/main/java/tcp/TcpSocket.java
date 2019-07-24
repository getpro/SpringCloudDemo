package tcp;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by irskj on 2019/1/23.
 */
public class TcpSocket {
    public static void main(String[] args) throws IOException {

        ClientTcp tcp = new ClientTcp("192.168.4.1", 333);
        tcp.setMsgListener(new ClientTcp.MsgListener() {
            @Override
            public void onMsg(ClientTcp.Command command, ClientTcp client) {
                System.out.println(command.toString());
            }
        });
        tcp.start();
        boolean flag = true;
        ClientTcp.Command command = new ClientTcp.Command();
        command.setId("01020304");
        command.setCheck("AA");
        command.setType("02");
        command.setHead("AA");
        while (flag) {
            System.out.print("请输入：");
            Scanner scanner = new Scanner(System.in);
            String read = scanner.nextLine();
            switch (read) {
                case "0":
                    flag = false;
                    tcp.close();
                    break;
                case "1":
                    command.setCm("01");
                    command.setData("01");
                    tcp.sendMsg(command);
                    break;
                case "2":
                    command.setCm("02");
                    command.setData("01");
                    tcp.sendMsg(command);
                    break;
                case "3":
                    command.setCm("03");
                    command.setData("01");
                    tcp.sendMsg(command);
                    break;
                case "4":
                    command.setCm("04");
                    command.setData("01");
                    tcp.sendMsg(command);
                    break;

                case "5":
                    command.setCm("05");
                    command.setData("01");
                    tcp.sendMsg(command);
                    break;
                case "6":
                    command.setCm("06");
                    command.setData("01");
                    tcp.sendMsg(command);
                    break;
                default:

                    break;
            }
        }
    }
}
