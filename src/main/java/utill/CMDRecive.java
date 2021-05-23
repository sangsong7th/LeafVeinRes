package utill;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedInputStream;

public class CMDRecive implements Runnable {

    private PipedInputStream in = null;
    private String result=null;
    private boolean flag=false;
    private boolean classFlag=true;


    public PipedInputStream getPipedInputStream(){
        in = new PipedInputStream();
        return in;
    }

    public CMDRecive(){
        this.flag=true;
    }

    public void tryRun(){
        this.flag=true;
    }


    public void run() {
        while (this.classFlag){
            if(this.flag) {
                this.result="";
                byte[] bys = new byte[1024];

                try {

                    while ((in.read(bys)) != -1) {
                        this.result = this.result+new String(bys).trim();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    this.flag=false;
                }

            }
        }
    }

    public String getResult(){
        return this.result;
    }

    public void getbreak() throws IOException {
        this.classFlag=false;
        in.close();
    }
}
