package org.wso2.carbon.sample.apimgt.keymgt.handlers.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Component;
import org.wso2.carbon.sample.apimgt.keymgt.handlers.HandlerUtils;
import org.wso2.carbon.utils.CarbonUtils;

import java.io.File;

/**
 * @scr.component name="org.demo.serviceactivator" immediate="true"
 */
public class CustomKeyValidationHandlerServiceComponent {

    private static Log log = LogFactory.getLog(CustomKeyValidationHandlerServiceComponent.class);

    protected void activate(ComponentContext ctxt) {
        try {

            String filePath = CarbonUtils.getCarbonHome() + File.separator + "repository" +
                    File.separator + "conf" + File.separator + "whitelisted_clientid.txt";

            HandlerUtils.readSMSOtpConfig(filePath);

            log.info("CustomKeyValidationHandler has been activated.");
        } catch (Throwable e) {
            log.error("An error occurred while registering CustomKeyValidationHandler.", e);
        }
    }

    protected void deactivate(ComponentContext ctxt) {

    }
}
