package sample;
import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Scanner;

public class GenericSongList {
    HashMap<Integer, String> songList;

    GenericSongList(String listName){
        readSongFile(listName);
        System.out.println("loaded");
    }

    public void songListPut(int ID, String songName){
        songList.put(ID, songName);
    }

    public HashMap<Integer, String> getSongList(){
        return songList;
    }

    public void readSongFile(String fileName){
        try{
            String file = fileName+".csv";
            Scanner in = new Scanner(new File(file));
            songList = new HashMap<Integer, String>();
            String[] line;
            while(in.hasNext()){
                line = in.nextLine().split(",");
                songList.put(Integer.parseInt(line[0]),line[1]);
            }
        }
        catch(IOException e){
            System.out.println("Error while reading file " + fileName);
        }
    }
}