package Concurrency;

import Basics.ForwardingSet;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    @FunctionalInterface public interface SetObserver<E> {
        // Invoked when an element is added to the observable set
        void added(ObservableSet<E> set, E element);
    }
    // Broken - invokes alien method from synchronized block!
    public static class ObservableSet<E> extends ForwardingSet<E> {
        public ObservableSet(Set<E> set) { super(set); }
        private final List<SetObserver<E>> observers
                = new ArrayList<>();
        public void addObserver(SetObserver<E> observer) {
            synchronized(observers) {
                observers.add(observer);
            }}
        public boolean removeObserver(SetObserver<E> observer) {
            synchronized(observers) {
                return observers.remove(observer);
            }}
       /* private void notifyElementAdded(E element) {
            synchronized(observers) {
                for (SetObserver<E> observer : observers)
        *//* Invoking alien methods from within synchronized regions has caused many
        deadlocks in real systems, such as GUI toolkits*//*

                    observer.added(this, element);
            }}*/
        // Alien method moved outside of synchronized block - open calls
        private void notifyElementAdded(E element) {
            List<SetObserver<E>> snapshot = null;
            synchronized(observers) {
                snapshot = new ArrayList<>(observers);
            }
            for (SetObserver<E> observer : snapshot)
            observer.added(this, element);
        }



        @Override
        public boolean add(E element) {
            boolean added = super.add(element);
            if (added)
                notifyElementAdded(element);
            return added;
        }
        @Override
        public boolean addAll(Collection<? extends E> c) {
            boolean result = false;
            for (E element : c)
                result |= add(element); // Calls notifyElementAdded
            return result;
        }
    }
    public static void main(String[] args) {
        ObservableSet<Integer> set =
                new ObservableSet<>(new HashSet<>());
   /*     set.addObserver((s, e) -> System.out.println(s + " - " + e));
        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println("***************" + e);
                if (e == 23)
                    s.removeObserver(this);
            }}
        );*/

        // Observer that uses a background thread needlessly -> deadlock
        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ExecutorService exec =
                            Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> s.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });
        for (int i = 0; i < 100; i++){
            set.add(i);
            if(i > 1)
                set.remove(i-1);
        }
    }
    }

