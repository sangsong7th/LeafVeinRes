package impl;

import enity.FileLayerIndexEnity;
import inface.FileLayerIndex;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     the list of FileLayerIndexEnity
 * </p>
 * @author sangsong
 * @since 2021/2/27
 */
public class FileLayerIndexFrist implements FileLayerIndex {

    private ArrayList<FileLayerIndexEnity> fileLayerIndexEnityList=new ArrayList<FileLayerIndexEnity>();

    private long location = 0;

    private String FilePath = "";

    private String Hashcode = "";


    public void pop(FileLayerIndexEnity fileLayerIndexEnity) {

        if(this.location <= 0){
        }else{
            this.location--;
            this.fileLayerIndexEnityList.remove(this.location);
        }

    }

    public void push(FileLayerIndexEnity fileLayerIndexEnity) {

        this.fileLayerIndexEnityList.add(fileLayerIndexEnity);
        this.location++;
    }

    public void pop(FileLayerIndexEnity fileLayerIndexEnity, long index) {
        Long dValue=this.location-index;
        for(int i=0;i<dValue;i++){
            this.fileLayerIndexEnityList.remove(this.location-(i+1));
        }
    }

    public long search(String key) {
        long count=0;
        for(FileLayerIndexEnity fileLayerIndexEnity:this.fileLayerIndexEnityList){
            if(fileLayerIndexEnity.getFilePathEnity().getAbsolutePath().equals(key)){
                return count;
            }
            count++;
        }
        return -1;
    }

    public void insert(FileLayerIndexEnity fileLayerIndexEnity, long index) {
        if(index<this.location){
            fileLayerIndexEnityList.add((int) index,fileLayerIndexEnity);
        }else{
            fileLayerIndexEnityList.add(fileLayerIndexEnity);
        }
        this.location++;

    }

    public void replace(List<FileLayerIndexEnity> fileLayerIndexEnityList, long index) {
        if(fileLayerIndexEnityList==null||fileLayerIndexEnityList.isEmpty()){
            return;
        }

        if(index<this.location){

            List<FileLayerIndexEnity> fileLayerIndexEnitieListTemp=new ArrayList<FileLayerIndexEnity>();
            for(int i=0;i<index;i++){
                fileLayerIndexEnitieListTemp.add(this.fileLayerIndexEnityList.get(i));
            }
            for(FileLayerIndexEnity fileLayerIndexEnity:fileLayerIndexEnityList){
                fileLayerIndexEnitieListTemp.add(fileLayerIndexEnity);
            }

        }else{

            for(FileLayerIndexEnity fileLayerIndexEnity:fileLayerIndexEnityList){
                this.fileLayerIndexEnityList.add(fileLayerIndexEnity);
            }

        }
    }

    private void smallerSpace(){
        this.fileLayerIndexEnityList.trimToSize();
    }

}
