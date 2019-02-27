package hu.unipannon.mik.balatoniszel.core;

import hu.unipannon.mik.balatoniszel.ws.Guest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class GuestRepository {

    List<GuestEntity> guests = new ArrayList<>();

    public List<GuestEntity> guests() {
        return Collections.unmodifiableList(guests);
    }


    public GuestEntity getGuest(String guestId) {
        return guests.stream()
                     .filter(guest -> guest.getId().equalsIgnoreCase(guestId))
                     .findFirst()
                     .orElse(null);
    }

    public GuestEntity findGuest(String name, String address, String document, String email) {
        return guests.stream()
                .filter(g -> g.getName().equalsIgnoreCase(name) &&
                             g.getAddress().equalsIgnoreCase(address) &&
                             g.getDocument().equalsIgnoreCase(document) &&
                             g.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(create(name, address, document, email));
    }

    private GuestEntity create(String name, String address, String document, String email) {
        GuestEntity guest = new GuestEntity(UUID.randomUUID().toString(), name, address, document, email);
        guests.add(guest);
        return guest;
    }

}
