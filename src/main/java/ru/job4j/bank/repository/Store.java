package ru.job4j.bank.repository;

import ru.job4j.bank.model.Id;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Store abstract repository
 *
 * @param <T> Generic object type
 * @author itfedorovsa (itfedorovsa@gmail.com)
 * @version 1.0
 * @since 02.04.23
 */
public abstract class Store<T extends Id> {

    protected Map<Integer, T> store = new ConcurrentHashMap<>();

    protected AtomicInteger idGenerator = new AtomicInteger(0);

    public T saveOrUpdate(T model) {
        if (store.containsKey(model.getId())) {
            store.put(model.getId(), model);
            return model;
        }
        int id = idGenerator.incrementAndGet();
        model.setId(id);
        return store.put(id, model);
    }

    public Optional<T> delete(int id) {
        return Optional.ofNullable(store.remove(id));
    }

    public List<T> findAll() {
        return new CopyOnWriteArrayList<>(store.values());
    }

    public Optional<T> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }

}