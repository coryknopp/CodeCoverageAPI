import net.sourceforge.cobertura.coveragedata.ClassData;
import net.sourceforge.cobertura.coveragedata.CoverageDataFileHandler;
import net.sourceforge.cobertura.coveragedata.ProjectData;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        deserialize();
    }

    private static void deserialize() {
        // Loads serialized data file, deserializes using built-in Cobertura method and prints class names in file. All
        // is now accessible, it's just a matter of determining what data we need and how to best store it.
        ProjectData project = CoverageDataFileHandler.loadCoverageData(new File("triangle/cobertura.ser"));
        for (Object obj : project.getClasses()) {
            ClassData classData = (ClassData) obj;
            System.out.println(classData.getName());
        }
    }
}
