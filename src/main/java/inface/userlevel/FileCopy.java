package inface.userlevel;

public interface FileCopy {

    boolean copy(String path,String markpath);

    boolean recoverCopy();
}
