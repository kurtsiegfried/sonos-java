package org.tensin.sonos.commands;

import org.tensin.sonos.upnp.Sonos;
import org.tensin.sonos.upnp.SonosException;
import org.tensin.sonos.upnp.SonosItem;
import org.tensin.sonos.upnp.SonosListener;

public class CommandList extends AbstractCommand implements IZoneCommand, SonosListener {

    @Override
    public void execute(final Sonos sonos) throws SonosException {
        if (hasArgs()) {
            sonos.browse(getArgs().get(0), this);
        }
    }

    @Override
    public String getName() {
        return "list";
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.tensin.sonos.upnp.SonosListener#updateDone(java.lang.String)
     */
    @Override
    public void updateDone(final String id) {
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.tensin.sonos.upnp.SonosListener#updateItem(java.lang.String, int, org.tensin.sonos.upnp.SonosItem)
     */
    @Override
    public void updateItem(final String id, final int idx, final SonosItem item) {
        System.out.println("(" + idx + ")\t    id: " + item.idURI);
        System.out.println("\t   res: " + item.playURI);
        System.out.println("\t title: " + item.title);
        if (item.album != null) {
            System.out.println("\t album: " + item.album);
        }
        if (item.artist != null) {
            System.out.println("\tartist: " + item.artist);
        }
    }
}
