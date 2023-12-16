package com.whiteknightz.demo;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class SolutionTest1 {



    public class Book {
        private String id = UUID.randomUUID().toString();
        private String sheleve;
        private String title;
        private String author;

        public Book(String sheleve, String title, String author){
            this.title = title;
            this.author = author;
            this.sheleve = sheleve;
        }

        public void printTitleUniqueInFirst(List<Book> A, List<Book> B){
            Set<String> collection1 = A.stream().map(book-> book.title+" by "+book.author).collect(Collectors.toSet());
            Set<String> collection2 = B.stream().map(book-> book.title+" by "+book.author).collect(Collectors.toSet());
            for(String s : collection1){
                if(!collection2.contains(s)){
                    System.out.println(s);
                }
            }
        }
    }
}
