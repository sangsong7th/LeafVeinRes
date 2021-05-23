package impl;

import inface.cmd.CMDRUN;
import utill.*;

import java.io.*;

public class CMDRUNTemp implements CMDRUN {



    public String run(String order) {

//        CMDSender sender = new CMDSender();
//        CMDRecive recive = new CMDRecive();
//        PipedOutputStream po = sender.getPipedOutputStream();
//        PipedInputStream pi = recive.getPipedInputStream();
//        try {
//            pi.connect(po);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        new Thread(sender).start();
//        new Thread(recive).start();
        CMDSender sender = new CMDSender("cmd /c \"C:  && dir\"");
        CMDRecive recive = new CMDRecive();
        PipedOutputStream po = sender.getPipedOutputStream();
        PipedInputStream pi = recive.getPipedInputStream();

        try {
            pi.connect(po);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(sender).start();
        new Thread(recive).start();

        System.out.println(recive.getResult());

        return null;
    }



}
