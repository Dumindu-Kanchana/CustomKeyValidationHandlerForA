package org.wso2.carbon.sample.apimgt.keymgt.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HandlerUtils {
    private static Log log = LogFactory.getLog(HandlerUtils.class);
    public static List<String> consumerKeyList = new LinkedList<>();

    public static void readSMSOtpConfig(String filePath) {

        String sCurrentLine;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((sCurrentLine = br.readLine()) != null) {
                consumerKeyList.add(sCurrentLine.trim());
            }
        } catch (FileNotFoundException e) {
            log.error("Flie cannot be found to Whitelist clientId's from scope validation");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getConsumerKeyList() {
        return consumerKeyList;
    }
}
