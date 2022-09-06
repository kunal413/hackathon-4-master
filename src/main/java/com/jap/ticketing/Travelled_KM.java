package com.jap.ticketing;

import java.util.Comparator;

public class Travelled_KM implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.getTravelled_KM() == o2.getTravelled_KM()) {
            return 0;
        } else if (o1.getTravelled_KM() > o2.getTravelled_KM()) {
            return -1;
        } else {
            return 1;
        }
    }
}
