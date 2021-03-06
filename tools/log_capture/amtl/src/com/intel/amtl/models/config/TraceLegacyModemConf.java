/* Android AMTL
 *
 * Copyright (C) Intel 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.intel.amtl.models.config;

import com.intel.amtl.log.AlogMarker;
import com.intel.amtl.models.config.LogOutput;
import com.intel.amtl.models.config.ModemConf;

public class TraceLegacyModemConf extends ModemConf {

    public TraceLegacyModemConf(LogOutput config) {
        super(config);
        AlogMarker.tAB("TraceLegacyModemConf.TraceLegacyModemConf", "0");
        AlogMarker.tAE("TraceLegacyModemConf.TraceLegacyModemConf", "0");
    }

    public TraceLegacyModemConf(String xsio, String trace, String xsystrace, String flcmd,
            String octMode) {
        super(xsio, trace, xsystrace, flcmd, octMode);
        AlogMarker.tAB("TraceLegacyModemConf.TraceLegacyModemConf", "0");
        AlogMarker.tAE("TraceLegacyModemConf.TraceLegacyModemConf", "0");
    }

    @Override
    public boolean confTraceEnabled() {
        AlogMarker.tAB("TraceLegacyModemConf.confTraceEnabled", "0");
        AlogMarker.tAE("TraceLegacyModemConf.confTraceEnabled", "0");
        return !getTrace().equals("0");
    }

    @Override
    public void activateConf(boolean activate) {
        AlogMarker.tAB("TraceLegacyModemConf.activateConf", "0");
        this.atTrace = (activate) ? "AT+TRACE=1\r\n" : "AT+TRACE=0\r\n";
        AlogMarker.tAE("TraceLegacyModemConf.activateConf", "0");
    }
}
