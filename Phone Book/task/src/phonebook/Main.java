package phonebook;

import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {

        String names = "C:\\Users\\kennyigbechi\\IdeaProjects\\gre\\find.txt";
        String dir = "C:\\Users\\kennyigbechi\\IdeaProjects\\gre\\directory.txt";

        linearSearch(dir, names);

    }


    protected static List<String> importdir(String path){

        File file = new File(path);

        List<String> contents = new ArrayList<>();
        String temp;

        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                contents.add(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }

        return contents;
    }


    public static void linearSearch(String directory, String items){
        List<String> dir = importdir(directory);
        List<String> names = importdir(items);

        int count = 0;

        System.out.println("Start searching...");



        int total = names.size();

        long startTime = System.currentTimeMillis();
        for(String n : names){
            for(String d : dir){
                if(d.contains(n)){
                    count++;
                    break;
                }

            }
        }

        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;

        Duration d = Duration.ofMillis(duration);
        int minutes = d.toMinutesPart();
        int second = d.toSecondsPart();
        int miliseconds = d.toMillisPart();

        String result = String.format("Found %d / %d entries. Time taken: %d min. %d sec. %d ms.", count, total, minutes, second, miliseconds);
        System.out.println(result);
    }

}
