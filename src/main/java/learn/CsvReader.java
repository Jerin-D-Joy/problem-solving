package learn;

import com.googlecode.jcsv.reader.CSVEntryParser;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import dummy.DummyClass;

import java.io.*;
import java.util.List;

public class CsvReader {

    public List<ProgrammingSkills> readProgrammingList(String fileName) throws Exception {

        class ProgrammingSkillsEntryReader implements CSVEntryParser<ProgrammingSkills> {
            @Override
            public ProgrammingSkills parseEntry(String... data) {
                String[] skills = data[0].split(",", -1);
                return new ProgrammingSkills(skills[0], skills[1], skills[2], skills[3]);
            }
        }

        try (Reader csvFile = new InputStreamReader(new FileInputStream(fileName))) {
            CSVReader<ProgrammingSkills> programmingSkillsReader = new CSVReaderBuilder<ProgrammingSkills>(csvFile)
                    .entryParser(new ProgrammingSkillsEntryReader()).build();
            return programmingSkillsReader.readAll();
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File with the name : " + fileName + " not found");
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

}
