package org.tensin.sonos.commands;

import org.tensin.sonos.upnp.Sonos;
import org.tensin.sonos.upnp.SonosException;

public class CommandGetXPort extends AbstractCommand implements IZoneCommand {

    @Override
    public void execute(final Sonos sonos) throws SonosException {
        String x = sonos.getTransportURI();
        System.out.println(x);
    }

    @Override
    public String getName() {
        return "getxport";
    }

}
