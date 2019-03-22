package org.wso2.carbon.sample.apimgt.keymgt.handlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.apimgt.keymgt.APIKeyMgtException;
import org.wso2.carbon.apimgt.keymgt.handlers.DefaultKeyValidationHandler;
import org.wso2.carbon.apimgt.keymgt.service.TokenValidationContext;
import java.util.LinkedList;
import java.util.List;

public class CustomKeyValidationHandler extends DefaultKeyValidationHandler {
    private static Log log = LogFactory.getLog(CustomKeyValidationHandler.class);

    @Override
    public boolean validateScopes(TokenValidationContext validationContext) throws APIKeyMgtException {
        List consumerKeyWhitelist = getConsumerKeyWhitelist();
        String currentAppConsumerKey = validationContext.getTokenInfo().getConsumerKey();

        if(consumerKeyWhitelist.contains(currentAppConsumerKey)) {
            if (log.isDebugEnabled()) {
                log.debug("Skip scope validation for the consumer key: " + currentAppConsumerKey);
            }
            return true;
        } else {
            return super.validateScopes(validationContext);
        }
    }

    /**
     * Get list of consumer keys which need to be skipped during the scope validation.
     *
     * @return
     */
    private List getConsumerKeyWhitelist() {
        List<String> consumerKeyList = new LinkedList<>();
        consumerKeyList.add("12312312312313");
        consumerKeyList.add("31231232131231");
        consumerKeyList.add("cepQ5ySA7tYXB4UXNlUioaNax78a");
        return consumerKeyList;
    }
}
