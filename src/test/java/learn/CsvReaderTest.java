package learn;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.Matchers.hasItem;

import java.io.FileNotFoundException;
import java.util.List;

public class CsvReaderTest {


    @Test
    public void readProgrammingSkillsFromCsv() throws Exception {
        CsvReader csvReader = new CsvReader();
        List<ProgrammingSkills> programmingSkillsList = csvReader.readProgrammingList("Test_programming.csv");
        Assert.assertNotNull(programmingSkillsList);
        Assert.assertThat(programmingSkillsList,
                hasItem(new ProgrammingSkills("Java EE", "Expert (>5y)", "High" ,"")));
    }

    @Test(expected = FileNotFoundException.class)
    public void assertExceptionThrownOnNonExistingFiles() throws Exception {
        CsvReader csvReader = new CsvReader();
        csvReader.readProgrammingList("sample.csv");
    }

    @Test
    public void assertFileNotFoundThrownWithProperMessage() {
        CsvReader csvReader = new CsvReader();
        try {
            csvReader.readProgrammingList("sample.csv");
        } catch (Exception ex) {
            Assert.assertEquals("File with the name : sample.csv not found", ex.getMessage());
        }
    }

}
