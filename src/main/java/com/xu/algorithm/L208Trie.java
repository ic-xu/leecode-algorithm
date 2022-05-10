package com.xu.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxu
 * @version 1
 * @date 2022/5/7 19:41
 */
public class L208Trie {
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        boolean apple = trie.search("apple");// 返回 True
        System.out.println(apple);
        boolean app = trie.search("app");// 返回 False
        System.out.println(app);
        boolean app1 = trie.startsWith("app");// 返回 True
        System.out.println(app1);
        trie.insert("app");
        boolean app2 = trie.search("app");// 返回 True
        System.out.println(app2);

    }
}

class Trie {
    private MapTrie1 rootTrie;

    public Trie() {
        rootTrie = new MapTrie1();
    }

    public void insert(String word) {

        rootTrie.insert(word, 0);
    }

    public boolean search(String word) {
        if (null == word) {
            return false;
        }
        return rootTrie.search(word, 0);
    }

    public boolean startsWith(String prefix) {
        if (null == prefix) {
            return true;
        }
        return rootTrie.startsWith(prefix, 0);
    }
}




class MapTrie1{
    boolean hasValue = false;
    MapTrie1[] child ;
    public static char a = 'a';

    public void insert(String word, int index) {
        if(null == child){
            child  = new MapTrie1[26];
        }
        if (index >= word.length()) {
            hasValue = true;
            return;
        }
        char c = word.charAt(index);
        int arrindex = c-a;
        MapTrie1 mapTrieChile = child[arrindex];
        if(null == mapTrieChile){
            mapTrieChile = new MapTrie1();
        }
        child[arrindex] = mapTrieChile;
        mapTrieChile.insert(word, ++index);
    }

    public boolean search(String word, int index) {
        if(null ==child){
            return false;
        }
        if (index >= word.length()) {
            return hasValue;
        }

        char c = word.charAt(index);
        int arrindex = c-a;
        MapTrie1 mapTrie = child[arrindex];
        if (null == mapTrie) {
            return false;
        } else {
            return mapTrie.search(word, ++index);
        }

    }

    public boolean startsWith(String prefix, int index) {
        if(null ==child){
            return false;
        }
        if (index >= prefix.length()) {
            if(hasValue){
                return true;
            }
            for (int i = 0; i < child.length; i++) {
                if(null!=child[i]){
                    return true;
                }
            }
            return false;
        }

        char c = prefix.charAt(index);
       int arrIndex =  c-a;
        MapTrie1 mapTrie = child[arrIndex];
        if (null == mapTrie) {
            return false;
        }
        return mapTrie.startsWith(prefix, ++index);
    }

}

class MapTrie {

    private Map<Character, MapTrie> chileTrie;

    public boolean hasValue = false;


    public MapTrie() {
        chileTrie = new HashMap<>();
    }

    public void insert(String word, int index) {
        if (index >= word.length()) {
            hasValue = true;
            return;
        }
        MapTrie mapTrie1 = chileTrie.computeIfAbsent(word.charAt(index), key -> new MapTrie());
        mapTrie1.insert(word, ++index);
    }

    public boolean search(String word, int index) {
        if (index >= word.length()) {
            return hasValue;
        }
        MapTrie mapTrie = chileTrie.get(word.charAt(index));
        if (null == mapTrie) {
            return false;
        } else {
            return mapTrie.search(word, ++index);
        }

    }

    public boolean startsWith(String prefix, int index) {
        if (index >= prefix.length()) {
            return chileTrie.size() != 0 || hasValue;
        }
        MapTrie mapTrie = chileTrie.get(prefix.charAt(index));
        if (null == mapTrie) {
            return false;
        }
        return mapTrie.startsWith(prefix, ++index);
    }
}