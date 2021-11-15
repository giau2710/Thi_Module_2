package unit;

import model.Phone;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String FILE_HEADER_PHONE="fullname,gender,address,dateOfBirth,email";
    public static final String fileName="H:\\Case_Study_Module2\\Thi_Module_2\\src\\data\\user.csv";
    public static void writeFileToCSV(ArrayList<Phone> listPhone) {
        FileWriter fileWriter = null;
        try {

            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER_PHONE);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Phone phone : listPhone) {
                fileWriter.append(phone.getNumberPhone());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phone.getGroup());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phone.getFullname());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phone.getGender());
                fileWriter.append(COMMA_DELIMITER);
                String add = phone.getAddress().replace(",",";");
                fileWriter.append(add);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phone.getDateOfBirth());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phone.getEmail());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.close();
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    public static ArrayList<Phone> readFileToCsv() {
        BufferedReader br = null;
        ArrayList<Phone> listPhone = new ArrayList<Phone>();
        try {
            String line;
            br= new BufferedReader(new FileReader(fileName));
            while ((line= br.readLine())!=null){
                String[] splitData=line.split(",");
                if(splitData[0].equals("")){
                    continue;
                }
                Phone phone = new Phone();
                phone.setNumberPhone(splitData[0]);
                phone.setGroup(splitData[1]);
                phone.setFullname(splitData[2]);
                phone.setGender(splitData[3]);
                phone.setAddress(splitData[4]);
                phone.setDateOfBirth(splitData[5]);
                phone.setEmail(splitData[6]);
                listPhone.add(phone);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                br.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return listPhone;
    }
}

