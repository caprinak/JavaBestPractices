public class LinkedListClone {
    // Recursive clone method for class with complex mutable state

    public static void main(String[] args) {
        HashTable.Entry entry1 = new HashTable.Entry(1,"abc",null);
        HashTable.Entry entry2 = new HashTable.Entry(2,"def",entry1);
        HashTable.Entry entry3= new HashTable.Entry(3,"gh",entry2);
        HashTable hashTable = new HashTable();
        hashTable.setBuckets(new HashTable.Entry[]{entry1, entry2, entry3});
        HashTable hashTableCopy = hashTable.clone();
        System.out.println(hashTableCopy);
    }
    public static class HashTable implements Cloneable {
        private Entry[] buckets ;

        public Entry[] getBuckets() {
            return buckets;
        }

        public void setBuckets(Entry[] buckets) {
            this.buckets = buckets;
        }

        public static class Entry {
            final Object key;
            Object value;
            Entry next;
            Entry(Object key, Object value, Entry next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
            // Recursively copy the linked list headed by this Entry
            Entry deepCopy() {
                return new Entry(key, value,
                        next == null ? null : next.deepCopy());
            }}

        @Override public HashTable clone() {
            try {
                HashTable result = (HashTable) super.clone();
                result.buckets = new Entry[buckets.length];
                for (int i = 0; i < buckets.length; i++)
                    if (buckets[i] != null)
                        result.buckets[i] = buckets[i].deepCopy();
                return result;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }}
        /*// clone method for extendable class not supporting Cloneable
        @Override
        protected final Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }*/


        /*To recap, all classes that implement Cloneable should override clone
        with a public method whose return type is the class itself. This method should
        first call super.clone, then fix any fields that need fixing. Typically, this
        means copying any mutable objects that comprise the internal “deep structure”
        of the object and replacing the clone’s references to these objects with references
        to their copies. While these internal copies can usually be made by calling
        clone recursively, this is not always the best approach. If the class contains
only primitive fields or references to immutable objects, then it is likely the case
        that no fields need to be fixed. There are exceptions to this rule. For example, a
        field representing a serial number or other unique ID will need to be fixed even
if it is primitive or immutable
        As a rule, copy functionality is best provided by constructors or factories. A
        notable exception to this rule is arrays, which are best copied with the clone
        method

*/
    }
}
