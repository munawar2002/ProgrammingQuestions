package com.java.programs.others;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheik on 11/27/2017.
 */
public class RenameSubtitles {

    public boolean success = false;

    private String fileFormat;

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    private List<File> getAllFiles(String directory, String type){
        File folder = new File(directory);
        File[] filesAndDirectories = folder.listFiles();
        List<File> files = new ArrayList();
        for (int i = 0; i < filesAndDirectories.length; i++) {
            if (filesAndDirectories[i].isFile() &&
                    filesAndDirectories[i].getName().endsWith(("." + type))) {
                files.add(filesAndDirectories[i]);
            }
        }
        return files;
    }

    public void renameSubtitles(String directory,String videoPattern,
                                String subtitlesPattern){

        List<File> videos = getAllFiles(directory,getFileFormat());
        List<File> subtitles = getAllFiles(directory,"srt");
        renameSubtitles(videos,videoPattern,subtitles,subtitlesPattern,directory);
        if(!success){
            System.out.println("Unable to rename Files.");
        }


    }

    public void renameSubtitles(List<File> videos, String videoPattern,
                                List<File> subtitles,String subtitlesPattern,String directory){

         for (File subtitle : subtitles){

            String subtitleName = subtitle.getName();

            int vPatternLength = videoPattern.length()-1;
            int sPatternLength = subtitlesPattern.length()-1;

            String subs = replaceStringAtIndex(
                    subtitleName,sPatternLength,
                    videoPattern.charAt(vPatternLength));

            String subsFileNumber = subs.substring(sPatternLength-1,sPatternLength+3);

            for(File video : videos){

                if(video.getName().contains(subsFileNumber)){

                    String replacingName = video.getName().replace(getFileFormat(),"srt");
                    System.out.println("-- "+replacingName);
                    File renameFile = new File(directory+"\\"+replacingName);

                    success = subtitle.renameTo(renameFile);
                    if(!success){
                        return;
                    }
                }
            }
        }

        for (File video : videos) {
            System.out.println(video.getName());
        }

        for (File subtitle : subtitles) {
            System.out.println(subtitle.getName());
        }

    }

    private String replaceStringAtIndex(String str,int index, char value){
        char[] myStrs = str.toCharArray();
        myStrs[index] = value;
        str = String.valueOf(myStrs);
        return str;
    }

    public static void main(String[] args) {

        String directory = "C:\\Users\\sheik\\Downloads\\Season 2";
        String videoPattern = "New.Girl.S02E";
        String subtitlesPattern = "New Girl - 2x";

        RenameSubtitles renaming = new RenameSubtitles();
        renaming.setFileFormat("mkv");
        renaming.renameSubtitles(directory,videoPattern,subtitlesPattern);


    }

}
