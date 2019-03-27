package org.wso2.carbon.sample.apimgt.keymgt.handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HandlerUtils {

    public static List<String> consumerKeyList = new LinkedList<>();

    public static void readSMSOtpConfig(String filePath) {

        String sCurrentLine;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((sCurrentLine = br.readLine()) != null) {
                consumerKeyList.add(sCurrentLine.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getConsumerKeyList() {
        return consumerKeyList;
    }
}
