package com.example.simplecrudphonebookapp.contacts;

import java.util.Optional;

public class ContactRepositoryImpl implements ContactRepository {
    @Override
    public <S extends Contacts> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Contacts> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Contacts> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Contacts> findAll() {
        return null;
    }

    @Override
    public Iterable<Contacts> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Contacts entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Contacts> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
