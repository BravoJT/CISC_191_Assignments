import java.io.IOException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException
    {
        FileInputStream importLane;
        FileOutputStream exportLane;
        PrintWriter exporter;
        Scanner seer;
        String fileName;

        System.out.println("Opening ParkPhotos.txt...");
        importLane = new FileInputStream("ParkPhotos.txt");
        seer = new Scanner(importLane);
        System.out.println("File successfully opened, producing info filenames.");
        exportLane = new FileOutputStream("ParkPhotosInfo.txt");
        exporter = new PrintWriter(exportLane);
        while(seer.hasNextLine())
        {
            fileName = seer.nextLine();
            fileName = fileName.substring(0,fileName.indexOf('_'))+"_info.txt";
            exporter.println(fileName);
            System.out.println(fileName);
        }
        /*
            For whatever reason, the exporter doesn't work without this "flush" statement.
            Looking online someone advised that the stream might have been "buffered" and this would fix it.
            This wasn't the case in the practice we did in class, and so my main hypothesis is that it is because
            I'm running the input and output streams simultaneously.
        */
        exporter.flush();
        System.out.println("Info file produced.");
        exportLane.close();
        exporter.close();
        importLane.close();
        seer.close();
    }
}
