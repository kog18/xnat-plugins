package org.nrg.xnat.biomedia.userAttributes.turbine.modules.actions;

import org.apache.log4j.Logger;
import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;
import org.nrg.xdat.turbine.modules.actions.SecureAction;
import org.nrg.xdat.turbine.utils.TurbineUtils;
import org.nrg.xft.security.UserI;

/**
 * Created by gmlenz on 24/11/16.
 */
public class AcceptTerms extends SecureAction {
    static Logger logger = Logger.getLogger(AcceptTerms.class);

    @Override
    public void doPerform(RunData data, Context context) throws Exception {

        logger.error("AcceptTerms.java / doPerfom");

        UserI user = TurbineUtils.getUser(data);

        logger.error(user.getFirstname());

        data.setMessage("It works omg.");

        data.setScreenTemplate("Index.vm");
    }
}