package de.fhg.ise.gateway;

import com.beanit.iec61850bean.ServiceError;
import de.fhg.ise.IEC61850.client.models.AllianderDER;
import de.fhg.ise.gateway.configuration.EmsInterfaceSettings;
import de.fhg.ise.gateway.configuration.Settings;
import de.fhg.ise.gateway.configuration.SettingsException;
import de.fhg.ise.gateway.interfaces.ems.EmsInterface;
import de.fhg.ise.gateway.interfaces.hedera.HederaApi;
import de.fhg.ise.gateway.interfaces.hedera.HederaRefresh;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

/**
 * The main application. Connects the local EMS with Alliander's HEDERA API.
 */
public class HederaEmsGateway {

    private static final Logger log = LoggerFactory.getLogger(HederaEmsGateway.class);
    public static final String INI_PATH = "hedera-interface.ini";

    public static void main(String[] args) throws SettingsException, InterruptedException, IOException, ServiceError {

        Settings settings = new Settings(new File(INI_PATH));

        HederaApi hederaApi = new HederaApi(settings);

        EmsInterface emsInterface = EmsInterfaceSettings.parseIniCreateInterface(settings.ini);
        log.debug("Parsed settings from ini to {}", emsInterface);
        try {
            // TODO: make it more explicit that these two lines actually connect HEDERA with the DER (probably by splitting up code in EmsInterface / MqttEmsInterface)
            AllianderDER der = new AllianderDER(settings.derHost, settings.derPort);
            emsInterface.start(new HederaRefresh(hederaApi, der, settings));
            log.info("Successfully started interface and set up connection between HEDERA and EMS successfully");

            while (true) {
                // Keep the app from closing, the ems interface will handle all EMS requests, so we do not need to do anything here.
                Thread.sleep(1000);
            }
        } catch (UnknownHostException e) {
            log.error("Unable to connect to host '{}'. Is the DER (docker container) running?", settings.derHost);
            System.exit(1);
        }
    }
}
