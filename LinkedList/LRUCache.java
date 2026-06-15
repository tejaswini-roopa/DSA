import java.util.HashMap;

public class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.value = value;

            remove(node);
            insert(node);

            return;
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);

        insert(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        // Test 1: Expected [null, null, null, 1, null, -1, null, -1, 3, 4]
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));  // 1
        lru.put(3, 3);
        System.out.println(lru.get(2));  // -1
        lru.put(4, 4);
        System.out.println(lru.get(1));  // -1
        System.out.println(lru.get(3));  // 3
        System.out.println(lru.get(4));  // 4

        // Test 2: capacity 1
        LRUCache lru2 = new LRUCache(1);
        lru2.put(1, 1);
        lru2.put(2, 2);
        System.out.println(lru2.get(1)); // -1 (evicted)
        System.out.println(lru2.get(2)); // 2

        // Test 3: update existing key
        LRUCache lru3 = new LRUCache(2);
        lru3.put(1, 1);
        lru3.put(1, 10);
        System.out.println(lru3.get(1)); // 10
    }
}
