package com.company;

import java.util.*;

public class rede {
    ArrayList<perfil> usuarios;
    List<comunidade> comunidades;
    public rede(){
        this.usuarios = new ArrayList<>();
        this.comunidades = new List<comunidade>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<comunidade> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(comunidade comunidade) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends comunidade> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends comunidade> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public comunidade get(int index) {
                return null;
            }

            @Override
            public comunidade set(int index, comunidade element) {
                return null;
            }

            @Override
            public void add(int index, comunidade element) {

            }

            @Override
            public comunidade remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<comunidade> listIterator() {
                return null;
            }

            @Override
            public ListIterator<comunidade> listIterator(int index) {
                return null;
            }

            @Override
            public List<comunidade> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }
}
