package by.samsolution.filebase;



import by.samsolution.commands.modelcommand.AddOptions;
import by.samsolution.commands.modelcommand.FindOptions;
import by.samsolution.filebase.strategy.FileStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuantumCat on 10.06.2017.
 */
public class FileTXT implements FileStrategy {

    public List<String> getStudentsList(FindOptions commandOptions, String filename, String dirname) throws IOException {
        List<String> students = null;
            BufferedReader reader=new BufferedReader(new FileReader(dirname+"/"+filename));
                students = new ArrayList<String>();
                String info = null;
                while ((info = reader.readLine()) != null) {
                        if(info.contains(commandOptions.getAuthor()))
                        {
                            students.add(info);
                        }
                }
                reader.close();
        return students;
    }

    public File createDirAdd(String dirname)
    {
        File dirAdd = new File(dirname);
        if(!dirAdd.exists())
        {
            dirAdd.mkdirs();
        }
        return dirAdd;
    }

    public File createFileAdd(File dirAdd, String filename) throws IOException {
        File fileAdd = new File(dirAdd,filename);
        if(!fileAdd.exists())
        {
            fileAdd.createNewFile();
        }
        return fileAdd;
    }

    public void addStudent(AddOptions commandOptions, String filename, String dirname) throws IOException {
            File dirAdd = createDirAdd(dirname);
            File fileAdd = createFileAdd(dirAdd,filename);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileAdd, true));
                  bufferedWriter.write(commandOptions.getTitle()+" "+
                  commandOptions.getAuthor()+" "+
                  commandOptions.getYear()+" "+
                  commandOptions.getNumber()+"\n");
                bufferedWriter.close();
    }
}
