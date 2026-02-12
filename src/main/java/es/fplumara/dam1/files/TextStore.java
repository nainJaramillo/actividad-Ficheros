package es.fplumara.dam1.files;

import es.fplumara.dam1.model.Message;

public interface TextStore {
    void save(Message message);
    String readAll();
    String readLast (int n);
}
