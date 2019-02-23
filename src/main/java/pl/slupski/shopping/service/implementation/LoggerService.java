package pl.slupski.shopping.service.implementation;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import pl.slupski.shopping.service.interfaces.ILoggerService;

/**
 *
 * @author sluski
 */
public class LoggerService implements ILoggerService {

    private final Gson gson = new Gson();
    private final String logFilePath = System.getProperty("user.home") + "/files/logs.json";

    @Override
    public void saveToLogs(Class clazz, Object object) {
        StringBuilder sr = new StringBuilder();
        sr.append(":CLASS:");
        sr.append(clazz.toString());
        sr.append(" - ");
        sr.append(":OBJECT:");
        sr.append(gson.toJson(object));
        sr.append("\n");

        try (Writer fileWriter = new FileWriter(logFilePath, true)) {
            fileWriter.write(sr.toString());
        } catch (IOException e) {
            System.out.println("Problem occurs when deleting the directory : " + logFilePath);
            e.printStackTrace();
        }

    }

}
